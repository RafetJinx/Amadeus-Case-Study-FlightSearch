package com.example.FlightSearch.model.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Company")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String taxId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<CompanyContactNumber> contactNumbers;

    @OneToMany(mappedBy = "company")
    private List<CompanyEmail> emails;
}
