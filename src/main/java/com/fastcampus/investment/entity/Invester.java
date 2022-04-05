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
@Table(name = "invester")
public class Invester {

    @Id
    @Column(name = "invester_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invester_name")
    private String investerName;

    @Column(name = "holding_amount")
    private Long holdingAmount=0L;

    @Column(name ="total_personal_investment_amount")
    private Long totalPersonalInvestmentAmount=0L;

    @JsonBackReference
    @OneToMany(mappedBy = "invester", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Investment> investment = new ArrayList<>();



}
