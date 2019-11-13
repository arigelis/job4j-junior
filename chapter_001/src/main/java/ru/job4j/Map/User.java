package ru.job4j.Map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthady;

    public User(String name, int children, Calendar birthady) {
        this.name = name;
        this.children = children;
        this.birthady = birthady;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthady() {
        return birthady;
    }

    public void setBirthady(Calendar birthady) {
        this.birthady = birthady;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + children;
        result = prime * result + ((birthady == null) ? 0 : birthady.hashCode());
        return result;
    }
}

