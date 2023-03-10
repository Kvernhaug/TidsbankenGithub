package no.noroff.tidsbankenbackend.repositories;


import no.noroff.tidsbankenbackend.model.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequest, Integer> {
}
