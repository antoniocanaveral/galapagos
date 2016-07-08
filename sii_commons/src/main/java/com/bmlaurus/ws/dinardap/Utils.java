package com.bmlaurus.ws.dinardap;

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


}
