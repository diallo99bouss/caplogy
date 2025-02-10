package iris.caplogy.controller;

import iris.caplogy.entity.Journal;
import iris.caplogy.repository.JournalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    JournalRepository journalRepository;

    @GetMapping("/signJournal")
    public String showSignUpForm(Journal journal) {
        return "journals/add-journal";
    }

    // Ajouter un journal
    @PostMapping("/addjournal")
    public String addJournal(@Valid Journal journal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "journals/add-journal";
        }

        journalRepository.save(journal);
        return "redirect:/journals/indexJ";
    }

    @GetMapping("/indexJ")
    public String showJournalListPage(Model model) {
        model.addAttribute("journals", journalRepository.findAll());
        return "journals/index";
    }

    @GetMapping("/journals/editjournal/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid journal Id:" + id));

        model.addAttribute("journal", journal);
        return "journals/update-journal"; // Vue à afficher
    }



  /*  @PostMapping("/updatejournal/{id}")
    public String updateJournal(@PathVariable("id") long id, @Valid Journal journal,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            journal.setId(id);
            return "journals/update-journal";
        }

        journalRepository.save(journal);
        return "redirect:/indexJ";
    }*/
    // Contrôleur - Mise à jour d'un journal
    @PostMapping("/updatejournal/{id}")
    public String updateJournal(@PathVariable("id") long id, @Valid Journal journal,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            journal.setId(id);
            return "journals/update-journal";
        }

        journalRepository.save(journal);
        return "redirect:/journals/indexJ"; // Redirection vers la liste des journaux
    }

    // Supprimer journal
    @GetMapping("/deletejournal/{id}")
    public String deleteJournal(@PathVariable("id") long id, Model model) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid journal Id:" + id));
        journalRepository.delete(journal);
        return "redirect:/journals/indexJ";
    }
}
