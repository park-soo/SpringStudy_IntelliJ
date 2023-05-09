package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //상품코드
    @Column(nullable = false, length = 50)  //nullable=false -> not null 조건
    private String itemNm;  //상품명
    @Column(name = "price", nullable = false)
    private int price;  //가격
    @Column(nullable = false)
    private int stockNumber; //재고수량
    @Lob        //대용량
    @Column(nullable = false)
    private String itemDetail;   //상품 상세 설명
    @Enumerated(EnumType.STRING)    //Enum 타입 설정
    private ItemSellStatus itemSellStatus;  //상품 판매 상태
    //@UpdateTimestamp

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }
}
