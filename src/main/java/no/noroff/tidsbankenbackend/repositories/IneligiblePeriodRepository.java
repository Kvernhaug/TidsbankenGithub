package no.noroff.tidsbankenbackend.repositories;


import no.noroff.tidsbankenbackend.model.IneligiblePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IneligiblePeriodRepository extends JpaRepository<IneligiblePeriod, Integer> {
}
