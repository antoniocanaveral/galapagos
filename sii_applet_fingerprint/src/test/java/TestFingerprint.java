/**
 * Created by acanaveral on 10/8/16.
 */

import com.bmlaurus.nbio.api.Device;
import com.bmlaurus.nbio.api.entity.Enrollment;
import com.nitgen.SDK.BSP.NBioBSPJNI;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFingerprint {

    @Test
    public void Test(){
        Device bpt = new Device();

        //Iniciamos los dispositivos
        if(bpt.initDevice()){
            //Configuramos la ventana de enrolamiento
            bpt.configureEnrollment().fingersDisable(Enrollment.FINGER_R_INDEX,Enrollment.FINGER_L_INDEX).hideWelcomeWindow().hideTopMostWindow().setCancellMessage("A message");
            //Ejecutamos enroll
            NBioBSPJNI.FIR_HANDLE handle;
            Map<String,List> enrollementData = bpt.enroll(new Integer("1710679968"));
            if(enrollementData!=null) {
                //Aqui guardamos la data. Puede ser el binario o en texto. (preferible texto)

                System.out.println("A GURDAR: ");
                System.out.println((String) enrollementData.get("TEXT").get(0));
                System.out.println("");

                //Validacion
                boolean match = false;
                //Validacion sin captura previa
                //match = bpt.verifyMatch( (byte[]) ( (ExportDataHandler) enrollementData.get("DATA").get(0)).getData(),0);
                //System.out.println("Verificado Sin Captura: " + match);

                //Captura y Validacion
                //Configuramos la ventana de captura
                bpt.configureCaptureOpt().hideTopMostWindow().setCancellMessage("Another message");
                String captured = bpt.captureFinger();
                match = false;
                for (String data: (List<String>) enrollementData.get("TEXT")){
                    match = bpt.verifyMatch(data,captured);
                    System.out.println("Verificado Con Captura: " + match);
                    if(match)
                        break;
                    else
                        System.err.print(bpt.getErrorInterceptor().getMessage());
                }

                //Busqueda
                //Borramos la data previamente cargada
                bpt.clearDataBase();
                //Generamos nueva data
                Map<Integer,String> importedData = new HashMap<>();
                importedData.put(new Integer("1710679968"),(String) enrollementData.get("TEXT").get(0));
                //Cargamos la data en la base indexada
                bpt.loadIndexedDatabase(importedData);
                //Mandamos a buscar en la base indexada
                System.out.println("");
                System.out.println("** BUSQUEDA INDEXADA **");
                NBioBSPJNI.IndexSearch.FP_INFO info = bpt.searchIndexedFinger(captured,0);
                if(info!=null) {
                    System.out.println("Persona ID: " + info.ID);
                    System.out.println("Numero de Dedo: " + info.FingerID);
                    System.out.println("Sample: " + info.SampleNumber);
                }else
                    System.err.print(bpt.getErrorInterceptor().getMessage());


            }else
                System.err.print(bpt.getErrorInterceptor().getMessage());
        }
        bpt.closeAndDispose();

    }
}
