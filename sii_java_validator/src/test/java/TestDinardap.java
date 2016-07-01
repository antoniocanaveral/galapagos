import com.bmlaurus.ws.dinardap.CNE;
import com.bmlaurus.ws.dinardap.DinardapService;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.junit.Test;

/**
 * Created by acanaveral on 29/6/16.
 */
public class TestDinardap {

    @Test
    public void ServiceTestet(){
        DinardapService registroCivil = new RegistroCivil("1002867800");
        System.out.println(registroCivil.callServiceAsObject());
        DinardapService cne = new CNE("1002867800");
        System.out.println(cne.callServiceAsObject());
    }


}
