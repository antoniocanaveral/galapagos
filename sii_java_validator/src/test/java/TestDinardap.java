import com.bmlaurus.ws.dinardap.CNE;
import org.junit.Test;

/**
 * Created by acanaveral on 29/6/16.
 */
public class TestDinardap {

    @Test
    public void ServiceTestet(){

/*         RegistroCivil registroCivil = new RegistroCivil("1752679405");
        System.out.println(registroCivil.callServiceAsObject());
        System.out.println(registroCivil.toString());

       SRI sri = new SRI("1710679968001");
        sri.callServiceAsObject();
        System.out.println(sri);

        //System.out.print("OK");
        //DinardapService cne = new CNE("1002867800");
        //System.out.println(cne.callServiceAsObject());
*/
        CNE cne = new CNE("1752679405");
        System.out.println(cne.callServiceAsObject());
        System.out.println(cne.toString());

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
