package ru.job4j.tracker;

import java.util.Objects;

/**
 *  class Item describe the business model of the application
 *  Класс Item описывает бизнес-модель заявки
 *
 * id - unique key (уникальный ключ), для этой задачи - типа String
 * name - имя заявки
 * desc - description (описание заявки)
 * time - application creation time (время создания заявки)
 *
 */

public class Item {
    private String id;
    private String name;
    private String decs;
    private long time;
    /**
     * Конструктор.
     * Как я понимаю, ключ генерируется в классе Tracker
     */
    public Item(String name, String decs, long time) {
        this.name = name;
        this.decs = decs;
        this.time = time;
    }
    /**
     * геттер и сеттер для id
     * Как я понимаю, ключ генерируется в классе Tracker
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /**
     * геттер и сеттер для name
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * геттер и сеттер для desc
     */
    public String getDecs() {
        return decs;
    }
    public void setDecs(String desc) {
        this.decs = desc;
    }
    /**
     * геттер и сеттер для time
     */
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Override method  equals() for comparе objects
     * Переопределяем метод equals() для сравнения объектов
     * (в том числе, по параметрам)
     * @param obj - объект для сравнения
     * if (this == 0) Если ссылки на объекты одинаковы, то и объекты одинаковы
     * if (obj == null) Если сравниваемый объект не существет, результат false
     * if (getClass()!= obj.getClass() Если ссылки на исходный класс не равны, результат false
     * Item item = (Item) obj; Downcasting приведение типов от Object к Item
     * далее сравнение полей объектов
     * через java.util.Objects.equals() (из-за удобства?)
     * @return  true or false
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj == null) {
            result = false;
        }
        if (getClass() != obj.getClass()) {
            result = false;
        }
        Item item = (Item) obj;
        result =
                time == item.time
                        && Objects.equals(id, item.id)
                        && Objects.equals(name, item.name)
                        && Objects.equals(decs, item.decs);
        return result;
    }

    /**
     *
     * Используем java.util.Objects.hash()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, decs, time);
    }
}