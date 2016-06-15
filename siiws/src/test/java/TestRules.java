/**
 * Created by acanaveral on 15/6/16.
 */

import com.besixplus.sii.ws.Cgg_regla_validacion;
import org.junit.Test;

import javax.xml.soap.SOAPException;

public class TestRules {

    @Test
    public void EvaluateRules(){
        try {
            System.out.print(new Cgg_regla_validacion().ejecutarReglaTipoSolicitud("[{\"CRVAL_APROBADO\":\"FALSE\",\"CRVAL_VALOR_2\":null,\"CRVAL_USUARIO_UPDATE\":\"recepcion\",\"CRVAL_VALOR_1\":null,\"CRVAR_FECHA_FIN\":\"2011-04-09 00:00:00.0\",\"CRVAL_FUNCION_VALIDACION\":\"com.bmlaurus.rule.DinardapMarriedValidator\",\"CRVAL_OPERADOR_COMPARADOR\":\"=\",\"CRVAL_DESCRIPCION\":\"Verifica si una residente esta observado\",\"CRVAL_ESTADO\":true,\"CRVAR_FECHA_INICIO\":\"2011-04-09 00:00:00.0\",\"CRVAL_CODIGO\":\"CRVAL8\",\"CRTSE_CAMPO_EVALUACION\":\"[{\\\"IN_CRPER_CODIGO\\\":\\\"1103\\\"}]\",\"CRVAL_VALOR_LIBRE\":\"TRUE\",\"CRVAL_TIPO\":1,\"CRVAL_SUGERENCIA\":\"El auspiciante del tramite se encuentra observado por lo que primero debe de acercarse a las oficinas del CGG a normalizar su situacion.\",\"CRVAL_FECHA_INSERT\":\"2011-04-09 14:46:37.85179\",\"CRVAL_USUARIO_INSERT\":\"recepcion\",\"CRVAL_FECHA_UPDATE\":\"2011-04-09 14:46:37.85179\",\"CGCNF_CODIGO\":null,\"CRVAL_NOMBRE\":\"Residente observado\",\"CRVAL_RESULTADO_ACEPTACION\":\"TRUE\"}]"));
        } catch (SOAPException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
