package no.noroff.tidsbankenbackend.model.dto.comment;


import lombok.Data;

import java.util.Set;

/**
 * Comment Data Transfer Object for get operations.
 */
@Data
public class CommentGetDTO {
    private int id;
    private String message;
    private int user;
    private int vacationRequest;
}
