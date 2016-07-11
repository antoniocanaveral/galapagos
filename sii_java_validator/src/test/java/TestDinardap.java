import com.bmlaurus.ws.dinardap.RegistroCivil;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by acanaveral on 29/6/16.
 */
public class TestDinardap {

    @Test
    public void ServiceTestet(){

        RegistroCivil registroCivil = new RegistroCivil("1716264450");
        System.out.println(registroCivil.callServiceAsObject());
        System.out.println(new Gson().toJson(registroCivil));
        //System.out.print("OK");
        //DinardapService cne = new CNE("1002867800");
        //System.out.println(cne.callServiceAsObject());

        JSONObject kk =  new JSONObject(new Gson().toJson(registroCivil));
        System.out.println(kk.getString("cedula"));
    }


}
