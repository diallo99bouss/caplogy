package iris.caplogy.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    private Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourEffective;

    // Getters et Setters
}
