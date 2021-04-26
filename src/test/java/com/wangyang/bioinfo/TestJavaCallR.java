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
@TestPropertySource("file:/home/wy/.bioinfo/application.yml")
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
        REXP rexp=rc.eval("max(data)");
        //REXP. asXxx()返回相应类型的数据，如果结果类型不符会出错
        System.out.println(rexp.asInteger());
        rc.close();
    }


//    @Test
    public void runRScript()  throws Exception {
        RConnection rc = new RConnection();
        // test.R的路径
        String fileName = "/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R";
        rc.assign("fileName", fileName);
        //执行test.R脚本，执行这一步才能调用里面的自定义函数myFunc，如果不行，就在R工具上也执行一下test.R脚本
        REXP rexp = rc.eval("source(fileName)");
//        String num = "3";
//        //调用myFunc函数
//        REXP rexp=rc.eval("myFunc("+num+")");
        //返回类型是一个整数类型，所以用asInteger
        System.out.println(rexp);
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
