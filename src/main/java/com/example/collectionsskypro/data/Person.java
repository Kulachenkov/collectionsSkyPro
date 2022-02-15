package com.example.collectionsskypro.data;

public class Person {
    private String name;
    private boolean block;

    public Person(String name, boolean block) {
        this.name = name;
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
