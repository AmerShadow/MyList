package com.example.im_ranu.mylist;

public class ViewDetails {
    private String id,name,no;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    ViewDetails(String id, String name, String no){
        this.id=id;
        this.name=name;
        this.no=no;
    }
    ViewDetails(){

    }

}
