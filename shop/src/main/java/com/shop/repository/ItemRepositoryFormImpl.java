package com.shop.repository;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;

@Repository
public class ItemRepositoryFormImpl implements ItemRepositoryForm {

    private Long id = 0L;
    private HashMap<Long, ItemDto> itemMap;

    @PostConstruct      // DI(의존성 삽입) 이후에 실행이 되는 것
    public void init(){
        itemMap = new HashMap<Long, ItemDto>();
        for (int i=0;i<10;i++){
            id++;
            ItemDto itemDto = new ItemDto();
            itemDto.setId(id);
            itemDto.setItemNm("더미상품"+i);
            itemDto.setItemDetail("더미상품정보"+i);
            itemDto.setRegTime(LocalDateTime.now());
            itemDto.setPrice(1000*i);
            itemMap.put(id, itemDto);
        }
    }

    @Override
    public void createItem(ItemDto itemDto) {
        itemDto.setId(++id);
        itemMap.put(id,itemDto);
    }

    @Override
    public ItemDto getItem(Long id) {
        return itemMap.get(id);
    }

    @Override
    public HashMap<Long, ItemDto> getItemAll() {
        return itemMap;
    }

    @Override
    public Long updateItem(ItemDto itemDto) {
        Long id = itemDto.getId();
        itemMap.put(id,itemDto);
        return id;
    }

    @Override
    public void deleteItem(Long id) {
        itemMap.remove(id);
    }

    public Long getCurrId(){
        return id;
    }
}
