import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.junit.Test;

/**
 * Created by acanaveral on 29/6/16.
 */
public class TestDinardap {

    @Test
    public void ServiceTestet(){

        RegistroCivil registroCivil = new RegistroCivil("1757078983");
        System.out.println(registroCivil.callServiceAsObject());
        System.out.println(registroCivil.toString());
        //System.out.print("OK");
        //DinardapService cne = new CNE("1002867800");
        //System.out.println(cne.callServiceAsObject());
/*
        CNE cne = new CNE("0923178321");
        System.out.println(cne.callServiceAsObject());
        System.out.println(cne.toString());
*/
        //JSONObject kk =  new JSONObject(new Gson().toJson(registroCivil));
       // System.out.println(kk.getString("cedula"));

        /*final Map<String,String> param = new HashMap<>();
        param.put("CRRST_CODIGO", "CRRST72801");
        param.put("REPORT_NAME" , "rptResolucionDefault");
        param.put("CRRES_CODIGO", "CRRES44177");
        param.put("CRTRA_CODIGO", "CRTRA67710");
        BackendInvoker backendInvoker = new BackendInvoker();
        try {
            backendInvoker.invokeBackendServlet("ReportToAlfrescoSVR", "POST", new Gson().toJson(param));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


}
