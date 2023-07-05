package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
            Member findMember = em.find(Member.class, 1L);


            em.persist(findMember);
            tx.commit();

        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }





        emf.close();

    }
}