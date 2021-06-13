package com.wangyang.bioinfo.handle;

import com.wangyang.bioinfo.pojo.enums.AttachmentType;
import com.wangyang.bioinfo.pojo.support.UploadResult;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangyang
 * @date 2021/6/13
 */
public interface FileHandler {
    UploadResult upload(@NonNull MultipartFile file);
    boolean supportType(@Nullable AttachmentType type);
}
