package com.sebastian.jpa.javase;

import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import com.sebastian.jpa.javase.dominio.Persona;

public class PersonaService {
  final EntityManager em;

  public PersonaService(final EntityManager em) {
    this.em = em;
  }

  public Persona nuevo(final int id, final String nombre) {
    final Persona p = new Persona(id, nombre);
    guardar(p);
    return p;
  }

  public void guardar(final Persona p) {
    em.persist(p);
  }

  public void actualizar(final Persona p, boolean enContexto) {
    final Persona pr;
    if (!enContexto) {
      pr = buscar(p.getId());
    } else {
      pr = p;
    }

    if (pr != null) {
      pr.setNombre(p.getNombre());
      em.merge(pr);
    }
  }

  public void eliminar(final int id) {
    final Persona pr = buscar(id);
    if (pr != null) {
      em.remove(pr);
    }
  }

  public Persona buscar(final int id) {
    return em.find(Persona.class, id);
  }

  public List<Persona> listar() {
    return em.createQuery("select e from Persona e", Persona.class).getResultList();
  }

  public Stream<Persona> stream() {
    return em.createQuery("select e from Persona e", Persona.class).getResultStream();
  }
}
