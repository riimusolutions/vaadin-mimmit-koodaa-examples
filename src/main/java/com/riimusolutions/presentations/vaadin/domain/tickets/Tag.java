package com.riimusolutions.presentations.vaadin.domain.tickets;

public class Tag {
    private Long id;
    private String color;
    private String name;

    public static Tag of(String name, String color) {
        Tag tag = new Tag();
        tag.name = name;
        tag.color = color;
        return tag;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
