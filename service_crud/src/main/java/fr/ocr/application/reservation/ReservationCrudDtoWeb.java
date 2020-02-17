package fr.ocr.application.reservation;


import lombok.Value;

import java.util.Date;

@Value
public class ReservationCrudDtoWeb {
     int ouvrageIdouvrage;
     int userIduser;
     Date dateDisponibilite;
     int nombreDeReservation;
}


