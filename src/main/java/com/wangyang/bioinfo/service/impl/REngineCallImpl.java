package com.wangyang.bioinfo.service.impl;

import com.github.rcaller.graphics.SkyTheme;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
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
    public String basicGraphics(String source,String data) {
        try {
            RCaller caller = RCaller.create();
            RCode code = RCode.create();
            caller.setGraphicsTheme(new SkyTheme());
            File plt = code.startPlot();
            code.addRCode("source('"+source+"')");
            code.addRCode("data <- read.csv('"+data+"')");
            code.endPlot();
            caller.setRCode(code);
            caller.runAndReturnResult("FUN(data)");

            System.out.println(plt.getPath());
            return plt.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
