package iris.caplogy.controller;

import iris.caplogy.entity.Utilisateur;
import iris.caplogy.repository.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Utilisateur utilisateur) {
        return "add-utilisateur";
    }

    @PostMapping("/addutilisateur")
    public String addUtilisateur(@Valid Utilisateur utilisateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-utilisateur";
        }

        utilisateurRepository.save(utilisateur);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUtilisateurList(Model model) {
        model.addAttribute("utilisateurs", utilisateurRepository.findAll());
        return "index";
    }
}
