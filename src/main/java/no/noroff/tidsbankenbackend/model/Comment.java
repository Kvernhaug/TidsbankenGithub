package no.noroff.tidsbankenbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    //================================================================================
    // Fields
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 400, nullable = false)
    private String message;

    //================================================================================
    // Relationships
    //================================================================================
    @ManyToOne
    private Users user;
}