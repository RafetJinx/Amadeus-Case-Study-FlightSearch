package com.example.FlightSearch.model.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 3)
    private String iataCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
    private City city;
}
