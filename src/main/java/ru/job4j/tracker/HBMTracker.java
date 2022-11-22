package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HBMTracker implements Store {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.createQuery("Update Item set name = :?fName where id = :fId")
                    .setParameter("fName", item.getName()).setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.createQuery("delete Item where id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Item");
            for (Object o : query.list()) {
                itemList.add((Item) o);
            }
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Item where name like :fName").setParameter("fName", key);
            for (Object o : query.list()) {
                itemList.add((Item) o);
            }
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query<Item> query = session.createQuery("from Item where id = :fId").setParameter("fId", id);
            item = query.uniqueResultOptional().get();
        }
        return item;
    }
}
