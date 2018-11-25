package com.kilopo.kosshop.entity;

public enum Color {
    BLACK("black"), BLUE("blue"), LIGHTBLUE("lightblue"), GRAY("gray"), GREEN("green"), LIGHTGREEN("lightgreen"),
    ORANGE("orange"), PINK("pink"), RED("red"), YELLOW("yellow"), WHITE("white"), BROWN("brown"), BORDEAUX("bordeaux"),
    POWDER("powder"), SILVER("silver");

    private String value;

    private Color(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
