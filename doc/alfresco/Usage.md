# Uso en SII del componente de Alfresco

## Componentes

Se crearon 2 componentes Javascript adicionales para poder utilizar el modelo de Alfresco en el sistema:

- Ext.ux.form.AlfrescoFM
- AlfrescoMng

Para insertar el botón que hace la llamada a AlfrescoMng es necesario identificar 3 parámetros:

1. **tableName** La tabla que hará referencia el modelo.
2. **recordID** El identificador del registro.
3. **filter** El filtro (opcional) para identificar varios modelos para la misma tabla

<pre>   
    var adjunto = new Ext.ux.form.AlfrescoFM({
        id:'identificador_componente',  //(opcional)
        name:'nombre_componente',       //(opcional)
        fieldLabel :'Adjuntos',         //(opcional -> Despliega la etiqueta del comoponente. Si no se define, aparece solo el botón)
        text: 'Adjunto',                //(opcional -> Texto del botón)
        tableName : 'CGG_TABLA_DE REFERENCIA',
        recordID : 'RECORD_ID',
        filter: 'FILTRO_PARA_EL_MODELO' //(opcional)
    });
</pre>

Esto generará un botón con el ícono de "attachment" que hará la llamada a los servicios para cargar el modelo de Alfresco relacionado.

![alt tag](./botonAlfresco.png)

*Se pueden agregar además todas las propiedades heredadas del componente Ext.Button.*