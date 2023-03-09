package no.noroff.tidsbankenbackend.model.dto.users;


import lombok.Data;

import java.util.Set;

/**
 * Character Data Transfer Object for get operations.
 */
@Data
public class UsersGetDTO {
    private int id;
    private String name;
    private String email;
    private String picture;
    private boolean isAdmin;
    private Set<Integer> comments;
    private Set<Integer> createdIneligiblePeriods;
    private Set<Integer> vacationRequests;
    private Set<Integer> administeredVacationRequests;
}
