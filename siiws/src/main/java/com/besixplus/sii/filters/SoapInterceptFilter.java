package com.besixplus.sii.filters;

import com.bmlaurus.camel.CamelSingleton;
import com.bmlaurus.invoker.BackEndInvokerVoParameter;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HW on 8/17/16.
 */
public class SoapInterceptFilter implements Filter {

    private static Logger logger = Logger.getLogger("SoapInterceptFilter");

    @EJB
    CamelSingleton camelSingleton;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean doChain = true;
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            try {
                SoapInterceptRequestWrapper myRequestWrapper = new SoapInterceptRequestWrapper(request);
                callIntegration(myRequestWrapper);
                doChain = false;
                filterChain.doFilter(myRequestWrapper, servletResponse);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        if (doChain) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    private void callIntegration(SoapInterceptRequestWrapper myRequestWrapper) {
        String body = myRequestWrapper.getBody();
        String sendCamel = myRequestWrapper.getHeader(Constants.HEADER_SENDCAMEL);
        String headerAuthorization = myRequestWrapper.getHeader(Constants.HEADER_AUTHORIZATION);
        if (body != null && !body.isEmpty() && body.contains(Constants.SOAP_ENVELOPE_STR) &&
                !Constants.TRUE.equals(sendCamel) && headerAuthorization != null && !headerAuthorization.isEmpty()) {
            String passwordEncoded = getPasswordFromHeaderParam(headerAuthorization);
            String[] userAndPasswordArray = decodeUserPassword(passwordEncoded);
            if (userAndPasswordArray != null) {
                String username = userAndPasswordArray[0];
                String password = userAndPasswordArray[1];
                String url = myRequestWrapper.getRequestURL().toString();
                String uri = myRequestWrapper.getRequestURI();
                String contextPath = myRequestWrapper.getContextPath();

                String className = getClassFromUri(uri, contextPath);
                String methodName = getMethodFromRequestPayload(body);

                if (verifyNotEmptyAndMethodExistInList(className, methodName)) {
                    BackEndInvokerVoParameter param = new BackEndInvokerVoParameter();
                    param.setMethod("POST");
                    param.setPassword(password);
                    param.setUsername(username);
                    param.setUrl(url);
                    param.setPayload(body);
                    param.setSoapClassName(className);
                    param.setSoapMethodName(methodName);
                    camelSingleton.camelSendMsg(param);
                    logger.info("INGRESO SI ES UNA LLAMADA SOAP ENVIANDO MENSAJE CON LA CLASE:" + className +" METODO: " + methodName);
                }
            }
        }
    }

    private boolean verifyNotEmptyAndMethodExistInList(String className, String methodName) {
        boolean result = false;
        if (!areEmptyClassNameMethodName(className, methodName)) {
            HashMap<String, List<String>> mapClassMethod=camelSingleton.getClasesMetodosIntegrados();
            if(!mapClassMethod.isEmpty()){
                List<String> methodList = mapClassMethod.get(className);
                if(methodList != null && !methodList.isEmpty())
                {
                    for(String method:methodList){
                        if(methodName.equals(method)){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean areEmptyClassNameMethodName(String className, String methodName) {
        boolean result = true;
        if (className != null && !className.isEmpty() && methodName != null && !methodName.isEmpty()) {
            result = false;
        }
        return result;
    }

    public String getPasswordFromHeaderParam(String headerParam) {
        String passwordEncoded = null;
        if (headerParam != null && !headerParam.isEmpty()) {
            String[] authenticationArray = headerParam.split("\\ ");
            if (authenticationArray != null && authenticationArray.length == 2) {
                passwordEncoded = authenticationArray[1];
            }
        }
        return passwordEncoded;
    }

    private String[] decodeUserPassword(String password) {
        String[] passwordDecoded = null;
        if (password != null && !password.isEmpty()) {
            byte[] decoded = Base64.getDecoder().decode(password);
            if (decoded != null && decoded.length > 0) {
                String passTemp = new String(decoded, StandardCharsets.UTF_8);
                if (passTemp != null && !passTemp.isEmpty()) {
                    String passTempArray[] = passTemp.split(":");
                    if (passTempArray != null && passTempArray.length == 2) {
                        passwordDecoded = passTempArray;
                    }
                }
            }
        }
        return passwordDecoded;
    }

    private String getMethodFromRequestPayload(String xmlPayload) {
        String methodName = null;
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document doc = saxBuilder.build(new StringReader(xmlPayload));
            Element rootElement = doc.getRootElement();
            List<Content> listContent = rootElement.getContent();
            for (Content content : listContent) {
                if (content instanceof Element) {
                    Element element = (Element) content;
                    String name = element.getName();
                    if ("Body".equals(name)) {
                        List<Content> methodContentList = element.getContent();
                        for (Content methodContent : methodContentList) {
                            if (methodContent instanceof Element) {
                                Element methodElement = (Element) methodContent;
                                String methodNameTemp = methodElement.getName();
                                if (methodNameTemp != null && !methodNameTemp.isEmpty()) {
                                    methodName = methodNameTemp;
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo obtener el nombre del metodo", e);
        }
        return methodName;
    }


    private String getClassFromUri(String uri, String context) {
        String className = null;
        String classNameTemp = uri.replace(context + "/", "");
        String classNameArray[] = classNameTemp.split("\\?");
        if (classNameArray != null && classNameArray.length > 0) {
            className = classNameArray[0];
        }
        return className;
    }

    @Override
    public void destroy() {

    }
}


interface Constants {
    String SOAP_ENVELOPE_STR = "soapenv:Envelope";
    String HEADER_SENDCAMEL = "sendByCamel";
    String HEADER_AUTHORIZATION = "Authorization";
    String TRUE = "true";
}
