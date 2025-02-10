package iris.caplogy.controller;

import iris.caplogy.entity.Utilisateur;
import iris.caplogy.repository.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/signUser")
    public String showSignUpForm(Utilisateur utilisateur) {
        return "utilisateurs/add-utilisateur";
    }
    @GetMapping("/accueil")
    public String accueilPage() {
        return "accueil";
    }

    @GetMapping("/index")
    public String showUtilisateurList(Model model) {
        model.addAttribute("utilisateurs", utilisateurRepository.findAll());
        return "index";
    }
    //ajouter un utilisateur
    @PostMapping("/addutilisateur")
    public String addUtilisateur(@Valid Utilisateur utilisateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "utilisateurs/add-utilisateur";
        }
        utilisateurRepository.save(utilisateur);
        return "redirect:/indexU";
    }
    // modifier un utilisateur
    @GetMapping("/edituser/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateurs/update-user";
    }
    @PostMapping("/updateuser/{id}")
    public String updateUtilisateur(@PathVariable("id") long id, @Valid Utilisateur utilisateur,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            utilisateur.setId(id);
            return "utilisateurs/update-user";
        }
        utilisateurRepository.save(utilisateur);
        return "redirect:/indexU";
    }

    // Supprimer utilisateur
    @GetMapping("/deleteuser/{id}")
    public String deleteUtilisateur(@PathVariable("id") long id, Model model) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        utilisateurRepository.delete(utilisateur);
        return "redirect:/indexU";
    }


}
