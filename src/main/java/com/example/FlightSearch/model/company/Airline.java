package com.example.FlightSearch.model.company;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Airline")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airline extends Company {
    @Column(length = 2, nullable = false)
    private String airlineCode;
}
