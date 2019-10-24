package ru.geekbrains.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persistence.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(User user) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void update(User user) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> findAll() {
        EntityManager em = sessionFactory.createEntityManager();
        List<User> users = em.createQuery("from User", User.class).getResultList();
        em.close();
        return users;
    }

    public User findById(Long id) {
        EntityManager em = sessionFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }
}