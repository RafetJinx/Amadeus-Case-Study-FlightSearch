package com.example.FlightSearch.model.user;

import com.example.FlightSearch.model.company.Company;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CompanyEmployee")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyEmployee extends IndividualUser {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;
}