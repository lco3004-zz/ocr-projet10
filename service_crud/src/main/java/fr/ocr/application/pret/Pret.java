package fr.ocr.application.pret;

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
@Table(name = "pret", schema = "pret", catalog = "db_projet07")
@IdClass(PretPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name = "Pret.findPretsByUser",
            query = "select  p.dateEmprunt , o.auteur , o.titre from Pret p , " +
                    "in (p.ouvrageByOuvrageIdouvrage) as o " +
                    " where p.userByUserIduser = :User")

public class Pret implements Serializable {

    @Transient
    static final long serialVersionUID = 6453281303625368221L;

    @Id
    @Column(name = "ouvrage_idouvrage", nullable = false)
    private int ouvrageIdouvrage;

    @Id
    @Column(name = "user_iduser", nullable = false)
    private int userIduser;

    @Basic
    @Column(name = "pret_prolonge", nullable = false)
    private int pretprolonge;

    @Basic
    @Column(name = "date_emprunt", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;

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

    public Pret(int idouvrage, int iduser, int pretprolonge, Date dateEmprunt) {
        this.ouvrageIdouvrage=idouvrage;
        this.userIduser=iduser;
        this.pretprolonge=pretprolonge;
        this.dateEmprunt=dateEmprunt;
    }

    @PostLoad
    void chargeInfosOuvrage() {
        auteurOuvrage=ouvrageByOuvrageIdouvrage.getAuteur();
        titreOuvrage=ouvrageByOuvrageIdouvrage.getTitre();
    }

}
