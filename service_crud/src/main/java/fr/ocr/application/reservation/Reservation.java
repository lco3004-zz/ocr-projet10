package fr.ocr.application.reservation;

import fr.ocr.application.ouvrage.Ouvrage;
import fr.ocr.application.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "reservation", schema = "sch10", catalog = "db_projet10")
@IdClass(ReservationPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name = "Reservation.findReservationByUser",
            query = "select  p.dateReservation , o.auteur , o.titre from Reservation p , " +
                    "in (p.ouvrageByOuvrageIdouvrage) as o " +
                    " where p.userByUserIduser = :User")

public class Reservation implements Serializable {

    @Transient
    static final long serialVersionUID = 6453291303625368221L;

    @Id
    @Column(name = "ouvrage_idouvrage", nullable = false)
    private int ouvrageIdouvrage;

    @Id
    @Column(name = "user_iduser", nullable = false)
    private int userIduser;


    @Basic
    @Column(name = "date_reservation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateReservation;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ouvrage_idouvrage", referencedColumnName = "idouvrage", nullable = false, insertable=false, updatable=false)
    private Ouvrage ouvrageByOuvrageIdouvrage;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable=false, updatable=false)
    private User userByUserIduser;

    @ToString.Exclude
    @Transient
    private String auteurOuvrage;

    @ToString.Exclude
    @Transient
    private String titreOuvrage;

    public Reservation(int idouvrage, int iduser, int pretprolonge, Date dateReservation) {
        this.ouvrageIdouvrage=idouvrage;
        this.userIduser=iduser;
        this.dateReservation = dateReservation;
    }

    @PostLoad
    void chargeInfosOuvrage() {
        auteurOuvrage=ouvrageByOuvrageIdouvrage.getAuteur();
        titreOuvrage=ouvrageByOuvrageIdouvrage.getTitre();
    }

}
