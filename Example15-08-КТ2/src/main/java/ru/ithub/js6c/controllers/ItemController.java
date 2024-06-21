package ru.ithub.js6c.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ithub.js6c.models.Item;
import ru.ithub.js6c.services.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("item", itemService.findAll());
        return "item/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.findOne(id));
        return "item/show";
    }

    @GetMapping("/new")
    public String newItem(@ModelAttribute("item") Item item) {
        return "item/new";
    }

    @PostMapping
    public String create(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "item/new";

        itemService.save(item);
        return "redirect:/item";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.findOne(id));
        return "item/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "item/edit";

        itemService.update(id, item);
        return "redirect:/item";
    }

    @DeleteMapping
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirest:/item";
    }
}