package com.wangyang.bioinfo.pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyang
 * @date 2021/5/3
 */
@Getter
@Setter
@Entity(name = "t_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_project",joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    @JsonManagedReference
    private Set<User> projects =new HashSet<>();
}
