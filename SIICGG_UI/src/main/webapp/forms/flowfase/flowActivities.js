function WorkflowActivities(){	
    this.direccionarTramiteNoAdjuntos = function(inEMTR_ID,inEMTR_NUMERO,inETPA_ID,inETPA_USUARIO,inETMT_ID,inParticipantes,inPropiedadParticipante,inComentarios){
        var arrPropiedadTarea = new Array();
        arrPropiedadTarea[0]=inETMT_ID;
        Ext.Ajax.request({
            url:'Tramite.jsp',
            success: function(o){
                Ext.MessageBox.hide();
                if(trim(o.responseText).toUpperCase()=='OK'){
                    Ext.Msg.show({
                        title:'Seguimiento de Tramite.',
                        msg: 'Usted fue suscrito al tr�mite: <b><font size=3 color="blue">'+inEMTR_NUMERO+'</font></b>.<br>Revise su bandeja de tareas.<br>Para mayor informaci�n actualize el formulario de historial de Tramite.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    comprobarTareas2();
                }else{
                    Ext.Msg.show({
                        title:'Seguimiento de Tramite.',
                        msg: 'Se presento un problema al suscribirse al tramite: <font size=2 color="red">'+ inEMTR_NUMERO+'</font>,por favor pongase en contacto con el administrador del sistema.\nError:'+o.responseText,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            },
            failure:function(o){
                Ext.MessageBox.hide();
                Ext.Msg.show({
                    title:'Seguimiento de Tramite.',
                    msg: 'Se presento un problema al suscribirse al tramite: <font size=2 color="red">'+ inEMTR_NUMERO+'</font>,por favor pongase en contacto con el administrador del sistema.\nError:'+o.responseText,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            },
            params: {
                INEMTR_ID: inEMTR_ID,
                INETTP_ID: 'ETTP1',
                INEMTR_NUMERO: inEMTR_NUMERO,
                INETPA_ID: inETPA_ID,
                INETPA_USUARIO:inETPA_USUARIO,
                INPARTICIPANTE: inParticipantes,
                INETPA_CONTRASENA: '',
                INCOMENTARIO: inComentarios,
                INPROPIEDAD: arrPropiedadTarea,
                INPROPIEDADPARTICIPANTE: inPropiedadParticipante
            }
        });
    }
}

WorkflowActivities.prototype.direccionarTramiteSinAdjunto = function(inEMTR_ID,inEMTR_NUMERO,inETPA_ID,inETPA_USUARIO,inETMT_ID,inParticipantes,inPropiedadParticipante,inComentarios){
    this.direccionarTramiteNoAdjuntos(inEMTR_ID,inEMTR_NUMERO,inETPA_ID,inETPA_USUARIO,inETMT_ID,inParticipantes,inPropiedadParticipante,inComentarios);
}

