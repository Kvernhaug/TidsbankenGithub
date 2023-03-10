package no.noroff.tidsbankenbackend.services.users;

import no.noroff.tidsbankenbackend.model.Users;
import no.noroff.tidsbankenbackend.services.CrudService;

/**
 * Service interface for performing actions on Users entities.
 * Inherits generic CRUD actions form CrudService.
 */
public interface UsersService extends CrudService<Users, Integer> {
}
