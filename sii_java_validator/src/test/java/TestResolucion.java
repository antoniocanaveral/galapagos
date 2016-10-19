import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.bmlaurus.phaserule.GenerarResolucion;
import com.bmlaurus.rule.RulePhase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 18/10/16.
 */
public class TestResolucion {
    @Test
    public void Test(){
        try {
            Connection connection = ManagerConnection.getConnection();

            connection.setAutoCommit(false);
            //(select crseg_codigo from cgg_res_seguimiento where crseg_numero = '127169' and crtra_codigo = (select crtra_codigo from cgg_res_tramite where crtra_anio ='2016' and crtra_numero = '30102958'))
            Cgg_res_seguimiento seg = new Cgg_res_seguimiento();
            seg.setCRSEG_CODIGO("CRSEG197244");
            new com.besixplus.sii.db.Cgg_res_seguimiento(seg).select(connection);

            //(select crtra_codigo from cgg_res_tramite where crtra_anio ='2016' and crtra_numero = '30102958')
            Cgg_res_tramite tra = new Cgg_res_tramite();
            tra.setCRTRA_CODIGO("CRTRA109933");
            new com.besixplus.sii.db.Cgg_res_tramite(tra).select(connection);

            String inUserName = "jennifer.paladines";

            RulePhase res = new GenerarResolucion(connection);
            res.executeRule(seg,tra,inUserName);


            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
