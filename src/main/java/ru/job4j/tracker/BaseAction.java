package ru.job4j.tracker;

/**
 * У нас есть два метода, которые полностью одинаковые.
 * Мы можем их вынеси в абстрактный класс.
 * (возможно не все методв нужно реализовывать
 * или они реализованы уже в абстрактном классе)
 */

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s.%s", this.key, this.name);
    }
}
