package com.example.learningspringsecurity.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItemByID(Long id) {
        return this.itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Item> getItems() {
        return this.itemRepository.findAll();
    }

    public void addItem(Item item) {
        this.itemRepository.save(item);
    }

    public void deleteItem(Long id) {
       Item item = this.itemRepository.findById(id).orElseThrow(NoSuchElementException::new);

       this.itemRepository.delete(item);
    }
}
