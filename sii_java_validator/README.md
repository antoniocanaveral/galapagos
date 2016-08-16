#Dinardap Service

Transforma la llamada a los servicios de la Dinardap en objetos POJO

Para implementar un nuevo servicio, solamente se debe crear una clase POJO con los atributos que devuelve el servicio. Existen implementados 2 servicios, Registro Civil y CNE

###Ejemplo Registro Civil

<code>

    RegistroCivil registroCivil = new RegistroCivil("1002867800");
    registroCivil.callServiceAsObject();
    String fecha = registroCivil.getFechaNacimiento();

</code>

###Ejemplo CNE

<code>

    CNE cne = new CNE("1002867800");
    cne.callServiceAsObject();
    String sufragio = cne.getSufrago();

</code>