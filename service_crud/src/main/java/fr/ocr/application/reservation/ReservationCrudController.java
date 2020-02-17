/*
 *
 * Controlleur :
 * *
 * * Renvoie la liste des prets d'un usager dont le nom est passé en param. méthode GET
 * * Renvoie la liste des prets HORS-Delai selon date et periode (ex : date du jour et période = 4 semaines)
 * * Prolonge un pret d'un usager. méthode PUT
 * * Crée un pret pour un idOuvrage et un idUsager passé en params
 * * Restitue un pret pour un idOuvrage et un idUsager passé en params
 */
package fr.ocr.application.reservation;

import fr.ocr.application.ouvrage.OuvrageCrudService;
import fr.ocr.application.user.UserCrudService;
import fr.ocr.exception.PrjExceptionHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Synchronized;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(value = "APIs de gestion des Prets.")
@RestController
public class ReservationCrudController {

    final ReservationCrudService reservationCrudService;
    final UserCrudService userCrudService;
    final OuvrageCrudService ouvrageCrudService;
    final PrjExceptionHandler prjExceptionHandler;

    public ReservationCrudController(ReservationCrudService reservationCrudService,
                                     UserCrudService userCrudService,
                                     OuvrageCrudService ouvrageCrudService,
                                     PrjExceptionHandler prjExceptionHandler) {
        this.reservationCrudService = reservationCrudService;
        this.userCrudService = userCrudService;
        this.ouvrageCrudService = ouvrageCrudService;
        this.prjExceptionHandler = prjExceptionHandler;
    }

    @ApiOperation(value = "Récupère les réservation d'un usager grâce à son nom")
    @GetMapping(value="/CriteriaListeReservation/{userName}",  produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Synchronized
    public  List<ReservationCrudDtoWeb> getReservationByNomUsagerCriteria(@PathVariable String userName) throws  RuntimeException{
        List<ReservationCrudDtoWeb> reservationCrudDtoWebList = new ArrayList<>();
// TODO
         List<Reservation> reservations= reservationCrudService.findReservationsByUserIduser(userCrudService.getUserByNom(userName).getIdUser());

         return reservationCrudDtoWebList;
    }

    @ApiOperation(value = "Récupère le npmbre de resa par ouvrage")
    @GetMapping(value="/NombreDeReservations/{idOuvrage}",  produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Synchronized
    public  Integer  getNombreReservationByTitreOuvrage(@PathVariable String idOuvrage) throws  RuntimeException{
        return reservationCrudService.getCountReservationByOuvrageId(Integer.parseInt(idOuvrage));
    }

}
