package fr.ocr.front_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OuvrageWeb {
    private int idouvrage;
    private String titre;
    private String auteur;
    private int quantite;
    private int nbreResa;
}