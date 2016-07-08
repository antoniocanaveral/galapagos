# Fases. Funciones Java

Todos los archivos .jar que se incluyan en la carpeta $SII_HOME/rules se agregaran al classpath al momento de evaluar una fase que tenga funciones.

Las funciones se definen en la base de datos, tal como se hace con las funciones actuales.

Deben cumplir con la condición de encontrarse en el paquete com.bmlaurus.phaserule e implementar RulePhase

<pre>   
   public class GenerarResolucion implements RulePhase {
       @Override
       public String executeRule(Cgg_res_seguimiento objSeguimiento, Cgg_res_tramite tramite, String inUserName) {
           return null;
       }
   }
</pre>

Para la regla de Resolución, existe un archivo en SII_HOME/rules/resolucion.properties donde se parametriza el reporte a utilizar como resolución para cada tipo de solicitud.