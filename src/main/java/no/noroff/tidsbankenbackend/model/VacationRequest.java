package no.noroff.tidsbankenbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class VacationRequest {
    //================================================================================
    // Fields
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private Date periodStart;

    @Column(nullable = false)
    private Date periodEnd;

    @Column(nullable = false)
    private VacationRequestStatus status;

    //================================================================================
    // Relationships
    //================================================================================
    @ManyToOne
    private Users user;

    @ManyToOne
    private Users admin;
}