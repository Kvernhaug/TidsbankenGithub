package no.noroff.tidsbankenbackend.model.dto.comment;


import lombok.Data;

/**
 * Comment DTO for post operations
 */
@Data
public class CommentPostDTO {
    private String message;
    private int user;
    private int vacationRequest;
}
