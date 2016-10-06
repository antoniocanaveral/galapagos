/**
 * Created by acanaveral on 26/7/16.
 */
function FrmCaptureImage(){
    var tituloCaptura = "Captura de Imagen";
    var descCaptura = "Seleccione el dispositivo que va a utilizar para la captura";

    var zoom = 1,
        rotate = 0;
    var _x=0,_y=0;

    function updateCanvas() {
        var canvas = document.getElementById('canvas');
        var video = document.getElementById('video');
        var context = canvas.getContext('2d');
        context.setTransform(1, 0, 0, 1, 0, 0);
        context.clearRect(0, 0, canvas.width, canvas.height);
        context.translate(canvas.width * 0.5, canvas.height * 0.5);
        context.rotate(rotate * Math.PI / 180);
        context.scale(zoom, zoom);
        context.translate(-canvas.width * 0.5, -canvas.height * 0.5);
        context.drawImage(video, _x, _y, 320, 240);
    }

    var btnCapturar = new Ext.Button({
        id:'snap',
        iconCls:'iconCamara',
        tooltip:'Capturar Foto',
        text:'Capturar Foto',
        listeners:{
            click:function(){
                zoom=1;
                rotate=0;
                _x=0;
                _y=0;
                updateCanvas();
            }
        }
    });

    var btnZin = new Ext.Button({
        id:'_plus',
        tooltip:'Zoom In',
        text:'+',
        width:25,
        listeners:{
            click:function(){
                zoom = zoom + 0.1;
                updateCanvas();
            }
        }
    });
    var btnZOut = new Ext.Button({
        id:'_minus',
        tooltip:'Zoom Out',
        text:'-',
        width:25,
        listeners:{
            click:function(){
                zoom = zoom - 0.1;
                updateCanvas();
            }
        }
    });
    var btnLeft = new Ext.Button({
        id:'_left',
        tooltip:'Izquierda',
        text:'<-',
        width:25,
        listeners:{
            click:function(){
                _x=_x-5;
                updateCanvas();
            }
        }
    });
    var btnRight = new Ext.Button({
        id:'_right',
        tooltip:'Derecha',
        text:'->',
        width:25,
        listeners:{
            click:function(){
                _x=_x+5;
                updateCanvas();
            }
        }
    });
    var btnUp = new Ext.Button({
        id:'_up',
        tooltip:'Arriba',
        text:'^',
        width:25,
        listeners:{
            click:function(){
                _y=_y-5;
                updateCanvas();
            }
        }
    });
    var btnDown = new Ext.Button({
        id:'_down',
        tooltip:'Abajo',
        text:'_',
        width:25,
        listeners:{
            click:function(){
                _y=_y+5;
                updateCanvas();
            }
        }
    });

    var ctlPanel = new Ext.Panel({
        id:'ctlPanel',
        layout: 'table',
        defaults: {
            // applied to each contained panel
            bodyStyle:'padding:2px'
        },
        layoutConfig: {
            // The total column count must be specified here
            columns: 6
        },
        items:[btnZin,btnZOut,btnLeft,btnRight,btnUp,btnDown]
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
                html:'<video id="video" width="320" height="320" autoplay></video>'
            },
            {
                html:'<canvas id="canvas" width="320" height="320"></canvas>'
            },btnCapturar,ctlPanel]
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