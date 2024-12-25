package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public  class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDocument;
    @NotBlank(message = "titre is mandatory")
    private String titre;
    @NotBlank(message = "auteur is mandatory")
    private String auteur;
    @NotBlank(message = "datePublication is mandatory")
    private Date datePublication;
    @NotBlank(message = "disponibilite is mandatory")
    private Boolean disponibilite;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<Emprunt> emprunts;



    // Getters et Setters
}
