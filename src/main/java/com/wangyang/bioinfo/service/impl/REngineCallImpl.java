package com.wangyang.bioinfo.service.impl;

import com.github.rcaller.graphics.SkyTheme;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import com.github.rcaller.util.Globals;
import com.wangyang.bioinfo.pojo.dto.RBasicGraphics;
import com.wangyang.bioinfo.service.IREngineCall;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author wangyang
 * @date 2021/4/26
 */
@Service
public class REngineCallImpl implements IREngineCall {

    @Override
    public File basicGraphics(String source,String data) {
        try {
            RCaller caller = RCaller.create();

            RCode code = RCode.create();
            code.R_source(source);
            caller.setGraphicsTheme(new SkyTheme());
            File plt = code.startPlot();
            code.addRCode("");
            code.endPlot();
            caller.setRCode(code);
            caller.runOnly();
            System.out.println(plt.getPath());
            return plt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
