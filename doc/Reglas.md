# Reglas Java

Todos los archivos .jar que se incluyan en la carpeta $SII_HOME/rules se agregaran al classpath al momento de evaluar una regla.

Las reglas se definen en la base de datos, tal como se hace con las reglas que invocan a funciones.

Deben cumplir con la condición de encontrarse en el paquete com.bmlaurus.rule e implementar RuleClass

<pre>   
   public class DinardapMarriedValidator implements RuleClass {
       @Override
       public String executeRule(Cgg_regla_validacion_metadatos metadata) {
           return null;
       }
   }
</pre>