package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.service.IREngineCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Base64;

/**
 * @author wangyang
 * @date 2021/4/27
 */
@RestController
@RequestMapping("/api/graphics")
public class GraphicsController {

    @Autowired
    IREngineCall rEngineCall;

    @GetMapping("/plot")
    public void getImg(HttpServletResponse httpServletResponse) throws IOException {
        File file = rEngineCall.basicGraphics("/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/testPlot.R",
                "/home/wy/Documents/R/RServe_Usage/RServe_Usage/script/test_v.csv");
//        File file = new File("/home/wy/Pictures/R385376855fc011b6fce9e0c34ace0517.jpeg");
        byte[] img = Files.readAllBytes(file.toPath());
        String base64 = Base64.getEncoder().encodeToString(img);
        httpServletResponse.setContentType("image/png");
        OutputStream os = httpServletResponse.getOutputStream();
        os.write(img);
//        os.write(base64.);
        os.flush();
        os.close();
    }
}
