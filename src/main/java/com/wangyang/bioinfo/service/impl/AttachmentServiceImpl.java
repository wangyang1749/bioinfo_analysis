package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.handle.FileHandler;
import com.wangyang.bioinfo.handle.FileHandlers;
import com.wangyang.bioinfo.pojo.Attachment;
import com.wangyang.bioinfo.pojo.Project;
import com.wangyang.bioinfo.pojo.User;
import com.wangyang.bioinfo.pojo.enums.AttachmentType;
import com.wangyang.bioinfo.pojo.param.AttachmentParam;
import com.wangyang.bioinfo.pojo.support.UploadResult;
import com.wangyang.bioinfo.repository.AttachmentRepository;
import com.wangyang.bioinfo.service.IAttachmentService;
import com.wangyang.bioinfo.service.IProjectService;
import com.wangyang.bioinfo.util.BioinfoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    IProjectService projectService;

    @Autowired
    FileHandlers fileHandlers;

    @Override
    public Attachment addAttachment(AttachmentParam attachmentParam) {
        Attachment attachment =new Attachment();
        BeanUtils.copyProperties(attachmentParam,attachment);
        attachment = attachmentRepository.save(attachment);
        return attachment;
    }

    @Override
    public Attachment delAttachment(int id, User user) {
        Attachment attachment = findAttachmentById(id);
        Project project = projectService.findProjectById(attachment.getProjectId());
        if(user.getId()!=attachment.getUserId()&&!user.getUsername().equals("admin")&&project.getUserId()!=user.getId()){
            throw new BioinfoException("您不是该附件的创建者或者该项目创建者,不能删除！");
        }
        attachmentRepository.delete(attachment);
        return attachment;
    }

    @Override
    public Attachment findAttachmentById(int id) {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if(!attachmentOptional.isPresent()){
            throw new BioinfoException("操作的对象不存在！");
        }
        return attachmentOptional.get();
    }

    @Override
    public List<Attachment> findAllById(Collection<Integer> id) {
        return null;
    }

    @Override
    public Page<Attachment> pageAttachment(Pageable pageable) {
        Page<Attachment> attachments = attachmentRepository.findAll(pageable);
        return attachments;
    }

    @Override
    public Attachment updateAttachment(Attachment attachment) {
        return null;
    }

    @Override
    public Attachment upload(MultipartFile file,AttachmentParam attachmentParam) {
        UploadResult uploadResult = fileHandlers.upload(file, AttachmentType.LOCAL);
        Attachment attachment = new Attachment();


        BeanUtils.copyProperties(attachmentParam,attachment);
        attachment.setName(uploadResult.getFilename());
        attachment.setPath(uploadResult.getFilePath());

        attachment = attachmentRepository.save(attachment);
        return attachment;
    }

    @Override
    public Attachment upload(int id, MultipartFile file) {
        Attachment attachment = new Attachment();
        return new Attachment();
    }

    @Override
    public Page<Attachment> pageAttachmentByProjectId(int projectId, Pageable pageable) {
        Page<Attachment> attachments = attachmentRepository.findAll(new Specification<Attachment>() {
            @Override
            public Predicate toPredicate(Root<Attachment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaQuery.where(criteriaBuilder.equal(root.get("projectId"),projectId)).getRestriction();
            }
        }, pageable);
        return attachments;
    }

    @Override
    public List<Attachment> listAttachmentByProjectId(int projectId) {
        List<Attachment> attachments = attachmentRepository.findAll(new Specification<Attachment>() {
            @Override
            public Predicate toPredicate(Root<Attachment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaQuery.where(criteriaBuilder.equal(root.get("projectId"), projectId)).getRestriction();
            }
        });
        return attachments;
    }
}
