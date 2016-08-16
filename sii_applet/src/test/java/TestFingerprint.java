/**
 * Created by acanaveral on 10/8/16.
 */
import com.besixplus.enbsp.NBioAPI_Error;
import com.besixplus.enbsp.unix.Lector;
import com.besixplus.enbsp.unix.NBioBSP;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class TestFingerprint {

    private int myTimeout;
    private ByteArrayOutputStream myBufferFIR;
    private IntByReference myHBSP;
    private NBioBSP myBSP;
    private NBioAPI_Error myState;


    @Test
    public void Test(){
        Lector lector = new Lector();

        this.myTimeout = 10000;
        this.myBufferFIR = null;
        this.myHBSP = new IntByReference();
        this.myBSP = null;
        this.myState = NBioAPI_Error.NBioAPIERROR_NONE;
        this.myBSP = (NBioBSP) Native.loadLibrary("NBioBSP", NBioBSP.class);
        this.myState = NBioAPI_Error.valueOf(this.myBSP.NBioAPI_Init(this.myHBSP));
        this.myBufferFIR = new ByteArrayOutputStream();
    }
}
