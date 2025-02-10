package iris.caplogy.controller;

import iris.caplogy.entity.Document;
import iris.caplogy.repository.DocumentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/documents")

public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/signDocument")
    public String showSignUpForm(Document document) {
        return "documents/add-document";
    }


    // Ajouter un document
    @PostMapping("/adddocument")
    public String addDocument(@Valid Document document, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "documents/add-document";
        }

        documentRepository.save(document);
        return "redirect:/indexD";
    }

    @GetMapping("/indexD")
    public String showDocumentListPage(Model model) {
        model.addAttribute("documents", documentRepository.findAll());
        return "documents/index";
    }

    @GetMapping("/editdocument/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid document Id:" + id));

        model.addAttribute("document", document);
        return "documents/update-document";
    }

    @PostMapping("/updatedocument/{id}")
    public String updateDocument(@PathVariable("id") long id, @Valid Document document,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            document.setId(id);
            return "documents/update-document";
        }

        documentRepository.save(document);
        return "redirect:/indexD";
    }

    // Supprimer document
    @GetMapping("/deletedocument/{id}")
    public String deleteDocument(@PathVariable("id") long id, Model model) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid document Id:" + id));
        documentRepository.delete(document);
        return "redirect:/indexD";
    }
}
