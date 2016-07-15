import com.bmlaurus.invoker.BackendInvoker;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acanaveral on 29/6/16.
 */
public class TestDinardap {

    @Test
    public void ServiceTestet(){

        //RegistroCivil registroCivil = new RegistroCivil("2000043634");
        //System.out.println(registroCivil.callServiceAsObject());
        //System.out.println(new Gson().toJson(registroCivil));
        //System.out.print("OK");
        //DinardapService cne = new CNE("1002867800");
        //System.out.println(cne.callServiceAsObject());

        //JSONObject kk =  new JSONObject(new Gson().toJson(registroCivil));
       // System.out.println(kk.getString("cedula"));

        final Map<String,String> param = new HashMap<>();
        param.put("CRRST_CODIGO", "CRRST72801");
        param.put("REPORT_NAME", "rptDinardapCedula");
        param.put("CRRES_CODIGO","123");
        param.put("CRTRA_CODIGO","456");
        BackendInvoker backendInvoker = new BackendInvoker();
        try {
            backendInvoker.invokeBackendServlet("ReportToAlfrescoSVR","POST",new Gson().toJson(param));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
