package com.eroluzun.carrentalsystem.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GnlCharVal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long gnlCharValId;

    @Column(name = "VAL",length = 1000)
    private String val;

    @Column(name = "SHORT_CODE", length = 25)
    private String shortCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gnl_char_id")
    private GnlChar gnlChar;
}
