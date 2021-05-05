package com.wangyang.bioinfo;

import com.github.rcaller.graphics.SkyTheme;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import com.wangyang.bioinfo.service.IREngineCall;
import org.junit.jupiter.api.Test;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import org.rosuda.JRI.Rengine;

import java.io.File;
import java.io.IOException;

/**
 * @author wangyang
 * @date 2021/4/26
 */
@SpringBootTest
//@TestPropertySource("file:/home/wy/.bioinfo/application.yml")
public class TestJavaCallR {

    @Autowired
    IREngineCall rEngineCall;

    @Test
    public void test() throws Exception {
        //建立连接
        RConnection rc=new RConnection();
        //构建数据
        int[] datas={314,451,56,24,631};
        //声明变量，相当于在R命令行中输入data<-datas命令
        rc.assign("data",datas);
        //执行R语句，相当于在R命令行中输max(data)命令
        REXP rexp=rc.parseAndEval("max(data)");
        //REXP. asXxx()返回相应类型的数据，如果结果类型不符会出错
        System.out.println(rexp.asInteger());
        rc.close();
    }


    @Test
    public void runRScript()  throws Exception {
        //System.out.println("1749748955");
        //建立连接
        RConnection rc=new RConnection();
        //构建数据
        int[] datas={314,451,56,24,631};
        //声明变量，相当于在R命令行中输入data<-datas命令
        rc.assign("data",datas);
        //执行R语句，相当于在R命令行中输max(data)命令
        REXP rexp=rc.eval("max(data)");
        //REXP. asXxx()返回相应类型的数据，如果结果类型不符会出错
        System.out.println(rexp.asInteger());

        REXP xp = rc.parseAndEval("try(png(filename = '/home/wy/Downloads/test.png'));");

        // if (xp.inherits("try-error")) { // if the result is of the class try-error then there was a problem
        //     System.err.println("Can't open png graphics device:\n"+xp.asString());
        //     // this is analogous to 'warnings', but for us it's sufficient to get just the 1st warning
        //     REXP w = rc.eval("if (exists('last.warning') && length(last.warning)>0) names(last.warning)[1] else 0");
        //     if (w.isString()) System.err.println(w.asString());
        //     return;
        // }

        // ok, so the device should be fine - let's plot - replace this by any plotting code you desire ...
        rc.parseAndEval("plot(c(0)); dev.off()");

        // There is no I/O API in REngine because it's actually more efficient to use R for this
        // we limit the file size to 1MB which should be sufficient and we delete the file as well
        // xp = rc.parseAndEval("r=readBin('test.jpg','raw',1024*1024); unlink('test.jpg'); r");

        rc.close();
    }

//    @Test
    public void testRJava(){
        // Create an R vector in the form of a string.
        String javaVector = "c(1,2,3,4,5)";

        // Start Rengine.
        Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);

        // The vector that was created in JAVA context is stored in 'rVector' which is a variable in R context.
        engine.eval("rVector=" + javaVector);

        //Calculate MEAN of vector using R syntax.
        engine.eval("meanVal=mean(rVector)");

        //Retrieve MEAN value
        double mean = engine.eval("meanVal").asDouble();

        //Print output values
        System.out.println("Mean of given vector is=" + mean);
    }

//    @Test
    public void testRCaller() throws IOException {
        RCaller caller = RCaller.create();
        RCode code = RCode.create();


        caller.setGraphicsTheme(new SkyTheme());

        File plt = code.startPlot();
//        code.addRCode("source('/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R')");
        code.endPlot();

        caller.setRCode(code);
//        caller.runAndReturnResult("ols");
        System.out.println(plt.getPath());
    }

    @Test
    public void testREngine(){
        rEngineCall.basicGraphics("/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R","/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/test_v.csv");
    }
}
