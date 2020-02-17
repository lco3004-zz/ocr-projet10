/*
 * Service :
 * renvoie la liste des prets d'un usager dont l'Id est pass� en apram�tre
 * prolonge un pret dont l' idOuvrage et l' idUser sont pass�s en param�tres
 * * "prolonger" signifie : mettre � jour la date du pret et le flagg� comme renouvel�
 * ajoute un pret dont l' idOuvrage et l' idUser sont pass�s en param�tres
 * supprime un pret dont l' idOuvrage et l' idUser sont pass�s en param�tres
 * renvoie la liste des prets dont la date d'emprunt est < � la date pass�e en parametre
 */
package fr.ocr.application.reservation;

import fr.ocr.exception.PrjExceptionHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationCrudService {

    final ReservationCrudRepository reservationCrudRepository;
    final PrjExceptionHandler prjExceptionHandler;

    public ReservationCrudService(ReservationCrudRepository reservationCrudRepository, PrjExceptionHandler prjExceptionHandler) {
        this.reservationCrudRepository = reservationCrudRepository;
        this.prjExceptionHandler = prjExceptionHandler;
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ReservationCrudDtoWeb> getReservationsByUsagerIdWithCriteria(int idUsager) throws  RuntimeException{
        List<ReservationCrudDtoWeb> reservationCrudDtoWebs = reservationCrudRepository.findReservationBydUserIdWithCriteria(idUsager);
        if (reservationCrudDtoWebs.isEmpty())
            prjExceptionHandler.throwPretNotAcceptable("aucun pr�t en cours");
        return reservationCrudDtoWebs;
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Optional<Reservation> isReservationExiste(int idouvrage, int idusager) {
        return reservationCrudRepository.findReservationByOuvrageIdouvrageAndUserIduser(idouvrage,idusager);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<Reservation> findReservationsByUserIduser(int idUser) {
        return reservationCrudRepository.findReservationsByUserIduser(idUser);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Integer getCountReservationByOuvrageId(int idouvrage) {
        Integer nbResa ;
        try {
            nbResa = reservationCrudRepository.countAllByOuvrageIdouvrage(idouvrage);
        }catch (Exception e) {
            nbResa =0;
        }
        return nbResa;
    }

}

