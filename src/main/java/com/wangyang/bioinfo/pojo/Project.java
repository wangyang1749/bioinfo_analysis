package com.wangyang.bioinfo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/3
 */
@Getter
@Setter
@Entity(name = "t_project")
public class Project extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "longtext not null")
    private String description;
    private String jupyterUrl;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    @Column(name = "t_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    ProjectStatus projectStatus;

//    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
//    @JoinTable(name = "t_user_project",joinColumns = @JoinColumn(name = "projectId"),
//            inverseJoinColumns = @JoinColumn(name = "userId"))
//    @JsonManagedReference
//    private Set<User> projects =new HashSet<>();
}
