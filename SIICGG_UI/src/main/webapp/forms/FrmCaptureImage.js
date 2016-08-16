/**
 * Created by acanaveral on 26/7/16.
 */
function FrmCaptureImage(){
    var tituloCaptura = "Captura de Imagen";
    var descCaptura = "Seleccione el dispositivo que va a utilizar para la captura";

    var btnCapturar = new Ext.Button({
        id:'snap',
        iconCls:'iconCamara',
        tooltip:'Capturar Foto',
        text:'Capturar Foto',
        listeners:{
            click:function(){
                // Elements for taking the snapshot
                var canvas = document.getElementById('canvas');
                var video = document.getElementById('video');
                var context = canvas.getContext('2d');
                context.drawImage(video, 0, 0, 320, 240);
            }
        }
    });

    var pnlMainCamera = new Ext.Panel({
        id:'pnlImage',
        layout: 'table',
        defaults: {
            // applied to each contained panel
            bodyStyle:'padding:10px'
        },
        layoutConfig: {
            // The total column count must be specified here
            columns: 2
        },
        items:[{
                html:'<video id="video" width="320" height="240" autoplay></video>'
            },
            {
                html:'<canvas id="canvas" width="320" height="240"></canvas>'
            },btnCapturar]
    });

    var btnGuardarFoto = new Ext.Button({
        id: 'btnGuardar',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                var imageReturn = new Image();
                imageReturn.src = canvas.toDataURL("image/png");
                winFrmCaptureImage.imageReturn = imageReturn;
                winFrmCaptureImage.close();
            }
        }
    });

    var btnCerrar = new Ext.Button({
        id: 'btnCerrar',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmCaptureImage.close();
            }
        }
    });

    var winFrmCaptureImage = new Ext.Window({
        title:tituloCaptura,
        tbar:getPanelTitulo(tituloCaptura,descCaptura),
        items:[pnlMainCamera],
        width:700,
        resizable:true,
        constrain:true,
        closable:false,
        modal:true,
        imageReturn:null,
        bbar:[btnGuardarFoto,'->',btnCerrar]
    });

    this.getWindow = function(){
        return winFrmCaptureImage;
    };
}

FrmCaptureImage.prototype.show = function(){
    this.getWindow().show();
    // Grab elements, create settings, etc.
    var video = document.getElementById('video');
    var win = this.getWindow();
    // Get access to the camera!
    if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
        // Not adding `{ audio: true }` since we only want video now
        navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
            video.src = window.URL.createObjectURL(stream);
            video.play();
            win.on('close',function () {
                video.pause();
                console.log('stop called');
                stream.getVideoTracks().forEach(function (track) {
                    track.stop();
                });
                video = null;
            });
        });
    }
};

FrmCaptureImage.prototype.close = function(){
    this.getWindow().close();
};

FrmCaptureImage.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
};

FrmCaptureImage.prototype.getImage = function(){
    return this.getWindow().imageReturn;
};