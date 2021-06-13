package com.wangyang.bioinfo.service.impl;

import com.wangyang.bioinfo.pojo.Attachment;
import com.wangyang.bioinfo.repository.AttachmentRepository;
import com.wangyang.bioinfo.service.IAttachmentService;
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

/**
 * @author wangyang
 * @date 2021/6/13
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public Attachment addAttachment(Attachment attachment) {
        return null;
    }

    @Override
    public Attachment delAttachment(int id) {
        return null;
    }

    @Override
    public Attachment findAttachmentById(int id) {
        return null;
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
    public Attachment upload(MultipartFile file) {
        return null;
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
}
