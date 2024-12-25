package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @NotBlank(message = "nom is mandatory")
    private String nom;
    @NotBlank(message = "prenom is mandatory")
    private String prenom;
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "telephone is mandatory")
    private String tel;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
      private Set<Emprunt> emprunts;

    // Getters et Setters
}
