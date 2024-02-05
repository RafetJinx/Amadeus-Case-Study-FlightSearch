package com.example.FlightSearch.model.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CompanyEmail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String email;
}
