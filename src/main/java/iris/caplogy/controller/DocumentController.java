package iris.caplogy.controller;

import iris.caplogy.entity.Document;
import iris.caplogy.repository.DocumentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;
    @GetMapping("/signupdoc")
    public String showSignUpForm(Document document) {
        return "documents/add-document";
    }
    @PostMapping("/adddocument")
    public String addDocument(@Valid Document document, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "documents/add-document";
        }

        documentRepository.save(document);
        return "redirect:/indexdoc";
    }
    @GetMapping("/indexdoc")
    public String showDocumentList(Model model) {
        model.addAttribute("documents", documentRepository.findAll());
        return "documents/index";
    }
    @GetMapping("/editdoc/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Document documents = documentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid documents Id:" + id));

        model.addAttribute("document", documents);
        return "documents/update-document";
    }
    @PostMapping("/updatedoc/{idDocument}")
    public String updateProfesseur(@PathVariable("idDocument") long idDocument, @Valid Document document,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            document.setIdDocument(idDocument);
            return "documents/update-document";
        }

        documentRepository.save(document);
        return "redirect:/indexdoc";
    }

}
