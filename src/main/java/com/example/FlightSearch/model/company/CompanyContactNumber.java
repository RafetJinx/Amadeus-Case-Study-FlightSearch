package com.example.FlightSearch.model.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CompanyContactNumber")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyContactNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(length = 50, nullable = false)
    private String contactNumber;
}