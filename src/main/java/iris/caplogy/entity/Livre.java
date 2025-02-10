package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre  {
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
    @NotBlank(message = "nombres de de Pages is mandatory")
    private Integer nbPages;
    @NotBlank(message = "genre is mandatory")
    private String genre;

    // Getters et Setters
}
