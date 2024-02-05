package com.example.FlightSearch.model.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Airline")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airline extends Company {
    @Column(length = 2, nullable = false)
    private String airlineCode;
}
