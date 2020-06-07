package ru.job4j.tracker;

/*
СТАРЫЕ ВЕРСИИ МЕТОДОВ класса Tracker

---- Изменен способ хранения заявок - старая версия
position - показывает количество заявок
    private final Item[] items = new Item[100];

---- add - решение через массивы
this.items[this.position++] = item;


---- findById ---- решение через массивы -----
for (int i = 0; i < this.position; i++) {
    if ((this.items[i] != null) && (this.items[i].getId()).equals(id)) {
    result = items[i];
    break;

---- findById ---- решение через коллекции -----
    public Item findById(String id) {
        Item result = null;
        for (Item item:items) {
            if ((item != null) && (item.getId()).equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

---- findAll ---- решение через массивы ----
Item[] result = Arrays.copyOf(this.items, this.position);

--- findByName - решение через массивы
int count = 0;
Item[] tmp = new Item[this.position];
for (int i = 0; i < this.position; i++) {
    if ((this.items[i] != null) && (this.items[i].getName().equals(key))) {
    tmp[count] = this.items[i];
    count++;
    Item[] result = Arrays.copyOf(tmp, count);

-------- findByName - решение через коллекции
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>(0);
        for (Item item: items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }


--- delete - удаление заявок решение через массивы -----
for (int i = 0; i < this.position; i++) {
    if ((this.items[i] != null) && this.items[i].getId().equals(id)) {
        System.arraycopy(this.items, (i + 1), this.items, i, this.position - (i + 1));
        this.position--;
        this.items[this.position] = null;
        result = true;
        break;

---- replace - замена заявки решение через массивы -----
for (int i = 0; i < this.position; i++) {
    if (this.items[i].getId().equals(id)) {
        items[i] = item;
        item.setId(id);
        result = true;
        break;
*/