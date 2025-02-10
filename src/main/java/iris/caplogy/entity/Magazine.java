package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Magazine{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "titre is mandatory")
    private String titre;
    @NotBlank(message = "auteur is mandatory")
    private String auteur;
    @NotBlank(message = "datePublication is mandatory")
    private Date datePublication;
    @NotBlank(message = "disponibilite is mandatory")
    private Boolean disponibilite;
    private String editeur;
    private String frequencePub;
    private Integer numeroParution;

    // Getters et Setters
}
