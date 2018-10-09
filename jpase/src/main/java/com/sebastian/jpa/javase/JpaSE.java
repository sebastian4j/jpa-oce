package com.sebastian.jpa.javase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.sebastian.jpa.javase.dominio.Departamento;
import com.sebastian.jpa.javase.dominio.Direccion;
import com.sebastian.jpa.javase.dominio.Hijo;
import com.sebastian.jpa.javase.dominio.Mascota;
import com.sebastian.jpa.javase.dominio.MascotaPatas;
import com.sebastian.jpa.javase.dominio.Notebook;
import com.sebastian.jpa.javase.dominio.OrientacionGeografica;
import com.sebastian.jpa.javase.dominio.Persona;
import com.sebastian.jpa.javase.dominio.TelefonoTipo;

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
      final Map<TelefonoTipo, String> telefonos = new HashMap<>();
      telefonos.put(TelefonoTipo.PERSONAL, "123456");
      telefonos.put(TelefonoTipo.TRABAJO, "56789");
      final Map<Integer, Hijo> hijos = new HashMap<>();
      hijos.put(24921397, new Hijo(24921397, "Elías", p1));
      hijos.put(16735546, new Hijo(16735546, "papi", p1));
      p1.setHijos(hijos);
      final Map<Integer, Departamento> departamentos = new HashMap<>();
      departamentos.put(1, new Departamento(OrientacionGeografica.ESTE, p1));
      departamentos.put(2, new Departamento(OrientacionGeografica.NORTE, p1));
      final Map<Date, Notebook> notes = new HashMap<>();
      notes.put(new Date(), new Notebook("marca-1", "modelo-1"));
      notes.put(new Date(), new Notebook("marca-2", "modelo-2"));
      p1.setNotebooks(notes);
      p1.setDeptos(departamentos);
      p1.setTelefonoMap(telefonos);

      MascotaPatas mp1 = new MascotaPatas(1, 1);
      Mascota m1 = new Mascota(mp1);
      MascotaPatas mp2 = new MascotaPatas(2, 2);
      Mascota m2 = new Mascota(mp1);
      m1.setPersona(p1);
      m2.setPersona(p1);
      final Map<MascotaPatas, Mascota> mascotas = new HashMap<>();
      mascotas.put(mp1, m1);
      mascotas.put(mp2, m2);
      p1.setMascotas(mascotas);

      p1.getTelefonos().add(67);
      p1.getTelefonos().add(68);
      p1.getTelefonos().add(4);
      ps.actualizar(p1, true);
      em.getTransaction().commit();
      em.getTransaction().begin();
      System.out.println("reobtenido:");
      // em.refresh(p1);
      p1 = ps.buscar(p1.getId());
      System.out.println(p1);
      em.getTransaction().commit();

    } catch (final Exception e) {
      e.printStackTrace();
      em.getTransaction().rollback();
    }
    // emf.close();
  }
}
