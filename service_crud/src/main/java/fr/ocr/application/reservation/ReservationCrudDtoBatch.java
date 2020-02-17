package fr.ocr.application.reservation;

import lombok.Value;

import java.util.Date;

@Value
public class ReservationCrudDtoBatch {

     int userIduser;
     int ouvrageIdouvrage;
     Date dateReservation;
}
