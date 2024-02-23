package org.example.exo1_revision.controller;

import jakarta.validation.Valid;
import org.example.exo1_revision.model.Recepy;
import org.example.exo1_revision.service.RecepyInterface;
import org.example.exo1_revision.service.RecepyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller

public class RecepyController {
    private final RecepyService recepyService;

    @Autowired
    public RecepyController(RecepyService recepyService) {
        this.recepyService = recepyService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        List<Recepy> recepies = recepyService.getAll();
        model.addAttribute("recepies", recepies);
        return "home";
    }

    @GetMapping(value = "/detail/{recepyId}")
    public String showDetail(@PathVariable("recepyId") UUID id, Model model) {
        Recepy recepy = recepyService.getById(id);
        model.addAttribute("recepy", recepy);
        return "detail";

    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("recepy", new Recepy());
        return "form";
    }

    @PostMapping(value = "/add")
    public  String addRecepy(@Valid @ModelAttribute("recepy") Recepy recepy, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            String[] ingredientsArray = recepy.getIngredients().toArray(new String[0]);
            recepyService.add(recepy, ingredientsArray);

        }
            return "redirect:/";
        }
    @GetMapping(value = "/search")
    public String searchStudentByName(@RequestParam(name = "name", required = false) String name,
                                      Model model) {
        List<Recepy> recepies = recepyService.searchByTitle(name);
        if (!recepies.isEmpty()) {
            model.addAttribute("recepies", recepies);
            return "home";
        } else {
            return "error";
        }

    }


}
