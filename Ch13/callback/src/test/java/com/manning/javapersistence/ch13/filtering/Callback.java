 package com.manning.javapersistence.ch13.filtering;

import com.manning.javapersistence.ch13.filtering.callback.CurrentUser;
import com.manning.javapersistence.ch13.filtering.callback.Item;
import com.manning.javapersistence.ch13.filtering.callback.Log;
import com.manning.javapersistence.ch13.filtering.callback.User;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Callback {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ch13");

    @Test
    public void notifyPostPersist() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        {
            User user = new User("johndoe");
            CurrentUser.INSTANCE.set(user); // Thread-local

            em.persist(user);
            assertEquals(0, Log.INSTANCE.size());
            em.flush();
            assertEquals(1, Log.INSTANCE.size());
            assertTrue(Log.INSTANCE.get(0).contains("johndoe"));
            Log.INSTANCE.clear();


            Item item = new Item("Foo", user);
            em.persist(item);
            assertEquals(0, Log.INSTANCE.size());
            em.flush();
            assertEquals(1, Log.INSTANCE.size());
            assertTrue(Log.INSTANCE.get(0).contains("johndoe"));
            Log.INSTANCE.clear();

            CurrentUser.INSTANCE.set(null);
        }
        em.clear();

        em.getTransaction().rollback();

    }

}
