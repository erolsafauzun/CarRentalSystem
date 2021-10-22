package com.eroluzun.carrentalsystem.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GnlChar extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long gnlCharId;

    @Column(name = "NAME",length = 100)
    private String name;

    @Column(name = "DESCRIPTION",length = 1000)
    private String description;

    @Column(name = "SHORT_CODE", length = 25)
    private String shortCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gnlChar")
    private List<GnlCharVal> gnlCharVals = new ArrayList<>();
}
