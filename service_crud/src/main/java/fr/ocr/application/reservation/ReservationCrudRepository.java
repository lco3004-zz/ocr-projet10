/*
 *
 * les 'repositories'
 * findPretBydUserIdWithCriteria est basée sur API Criteria
 * le repo est étendu par cette interface findPretBydUserIdWithCriteria
 *
 *
 */


package fr.ocr.application.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationCrudRepository extends JpaRepository<Reservation,Integer> ,
        JpaSpecificationExecutor<Reservation>,ReservationRepositoryCustom {

    Optional<Reservation> findReservationByOuvrageIdouvrageAndUserIduser(int idouvrage, int idusager) ;
    List<Reservation> findReservationsByUserIduser(int idusager);

    Integer countAllByOuvrageIdouvrage(int idouvrage);
}

interface ReservationRepositoryCustom{
    List<ReservationCrudDtoWeb> findReservationBydUserIdWithCriteria(Integer idUsager);
}

class ReservationRepositoryCustomImpl implements ReservationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ReservationCrudDtoWeb> findReservationBydUserIdWithCriteria(Integer idUsager) {
        return null;
    }
}

