package com.shop.service;

import com.shop.dto.ItemDto;
import com.shop.repository.ItemRepositoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ItemServiceFormImpl implements ItemServiceForm{
    @Autowired
    private ItemRepositoryForm itemRepo;
    @Override
    public void createItem(ItemDto itemDto) {
        itemRepo.createItem(itemDto);
    }

    @Override
    public ItemDto getItem(Long id) {
        return itemRepo.getItem(id);
    }

    @Override
    public HashMap<Long, ItemDto> getItemAll() {
        return itemRepo.getItemAll();
    }

    @Override
    public Long updateItem(ItemDto itemDto) {
        return itemRepo.updateItem(itemDto);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepo.deleteItem(id);
    }
}
