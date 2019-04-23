package com.sebastian.mueve.lista;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastián Ávila A.
 */
public class App {

    private void crear() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("copia-pu");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        var p1 = new Persona();
        p1.setNombre("p1");
        var p2 = new Persona();
        p2.setNombre("p2");
        var c1 = new Cosa();
        c1.setNombre("c1");
        var c2 = new Cosa();
        c2.setNombre("c2");
        p1.getCosas().add(c1);
        p1.getCosas().add(c2);
        c1.setPersona(p1);
        c2.setPersona(p2);
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
    }

    private void copiar() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("copia-pu");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        final var p1 = em.find(Persona.class, 3);
        final var p2 = em.find(Persona.class, 4);
        System.out.println("cosas de p1: " + p1.getCosas().size());
        System.out.println("cosas de p2: " + p2.getCosas().size());
        final Set<Cosa> cosas = p1.getCosas();
        //final Set<Cosa> otrasCosas = new HashSet<>();
        //cosas.iterator().forEachRemaining(otrasCosas::add);
        cosas.iterator().forEachRemaining(c -> c.setPersona(p2));
        p2.setCosas(cosas);
        p1.setCosas(null);
        System.out.println("cosas de p1: " + p1.getCosas().size());
        System.out.println("cosas de p2: " + p2.getCosas().size());
        em.merge(p1);
        em.merge(p2);
        ///////////////////
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        // new App().crear();
        new App().copiar();
    }
}
