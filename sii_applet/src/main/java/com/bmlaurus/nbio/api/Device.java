package com.bmlaurus.nbio.api;

import com.bmlaurus.nbio.api.entity.CaptureOpt;
import com.bmlaurus.nbio.api.entity.Enrollment;
import com.bmlaurus.nbio.api.error.ErrorInterceptor;
import com.bmlaurus.nbio.api.export.ExportDataHandler;
import com.bmlaurus.nbio.api.export.ExportImgHandler;
import com.nitgen.SDK.BSP.NBioBSPJNI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by antonio on 17/08/16.
 */
public class Device {
    private NBioBSPJNI              bsp;
    private NBioBSPJNI.IndexSearch  IndexSearchEngine;
    private ErrorInterceptor        errorInterceptor;

    private boolean                 initialized ;
    private Enrollment              enrollment;//-> Permite configurar la ventana antes del enrolameinto
    private CaptureOpt              capturement;//-> Configuracion de ventana para la caputra

    private int                     exportFormat;

    //**
    // Constructor -> initDevice -> [windowOptions](Enrollment&CaptureOpt)  -> enroll       -> closeAndDispose
    //                                                                      -> validate
    // */

    public Device(){
    }

    public boolean initDevice(){
        initialized = false;
        exportFormat=NBioBSPJNI.EXPORT_MINCONV_TYPE.ANSI;
        try {
            bsp = new NBioBSPJNI();
        }catch (UnsatisfiedLinkError e){
            errorInterceptor = new ErrorInterceptor(e.getMessage());
            return false;
        }
        if (checkError())
            return false;

        //System.out.println("NBioAPI_JavaIndexSearch BSP version: " + bsp.GetVersion());
        IndexSearchEngine = bsp.new IndexSearch();
        if (checkError())
            return false;

        bsp.OpenDevice();
        if (checkError())
            return false;

        initialized=true;
        return initialized;
    }

    public ErrorInterceptor getErrorInterceptor() {
        return errorInterceptor;
    }

    public Enrollment configureEnrollment(){
        if (!isInitialized())
            return null;
        enrollment =  new Enrollment(bsp.new WINDOW_OPTION());
        return enrollment;
    }

    public CaptureOpt configureCaptureOpt(){
        if (!isInitialized())
            return null;
        capturement =  new CaptureOpt(bsp.new WINDOW_OPTION());
        return capturement;
    }

    public Map<String,List> enroll(int nUserID){
        return enroll(nUserID,true,true);
    }

    public Map<String,List> enroll(int nUserID, boolean saveAuditData, boolean persist){

        Map<String,List> enrolledData = new HashMap<>();

        if (!isInitialized())
            return null;

        NBioBSPJNI.FIR_HANDLE hFIR = bsp.new FIR_HANDLE();

        NBioBSPJNI.FIR_HANDLE hSavedAuditFIR = null;
        if (saveAuditData)
            hSavedAuditFIR = bsp.new FIR_HANDLE();

        if(enrollment!=null)
            bsp.Enroll(null, hFIR, null, -1, hSavedAuditFIR, enrollment.getWinOption());
        else
            bsp.Enroll(null, hFIR, null, -1, hSavedAuditFIR, null);

        if (checkError())  {
            if (bsp.GetErrorCode() == NBioBSPJNI.ERROR.NBioAPIERROR_FUNCTION_FAIL)
                bsp.Capture(hFIR);

            if (checkError()) {
                hFIR.dispose();
                hFIR=null;
                return null;
            }
        }

        //Guardamos los datos en Texto
        NBioBSPJNI.FIR_TEXTENCODE textSavedFIR = bsp.new FIR_TEXTENCODE();
        bsp.GetTextFIRFromHandle(hFIR,textSavedFIR);
        if (checkError()) {
            hFIR.dispose();
            hFIR=null;
            return null;
        }
        List text = new ArrayList();
        text.add(textSavedFIR.TextFIR);
        enrolledData.put("TEXT",text);

        //Guardamos en el searchEngine para utilizarlo en este contexto
        if(persist){
            NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
            NBioBSPJNI.IndexSearch.SAMPLE_INFO sampleInfo = IndexSearchEngine.new SAMPLE_INFO();

            inputFIR.SetFIRHandle(hFIR);
            IndexSearchEngine.AddFIR(inputFIR, nUserID, sampleInfo);

            if (checkError()) {
                hFIR.dispose();
                hFIR=null;
                return null;
            }
        }

        //Generamos las imagenes
        if (hSavedAuditFIR != null)
            enrolledData.put("AUDIT",getEnrollmentRaw(hSavedAuditFIR));
        //Generamos la data
        enrolledData.put("DATA",getEnrollmentData(hFIR,exportFormat));

        hFIR.dispose();
        hFIR = null;

        return enrolledData;
    }

    private List<ExportImgHandler> getEnrollmentRaw(NBioBSPJNI.FIR_HANDLE hSavedAuditFIR){
        if (!isInitialized())
            return null;

        List<ExportImgHandler> exportImgHandlers = null;
        if (hSavedAuditFIR != null)  {
            exportImgHandlers = new ArrayList<>();
            NBioBSPJNI.Export exportEngine = bsp.new Export();
            NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
            inputFIR.SetFIRHandle(hSavedAuditFIR);

            NBioBSPJNI.Export.AUDIT exportAudit = exportEngine.new AUDIT();
            exportEngine.ExportAudit(inputFIR, exportAudit);

            if (checkError()) {
                return null;
            }

            int i, j;
            Boolean bSaveSuccess = true;
            String fileName;

            for (i = 0; i < exportAudit.FingerNum; i++)  {
                for (j = 0; j < exportAudit.SamplesPerFinger; j++)  {
                    ExportImgHandler imgHandler = new ExportImgHandler(exportAudit.FingerData[i].FingerID, exportAudit.FingerData[i].Template[j].Data);
                    exportImgHandlers.add(imgHandler);
                }
            }

        }
        return exportImgHandlers;
    }

    private List<ExportDataHandler> getEnrollmentData(NBioBSPJNI.FIR_HANDLE hSavedFIR, int nMinType){

        if (!isInitialized())
            return null;

        NBioBSPJNI.Export           exportEngine = bsp.new Export();
        NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();

        List<ExportDataHandler> exportDataHandlers = new ArrayList<>();

        inputFIR.SetFIRHandle(hSavedFIR);
        NBioBSPJNI.Export.DATA exportData = exportEngine.new DATA();

        exportEngine.ExportFIR(inputFIR, exportData, nMinType);

        if (checkError())
            return null;

        //Extraccion de la data
        int i, j;
        for (i = 0; i < exportData.FingerNum; i++)  {
            for (j = 0; j < exportData.SamplesPerFinger; j++)  {
                ExportDataHandler dataHandler = new ExportDataHandler(exportData.FingerData[i].FingerID, exportData.FingerData[i].Template[j].Data);
                exportDataHandlers.add(dataHandler);
            }
        }

        exportEngine = null;
        return exportDataHandlers;
    }

    public NBioBSPJNI.IndexSearch.FP_INFO searchIndexedFinger(String capturedFinger, int nMaxSearchTime){

        if (!isInitialized())
            return null;

        NBioBSPJNI.INPUT_FIR capturedFIR = bsp.new INPUT_FIR();
        NBioBSPJNI.FIR_TEXTENCODE capturedText = bsp.new FIR_TEXTENCODE();
        capturedText.TextFIR=capturedFinger;
        capturedFIR.SetTextFIR(capturedText);

        NBioBSPJNI.IndexSearch.FP_INFO fpInfo = IndexSearchEngine.new FP_INFO();
        IndexSearchEngine.Identify(capturedFIR, 5, fpInfo, nMaxSearchTime);

        if (checkError())  {
            if (bsp.GetErrorCode() == NBioBSPJNI.ERROR.NBioAPIERROR_INDEXSEARCH_IDENTIFY_FAIL)  {
                errorInterceptor = new ErrorInterceptor("Not Found");
            }else if (bsp.GetErrorCode() == NBioBSPJNI.ERROR.NBioAPIERROR_INDEXSEARCH_IDENTIFY_STOP)  {
                errorInterceptor = new ErrorInterceptor("Time out");
            }
        }else{
            return fpInfo;
        }

        return null;
    }

    public String captureFinger(){
        if (!isInitialized())
            return null;

        NBioBSPJNI.FIR_HANDLE hSavedFIR = bsp.new FIR_HANDLE();
        bsp.Capture(NBioBSPJNI.FIR_PURPOSE.VERIFY, hSavedFIR, -1, null, capturement!=null?capturement.getWinOption():null);
        if (checkError()) {
            hSavedFIR.dispose();
            hSavedFIR=null;
            return null;
        }

        NBioBSPJNI.FIR_TEXTENCODE textSavedFIR = bsp.new FIR_TEXTENCODE();
        bsp.GetTextFIRFromHandle(hSavedFIR,textSavedFIR);
        if (checkError()) {
            hSavedFIR.dispose();
            hSavedFIR=null;
            return null;
        }
        hSavedFIR.dispose();
        hSavedFIR=null;

        return textSavedFIR.TextFIR;
    }

    public boolean verifyMatch(String savedFinger, String capturedFinger){
        if (!isInitialized())
            return false;

        NBioBSPJNI.INPUT_FIR savedFIR = bsp.new INPUT_FIR();
        NBioBSPJNI.FIR_TEXTENCODE savedText = bsp.new FIR_TEXTENCODE();
        savedText.TextFIR=savedFinger;
        savedFIR.SetTextFIR(savedText);

        NBioBSPJNI.INPUT_FIR capturedFIR = bsp.new INPUT_FIR();
        NBioBSPJNI.FIR_TEXTENCODE capturedText = bsp.new FIR_TEXTENCODE();
        capturedText.TextFIR=capturedFinger;
        capturedFIR.SetTextFIR(capturedText);

        Boolean bResult = new Boolean(false);
        NBioBSPJNI.FIR_PAYLOAD payload = bsp.new FIR_PAYLOAD();
        bsp.VerifyMatch(savedFIR,capturedFIR,bResult,payload);

        if(checkError())
            return false;

        return bResult;
    }

    @Deprecated
    public boolean verifyMatch(byte[] loadData, int nMinType){
        int nLoadLen = loadData.length;
        NBioBSPJNI.FIR_HANDLE hLoadFIR = bsp.new FIR_HANDLE();
        NBioBSPJNI.Export exportEngine = bsp.new Export();
        //importamos la data
        exportEngine.ImportFIR(loadData, nLoadLen, nMinType, hLoadFIR);
        if(checkError())
            return false;

        NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
        Boolean bResult = new Boolean(false);
        inputFIR.SetFIRHandle(hLoadFIR);
        bsp.Verify(inputFIR, bResult, null, -1, null, null);
        if(checkError())
            return false;

        return bResult;
    }

    public boolean loadIndexedDatabase(Map<Integer,String> fingers){
        if(IndexSearchEngine!=null){
            IndexSearchEngine.dispose();
            IndexSearchEngine = null;
        }
        IndexSearchEngine = bsp.new IndexSearch();
        if (checkError())
            return false;

        NBioBSPJNI.FIR_HANDLE hLoadFIR = bsp.new FIR_HANDLE();
        NBioBSPJNI.IndexSearch.SAMPLE_INFO sampleInfo = IndexSearchEngine.new SAMPLE_INFO();
        for(Map.Entry<Integer,String> finger : fingers.entrySet()){
            NBioBSPJNI.INPUT_FIR savedFIR = bsp.new INPUT_FIR();
            NBioBSPJNI.FIR_TEXTENCODE savedText = bsp.new FIR_TEXTENCODE();
            savedText.TextFIR=finger.getValue();
            savedFIR.SetTextFIR(savedText);
            bsp.Process(savedFIR,hLoadFIR);
            IndexSearchEngine.AddFIR(savedFIR, finger.getKey(), sampleInfo);
            if(checkError())
                return false;
        }

        return true;
    }

    public boolean loadData(byte[] loadData, int nUserID, int nMinType){
        int nLoadLen = loadData.length;
        NBioBSPJNI.FIR_HANDLE hLoadFIR = bsp.new FIR_HANDLE();
        NBioBSPJNI.Export exportEngine = bsp.new Export();

        exportEngine.ImportFIR(loadData, nLoadLen, nMinType, hLoadFIR);
        if(checkError())
            return false;

        NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
        NBioBSPJNI.IndexSearch.SAMPLE_INFO sampleInfo = IndexSearchEngine.new SAMPLE_INFO();

        inputFIR.SetFIRHandle(hLoadFIR);
        IndexSearchEngine.AddFIR(inputFIR, nUserID, sampleInfo);

        return !checkError();
    }

    public boolean clearDataBase(){
        IndexSearchEngine.ClearDB();
        return !checkError();
    }

    public void closeAndDispose(){
        close();
        dispose();
    }

    private void close(){
        if (bsp != null) {
            bsp.CloseDevice();
        }
    }

    private void dispose(){
        if (IndexSearchEngine != null)  {
            IndexSearchEngine.dispose();
            IndexSearchEngine = null;
        }

        if (bsp != null) {
            bsp.dispose();
            bsp = null;
        }
    }

    private boolean isInitialized(){
        if(!initialized){
            errorInterceptor = new ErrorInterceptor("Please initialize device before use");
            return false;
        }
        return true;
    }

    private boolean checkError()
    {
        if (bsp.IsErrorOccured())  {
            errorInterceptor = new ErrorInterceptor(bsp.GetErrorCode());
            return true;
        }

        return false;
    }
}
