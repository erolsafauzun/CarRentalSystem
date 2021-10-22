package com.eroluzun.carrentalsystem.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "C_DATE")
    private Date createdAt;

    @CreatedBy
    @Column(name = "C_USER",length = 100)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "U_DATE")
    private Date updatedAt;

    @LastModifiedBy
    @Column(name = "U_USER",length = 100)
    private String updatedBy;

    @Column(name = "IS_ACTIVE")
    private int isActive;

    @PrePersist
    public void onPrePersist(){
        int actv = 1;
        isActive = actv;
        createdAt = new Date();
        createdBy = "ErolSafa";
    }

    @PreUpdate
    public void onPreUpdate(){
        setUpdatedAt(new Date());
        updatedBy = "ErolSafa";
    }
}
