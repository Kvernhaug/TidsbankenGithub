package no.noroff.tidsbankenbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Hibernate method for creating SQL ineligible_period table
 */
@Entity
@Getter
@Setter
public class IneligiblePeriod {
    //================================================================================
    // Fields
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date periodStart;

    @Column(nullable = false)
    private Date periodEnd;

    //================================================================================
    // Relationships
    //================================================================================
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users creator;
}
