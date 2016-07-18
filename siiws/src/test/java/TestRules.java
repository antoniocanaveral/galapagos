/**
 * Created by acanaveral on 15/6/16.
 */

import com.bmlaurus.ws.dinardap.CNE;
import org.junit.Test;

public class TestRules {

    @Test
    public void EvaluateRules(){
        /*try {
            //System.out.print(new Cgg_regla_validacion().ejecutarReglaTipoSolicitud("[{\"CRVAL_APROBADO\":\"FALSE\",\"CRVAL_VALOR_2\":null,\"CRVAL_USUARIO_UPDATE\":\"recepcion\",\"CRVAL_VALOR_1\":null,\"CRVAR_FECHA_FIN\":\"2011-04-09 00:00:00.0\",\"CRVAL_FUNCION_VALIDACION\":\"com.bmlaurus.rule.DinardapMarriedValidator\",\"CRVAL_OPERADOR_COMPARADOR\":\"=\",\"CRVAL_DESCRIPCION\":\"Verifica si una residente esta observado\",\"CRVAL_ESTADO\":true,\"CRVAR_FECHA_INICIO\":\"2011-04-09 00:00:00.0\",\"CRVAL_CODIGO\":\"CRVAL8\",\"CRTSE_CAMPO_EVALUACION\":\"[{\\\"IN_CRPER_CODIGO\\\":\\\"1103\\\"}]\",\"CRVAL_VALOR_LIBRE\":\"TRUE\",\"CRVAL_TIPO\":1,\"CRVAL_SUGERENCIA\":\"El auspiciante del tramite se encuentra observado por lo que primero debe de acercarse a las oficinas del CGG a normalizar su situacion.\",\"CRVAL_FECHA_INSERT\":\"2011-04-09 14:46:37.85179\",\"CRVAL_USUARIO_INSERT\":\"recepcion\",\"CRVAL_FECHA_UPDATE\":\"2011-04-09 14:46:37.85179\",\"CGCNF_CODIGO\":null,\"CRVAL_NOMBRE\":\"Residente observado\",\"CRVAL_RESULTADO_ACEPTACION\":\"TRUE\"}]"));
            System.out.println(new Cgg_regla_validacion().ejecutarReglaTipoSolicitud("[{\"CRVAL_FUNCION_VALIDACION\":\"F_ANIOS_BENEFICIARIO\",\"CRVAL_CODIGO\":\"CRVAL18\",\"CRVAL_USUARIO_INSERT\":\"tct1\",\"CRVAL_USUARIO_UPDATE\":\"tct10\",\"CRVAL_DESCRIPCION\":\"Verifica si una persona es menor o igual que la edad permitida para realizacion de tramites de residencia por desendencia.\",\"CRVAL_RESULTADO_ACEPTACION\":\"TRUE\",\"CRVAL_VALOR_LIBRE\":\"\",\"CRVAR_FECHA_INICIO\":\"2011-04-08 01:00:00.0\",\"CRVAL_OPERADOR_COMPARADOR\":\"<=\",\"CGCNF_CODIGO\":\"CONF21\",\"CRVAL_TIPO\":1,\"CRVAL_SUGERENCIA\":\"La persona o beneficiario especificado no cumple con la edad para obtener una residencia por desendencia.\",\"CRVAL_NOMBRE\":\"Maximo anios persona\",\"CRVAL_FECHA_UPDATE\":\"2011-05-07 12:18:48.000302\",\"CRVAR_FECHA_FIN\":\"2011-04-08 01:00:00.0\",\"CRVAL_FECHA_INSERT\":\"2011-04-10 02:33:00.515996\",\"CRTSE_CAMPO_EVALUACION\":\"[{\\\"IN_CRPER_FECHA_NACIMIENTO\\\":\\\"2016-05-06 00:00:00.0\\\"}]\",\"CRVAL_ESTADO\":true},{\"CRVAL_FUNCION_VALIDACION\":\"F_RESIDENTE_PERMANENTE\",\"CRVAL_CODIGO\":\"CRVAL27\",\"CRVAL_USUARIO_INSERT\":\"patricia\",\"CRVAL_USUARIO_UPDATE\":\"patricia\",\"CRVAL_DESCRIPCION\":\"Verifica si el auspiciante es residente permanente\",\"CRVAL_RESULTADO_ACEPTACION\":\"TRUE\",\"CRVAL_VALOR_LIBRE\":\"TRUE\",\"CRVAR_FECHA_INICIO\":\"2011-11-07 01:00:00.0\",\"CRVAL_OPERADOR_COMPARADOR\":\"=\",\"CRVAL_TIPO\":1,\"CRVAL_SUGERENCIA\":\"El auspiciante no es residente permanente\",\"CRVAL_NOMBRE\":\"Residente permanente - Auspiciante\",\"CRVAL_FECHA_UPDATE\":\"2011-11-07 18:59:26.192269\",\"CRVAR_FECHA_FIN\":\"2011-11-07 01:00:00.0\",\"CRVAL_FECHA_INSERT\":\"2011-11-07 18:59:26.192269\",\"CRTSE_CAMPO_EVALUACION\":\"[{\\\"IN_CRPER_CODIGO\\\":\\\"CRPER766800\\\"}]\",\"CRVAL_ESTADO\":true}]",null));
        } catch (SOAPException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/

        ///REPORT ATTACHMENT

        CNE cne = new CNE("1710679968");
        if(cne.callServiceAsObject().equals(CNE.CALL_OK)){
            System.out.println(cne.toString());
        }
        /*RegistroCivil registroCivil = new RegistroCivil("1710679968");
        if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_OK)){
            System.out.println(registroCivil.toString());
            CreateRCAttachment attachment = new CreateRCAttachment(registroCivil,"CRPER766646");
            try {
                attachment.attachReport();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}
