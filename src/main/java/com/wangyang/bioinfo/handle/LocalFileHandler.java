package com.wangyang.bioinfo.handle;

import com.wangyang.bioinfo.pojo.enums.AttachmentType;
import com.wangyang.bioinfo.pojo.support.UploadResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@Component
@Slf4j
public class LocalFileHandler implements FileHandler {
    @Value("${bioinfo.workDir}")
    private String workDir;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public UploadResult upload(MultipartFile file) {
        UploadResult uploadResult = new UploadResult();
        String  originalFilename = file.getOriginalFilename();

        String subFilePath = "upload/"+"/"+System.currentTimeMillis()+"-"+originalFilename;
        uploadResult.setFilePath(originalFilename);
        uploadResult.setFilename(originalFilename);
        Path uploadPath = Paths.get(workDir, subFilePath);
        try {
            Files.createDirectories(uploadPath.getParent());
            //创建文件
            Files.createFile(uploadPath);
            file.transferTo(uploadPath);
            log.info("上传文件到",uploadPath.toFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        uploadResult.setFilename(originalBasename);
//        lock.lock();
//        try (InputStream uploadFileInputStream = new FileInputStream(uploadPath.toFile())) {
//
//        }finally {
//            lock.unlock();
//        }
        return uploadResult;
    }

    @Override
    public boolean supportType(AttachmentType type) {
        return AttachmentType.LOCAL.equals(type);
    }
}
