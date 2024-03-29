package fr.ocr.application.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationPK implements Serializable {

    @Column(name = "ouvrage_idouvrage", nullable = false)
    @Id
    private int ouvrageIdouvrage;

    @Column(name = "user_iduser", nullable = false)
    @Id
    private int userIduser;

}
