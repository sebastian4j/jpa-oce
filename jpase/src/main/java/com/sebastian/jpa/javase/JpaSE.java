package com.sebastian.jpa.javase;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.sebastian.jpa.javase.dominio.Direccion;
import com.sebastian.jpa.javase.dominio.Persona;

public class JpaSE {
  public static void main(final String[] args) {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("se-pu");
    final EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      final PersonaService ps = new PersonaService(em);
      Persona p1 = ps.nuevo(ThreadLocalRandom.current().nextInt(), UUID.randomUUID().toString());
      Persona p2 = ps.nuevo(ThreadLocalRandom.current().nextInt(), UUID.randomUUID().toString());
      System.out.println("persistido: " + p1);
      ps.stream().forEach(System.out::println);
      ps.listar().forEach(System.out::println);
      p1.getDireccion().add(new Direccion(0, "aaa", "bbb"));
      p1.getDireccion().add(new Direccion(0, "ddd", "ccc"));
      p1.getDireccion().add(new Direccion(0, "eee", "aaa"));
      p1.getTelefonos().add(67);
      p1.getTelefonos().add(68);
      p1.getTelefonos().add(4);
      ps.actualizar(p1);
      em.getTransaction().commit();
      em.getTransaction().begin();
      System.out.println("reobtenido:");
      // em.refresh(p1);
      p1 = ps.buscar(p1.getId());
      System.out.println(p1);
      em.getTransaction().commit();
      prueba(p1);
    } catch (final Exception e) {
      em.getTransaction().rollback();
      e.printStackTrace();
    }
  }

  private static void prueba(Persona p) {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("se-pu");
    final EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    PersonaService ps = new PersonaService(em);
    System.out.println("otro metodo:");
    Persona p2 = ps.buscar(p.getId());
    System.out.println("p2 (no-refresh): " + p2);
    em.refresh(p2);
    System.out.println("p2 (refresh): " + p2);
    System.out.println("p: " + p);
    System.out.println(p == p2);
    em.getTransaction().commit();
  }
}
