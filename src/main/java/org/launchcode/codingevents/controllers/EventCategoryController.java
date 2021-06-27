package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    public EventCategoryRepository eventCategories;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategories.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newEventCategory,
                                                 Errors errors,
                                                 Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("errorMsg", "Bad data!");
            return "eventCategories/create";
        }
        model.addAttribute("title", "Create Category");
        eventCategories.save(newEventCategory);
        return "redirect:";

    }

    @GetMapping("delete")
    public String renderDeleteCategoryForm(Model model) {
        model.addAttribute("title", "Delete Categories");
        model.addAttribute("categories", eventCategories.findAll());
        return "eventCategories/delete";
    }

    @PostMapping("delete")
    public String handleDeleteCategoryForm(@RequestParam(required = false) int[] categoryIds) {
        if (categoryIds != null) {
            for (int id : categoryIds) {
                eventCategories.deleteById(id);
            }
        }
        return "redirect:";
    }
}
