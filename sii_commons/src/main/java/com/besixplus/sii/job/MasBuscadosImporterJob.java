package com.besixplus.sii.job;

import com.besixplus.sii.util.Env;
import com.bmlaurus.csv.MasBuscadosImporter;
import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by acanaveral on 1/9/16.
 */
public class MasBuscadosImporterJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            MasBuscadosImporter importer = new MasBuscadosImporter(Env.getHomePath()+"/importer/buscados");
        } catch (EnvironmentVariableNotDefinedException e) {
            e.printStackTrace();
        }
    }
}
