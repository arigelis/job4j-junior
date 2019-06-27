package ru.job4j;

public abstract class AbstractStore <T extends Base>{
    public abstract void add(T model);

    public abstract boolean replace(String id, T model);

    public abstract boolean delete(String id);

    public abstract Base findById(String id);
}
