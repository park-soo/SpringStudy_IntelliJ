package com.shop.repository;

import com.shop.dto.ItemDto;

import java.util.HashMap;

public interface ItemRepositoryForm {

    void createItem(ItemDto itemDto);
    ItemDto getItem(Long id);
    HashMap<Long, ItemDto> getItemAll();
    Long updateItem(ItemDto itemDto);
    void deleteItem(Long id);

}
