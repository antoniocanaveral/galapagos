import com.bmlaurus.ws.dinardap.Utils;
import org.junit.Test;

/**
 * Created by acanaveral on 10/7/16.
 */
public class TestUtils {

    @Test
    public void TestParientes(){
        String persona = "GIL RAMOS TAMIA LUCIA";
        String padre = "";
        String madre = "";

        String paterno = Utils.getParentezco(padre,persona);
        String materno = Utils.getParentezco(madre,persona.substring(paterno.length()));

        String nombre = persona.substring(paterno.length()+1+materno.length());

        if(paterno.length()==0 && materno.length()==0){//No tiene padres. Que decida el usuario
            paterno = persona;
            materno = persona;
        }
        if(paterno.length()==0 && materno.length()>0){//No tiene padre. Dividimos los apellidos maternos
            String apellidos[] = materno.split(" ");
            if(apellidos.length>=2){
                paterno = apellidos[0];
                materno = materno.substring(paterno.length()+1);
            }
        }
        if(materno.length()==0 && paterno.length()>0){//No tiene madre. Dividimos los apellidos paternos
            String apellidos[] = paterno.split(" ");
            if(apellidos.length>=2){
                String tmp1 = apellidos[0];
                materno = paterno.substring(tmp1.length()+1);
                paterno = tmp1;
            }
        }

        System.out.println(paterno +"-" + materno + "--" +nombre);
    }
}
