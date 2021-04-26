import com.github.rcaller.graphics.SkyTheme;
import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 *
 * @author Mehmet Hakan Satman
 * 
 */
public class Test {

  public Test() throws IOException {
          RCaller caller = RCaller.create();
        RCode code = RCode.create();


        caller.setGraphicsTheme(new SkyTheme());

        File plt = code.startPlot();
        code.addRCode("source('/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R')");
       code.addRCode("NEW_VOLCANIC(data,file_name = 'volcanic_miRNA.png')");
        code.endPlot();

        caller.setRCode(code);
       caller.runAndReturnResult("NEW_VOLCANIC(data)");
        code.showPlot(plt);
        System.out.println(plt.getName());
  }

  public static void main(String[] args) throws IOException {
    new Test();
  }
}