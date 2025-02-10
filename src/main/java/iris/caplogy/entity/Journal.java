package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "titre is mandatory")
    private String titre;
    @NotBlank(message = "auteur is mandatory")
    private String auteur;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePublication;
    @NotNull(message = "La disponibilité est obligatoire")
    private Boolean disponibilite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dateParution;

    // Getters et Setters
}
