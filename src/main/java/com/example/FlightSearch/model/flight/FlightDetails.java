package com.example.FlightSearch.model.flight;

import com.example.FlightSearch.model.location.Airport;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FlightDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightType flightType;

    @Column(length = 50, nullable = false)
    private String flightNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departureAirportId", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrivalAirportId", nullable = false)
    private Airport arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(precision = 19, scale = 4, nullable = false)
    private BigDecimal price;
}
