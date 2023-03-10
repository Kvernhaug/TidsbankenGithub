package no.noroff.tidsbankenbackend.services.users;

import no.noroff.tidsbankenbackend.model.Users;
import no.noroff.tidsbankenbackend.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsersServiceImpl implements UsersService {
    /**
     * Most of the implemented methods relies on functionality
     * provided by the CharacterRepository
     */
    private final UsersRepository usersRepository;

    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findById(Integer id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Collection<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users add(Users entity) {
        return usersRepository.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return usersRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void delete(Users entity) {
        usersRepository.delete(entity);
    }
}
