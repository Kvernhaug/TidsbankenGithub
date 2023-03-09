package no.noroff.tidsbankenbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Users {
    //================================================================================
    // Fields
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 320, nullable = false) // Max email address length = 320
    private String email;

    @Column(length = 64)
    private String picture;

    @Column(nullable = false)
    private boolean isAdmin;

    //================================================================================
    // Relationships
    //================================================================================
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "creator")
    private Set<IneligiblePeriod> createdIneligiblePeriods;

    @OneToMany(mappedBy = "user")
    private Set<VacationRequest> vacationRequests;

    @OneToMany(mappedBy = "admin")
    private Set<VacationRequest> administeredVacationRequests;
}
