package com.wangyang.bioinfo.web;

import com.wangyang.bioinfo.pojo.Attachment;
import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.vo.ProjectListVo;
import com.wangyang.bioinfo.service.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    IAttachmentService attachmentService;

    @GetMapping
    public Page<Attachment> page(@PageableDefault(sort = {"id"},direction = DESC) Pageable pageable){
        Page<Attachment> attachments = attachmentService.pageAttachment(pageable);
        return attachments;
    }

    @GetMapping("/projectId/{projectId}")
    public Page<Attachment> pageByProjectId(@PathVariable("projectId") int projectId, @PageableDefault(sort = {"id"},direction = DESC) Pageable pageable){
        Page<Attachment> attachments = attachmentService.pageAttachmentByProjectId(projectId,pageable);
        return attachments;
    }

}
