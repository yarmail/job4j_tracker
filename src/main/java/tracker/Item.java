package tracker;

import java.util.Objects;

/**
 *  class Item describe the business model of the application
 *  Класс Item описывает бизнес-модель заявки
 *
 */

public class Item implements Comparable<Item> {
    private String id;
    private String name;

    public  Item(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Item o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return  name.equals(item.name) && id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}