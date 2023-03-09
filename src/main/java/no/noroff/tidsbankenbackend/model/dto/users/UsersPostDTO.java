package no.noroff.tidsbankenbackend.model.dto.users;


import lombok.Data;

/**
 * Users Data Transfer Object for post operations
 */
@Data
public class UsersPostDTO {
    private String name;
    private String email;
    private boolean isAdmin;
}
