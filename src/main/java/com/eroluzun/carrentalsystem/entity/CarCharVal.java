package com.eroluzun.carrentalsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAR_CHAR_VAL")
@Getter
@Setter
public class CarCharVal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carCharValId;

    @Column(name = "VAL",length = 1000)
    private String val;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "gnlCharId")
    private List<GnlChar> gnlChars = new ArrayList<>(); //zorunlu giden

    @JsonIgnore
    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "gnlCharValId")
    private List<GnlCharVal> gnlCharVals = new ArrayList<>(); //zorunlu giden
}
