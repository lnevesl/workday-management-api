package DiaTrabalhado.cadTrabDia.persistence.repositories;

import DiaTrabalhado.cadTrabDia.persistence.entities.DayWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface DayWorkRepository extends JpaRepository<DayWorkEntity , Long> {

    List<DayWorkEntity> findAll();
    List<DayWorkEntity> findByActive(Boolean active);
    Optional<DayWorkEntity> findByDayWorkIdAndActive(Long dayWorkId, Boolean active);
}
