package beno.dev.springdemo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import beno.dev.springdemo.model.Item;
import beno.dev.springdemo.repository.ItemRepository;

@Controller
public class YourController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("currentDateTime", LocalDateTime.now());
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }
       @GetMapping("/addPage")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add")
    public String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        Optional<Item> item = itemRepository.findById(id);
        model.addAttribute("item", item);

        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, Item editedItem) {

        Optional<Item> item = itemRepository.findById(id);
        Item existingItem = item.get();
        existingItem.setName(editedItem.getName()); 
        itemRepository.save(existingItem);

        return "redirect:/";
    }

}