package com.wangyang.bioinfo.service;

import com.wangyang.bioinfo.pojo.Attachment;
import com.wangyang.bioinfo.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

/**
 * @author wangyang
 * @date 2021/6/13
 */
public interface IAttachmentService {
    Attachment addAttachment(Attachment attachment);
    Attachment delAttachment(int id);
    Attachment findAttachmentById(int id);
    List<Attachment> findAllById(Collection<Integer> id);
    Page<Attachment> pageAttachment(Pageable pageable);
    Attachment updateAttachment(Attachment attachment);
    //----------------------------------------
    Attachment upload(@NonNull MultipartFile file);

    // 带page条件查询
    Page<Attachment> pageAttachmentByProjectId(int projectId,Pageable pageable);
}
