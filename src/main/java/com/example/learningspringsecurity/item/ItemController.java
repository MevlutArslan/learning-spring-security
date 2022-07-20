package com.example.learningspringsecurity.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(){
        return this.itemService.getItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable String id){
        return this.itemService.getItemByID(Long.parseLong(id));
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        this.itemService.addItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id){
        this.itemService.deleteItem(Long.parseLong(id));
    }
}
