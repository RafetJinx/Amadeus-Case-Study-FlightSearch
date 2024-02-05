package com.example.FlightSearch.model.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "IndividualUser")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndividualUser extends BaseUser {
    @Column(length = 50)
    private String personalId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 50)
    private String email;
}
