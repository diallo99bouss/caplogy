package iris.caplogy.repository;

import iris.caplogy.entity.Utilisateur;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {}
