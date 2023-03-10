package no.noroff.tidsbankenbackend.repositories;

import no.noroff.tidsbankenbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Simple composed repository interface, for Users entity, that includes CrudRepository and PageableRepository.
 * Domain type  -> Users
 * ID type      -> Integer
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
