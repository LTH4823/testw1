package org.zerock.testw1.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ListDTO {

    private int page;

    private int size;

    //t tc tcw
    private String type;

    private String keyword;

    public ListDTO() {
        this.page = 1;
        this.size = 10;
    }

    public String[] getTypes() {

        if (type == null) {
            return new String[]{};
        }
        return type.split("");

    }


    public String getKeyword(){
        return keyword;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        //효율은 좋으나 가독성이 나쁨
//        this.size = size < 10? 10: size >= 1000 ? 10:size;
        this.size = size < 10 ? 10 : size;
    }

    public int getSkip() {
        return (this.page - 1) * size;
    }

}
