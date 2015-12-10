/*
* instanciacion basica para utilizacion de Serializacion JSON
* */
var JSON = JSON || {};
 JSON.stringify = JSON.stringify || function (obj) {
	var t = typeof (obj);
	if (t != "object" || obj === null) {
		// simple data type
		if (t == "string") obj = '"'+obj+'"';
		return String(obj);
	}
	else {
		// recurse array or object
		var n, v, json = [], arr = (obj && obj.constructor == Array);
		for (n in obj) {
			v = obj[n]; t = typeof(v);
			if (t == "string") v = '"'+v+'"';
			else if (t == "object" && v !== null) v = JSON.stringify(v);
			json.push((arr ? "" : '"' + n + '":') + String(v));
		}
		return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
	}
};

JSON.parse = JSON.parse || function (str) {
	if (str === "") str = '""';
	eval("var p=" + str + ";");
	return p;
};
 

/***
 * Valida un numero de cedula ingresado
 * */

function validarCedula(inCedula)
{
    var array = inCedula.split("") ;
    var num = array.length;
    var total;
    var digito;
    var mult;
    var decena;
    var end;

    if(num == 10)
    {
        total = 0;
        digito = (array[9]*1);
        for( var i = 0; i<(num-1);i++)
        {
            mult = 0;
            if((i%2) != 0)
            {
                total = total + (array[i]*1);
            }
            else
            {
                mult = array[i]*2;
                if( mult > 9)
                {
                    total = total + (mult - 9);
                }
                else
                {
                    total = total + mult;
                }
            }

        }
        decena = total/10;
        decena = Math.floor(decena);
        decena = ( decena + 1 ) * 10;
        end = ( decena - total ) ;
        if((end == 10 && digito == 0)|| end == digito)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false;
    }
} 
/***
 * Verifica si el formato de fecha es valida
 * */
var dtCh= "/";
var minYear=1900;
var maxYear=new Date().getFullYear();
function isInteger(s){
    var i;
    for (i = 0; i < s.length; i++){
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
    var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
    // February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
    for (var i = 1; i <= n; i++) {
        this[i] = 31
        if (i==4 || i==6 || i==9 || i==11) {
            this[i] = 30
        }
        if (i==2) {
            this[i] = 29
        }
    }
    return this
}
function isDate(dtStr){
    var daysInMonth = DaysArray(12);    
    var pos1=dtStr.indexOf(dtCh)
    var pos2=dtStr.indexOf(dtCh,pos1+1)
    var strMonth=dtStr.substring(pos1+1,pos2);
    var strDay=dtStr.substring(0,pos1);
    var strYear=dtStr.substring(pos2+1);
    var strYr=strYear;
    if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
    if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
    for (var i = 1; i <= 3; i++) {
        if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
    }
    var month=parseInt(strMonth)
    var day=parseInt(strDay)
    var year=parseInt(strYr)
    if (pos1==-1 || pos2==-1){
        //alert("The date format should be : mm/dd/yyyy")
        return false
    }
    if (strMonth.length<1 || month<1 || month>12){
        //alert("Please enter a valid month")
        return false
    }
    if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
        //alert("Please enter a valid day")
        return false
    }
    if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
        //alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
        return false
    }
    if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
        //alert("Please enter a valid date")
        return false
    }
    return true;
}
/**
* Funcion trim
*/

function trim(str, chars) {
    return ltrim(rtrim(str, chars), chars);
}

function ltrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}

function rtrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}
