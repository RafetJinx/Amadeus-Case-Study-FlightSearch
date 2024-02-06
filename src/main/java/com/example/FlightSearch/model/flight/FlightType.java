package com.example.FlightSearch.model.flight;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FlightType")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightType {
    @Id
    private Long id;

    @Column(name = "type")
    private String type;
}
