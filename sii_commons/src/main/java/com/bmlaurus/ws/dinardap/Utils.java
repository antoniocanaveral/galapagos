package com.bmlaurus.ws.dinardap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmlaurus on 08/07/16.
 */
public class Utils {

    public static String[] lastname(String nameSon, String nameFather, String nameMother){

        String[] arrayNameSon = nameSon.split(" ");
        String[] arrayNameFather = nameFather.split(" ");
        String[] arrayNameMother = nameMother.split(" ");
        String[] arrayNameCom = new String[0];
        String nameComF = "";
        String nameComM="";
        String nameComH="";
        int j=0;

        for (int i = 0; i < arrayNameSon.length; i++) {

            if (arrayNameSon[i] == arrayNameFather[i]) {

                nameComF = nameComF + " " + arrayNameSon[i];

            } else{
                if (arrayNameSon[i] == arrayNameMother[j]){

                    nameComM = nameComM + " " + arrayNameSon[i];
                    j=j+1;

                }else {

                    nameComH=nameComH + " " + arrayNameSon[i];

                }

             }

        }

        arrayNameCom[0]=nameComF;
        arrayNameCom[1]=nameComM;
        arrayNameCom[2]=nameComH;


        return arrayNameCom;
    }


    public static List<String> buildNombresApellidos(String persona, String padre, String madre){
        String paterno = Utils.getParentezco(padre,persona);
        String materno = Utils.getParentezco(madre,persona.substring(paterno.length()));

        String nombre = persona.substring(paterno.length()+1+materno.length());

        if(paterno.length()==0 && materno.length()==0){//No tiene padres. Que decida el usuario
            paterno = "";
            materno = "";
            nombre = "";
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

        List<String> result = new ArrayList<>();
        result.add(paterno);
        result.add(materno);
        result.add(nombre);

        return result;
    }

    private static String getParentezco(String padre, String persona){
        //Spliteamos ambos arrays y vamos comparando hasta que dejen de coincidir.
        //Devolvemos la coincidencia
        String buffer = null;
        StringBuilder coincidencia = new StringBuilder();
        if(padre != null && persona != null){
            if(persona.startsWith(" "))
                persona = persona.substring(1);
            String[] personaSplit = persona.split(" ");
            if(personaSplit.length<=0)
                return persona;
            buffer="";
            if(personaSplit.length>1) {
                for (int i = 0; i < personaSplit.length; i++) {
                    buffer = buffer + personaSplit[i];
                    if(padre.startsWith(buffer)){
                        coincidencia.append(personaSplit[i]);
                        coincidencia.append(" ");
                        buffer = buffer+" ";
                    }
                }
            }
        }
        String retVal = "";
        if(coincidencia.length()>0 && coincidencia.lastIndexOf(" ")==coincidencia.toString().length()-1)
            coincidencia.deleteCharAt(coincidencia.lastIndexOf(" "));

        retVal =  coincidencia.toString();

        return retVal;
    }

}
