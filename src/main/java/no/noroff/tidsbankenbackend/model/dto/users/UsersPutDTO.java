package no.noroff.tidsbankenbackend.model.dto.users;


import lombok.Data;

/**
 * Users DTO for put operations.
 * These fields are required when you perform a put operation.
 */
@Data
public class UsersPutDTO {
    private int id;
    private String name;
    private String email;
    private boolean isAdmin;
}
