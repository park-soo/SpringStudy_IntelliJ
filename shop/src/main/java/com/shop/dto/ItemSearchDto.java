package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {
    //상픔 등록일 all 1d 1w 1m 6m...
    private String searchDateType;
    private ItemSellStatus searchSellStatus;
    //검색 대상 itemNm or createdBy
    private String searchBy;
    private String searchQuery="";
}
