package com.jimmy9.management_jdbc.backend;

class Cmp{
    private String name;
    Cmp(){}
    Cmp(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\n";
    }
}