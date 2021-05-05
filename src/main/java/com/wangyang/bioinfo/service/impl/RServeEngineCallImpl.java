package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.service.IREngineCall;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author wangyang
 * @date 2021/5/3
 */
//@Service
public class RServeEngineCallImpl implements IREngineCall {

    @Override
    public File basicGraphics(String source, String data) {
        try {
            //建立连接
            RConnection rc=new RConnection();
            rc.eval("source('/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R')");
            REXP eval = rc.eval("png(filename = '/home/wy/Downloads/test.png')");
//            REXP eval1 = rc.eval("");
            REXP eval2 = rc.parseAndEval("FUN(data); dev.off()");

            rc.close();
            File file = new File("/home/wy/Downloads/test.png");
            return file;
        } catch (REngineException | REXPMismatchException e) {
            e.printStackTrace();
        }
        return null;
    }
}
