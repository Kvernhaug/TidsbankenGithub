package no.noroff.tidsbankenbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

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

    @Column(length = 64, nullable = false)
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
    @JoinColumn(nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Users admin;

    @OneToMany(mappedBy = "vacationRequest")
    private Set<Comment> comments;
}