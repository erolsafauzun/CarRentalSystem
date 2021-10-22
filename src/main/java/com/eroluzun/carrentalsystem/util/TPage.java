package com.eroluzun.carrentalsystem.util;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

import java.util.List;

public class TPage <T>{

    private int number;         /* O an kaçıncı sayfanın gösterildiği */
    private int size;           /* Kayıtların kaçlı gösterildiği */
    private Sort sort;          /* Herhangi bir kolon sıralaması yapabilmesi için */
    private int totalPages;     /* Toplam oluşan sayfa */
    private Long totalElements; /* Toplam kaç kayıt var */
    private List<T> content;    /* Döneceğim datayı göstereceğim */

    public void setStat(Page page, List<T> list){

        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;

    }

}
