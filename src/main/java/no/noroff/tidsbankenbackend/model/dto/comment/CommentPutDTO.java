package no.noroff.tidsbankenbackend.model.dto.comment;

import lombok.Data;

/**
 * Comment DTO for put operations.
 */
@Data
public class CommentPutDTO {
    private int id;
    private String message;
}
