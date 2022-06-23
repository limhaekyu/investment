package com.fastcampus.investment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "investor")
public class Investor {

    @Id
    @Column(name = "investor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investor_name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "investor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Investment> investment = new ArrayList<>();



}
