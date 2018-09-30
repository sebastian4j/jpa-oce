package com.example.sebastian.demo.sb.jpa.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.sebastian.demo.sb.jpa.dominio.Persona;

@Component
public class PersonaService {
  @Autowired
  private EntityManager em;

  public Persona obtener(final int id) {
    return em.find(Persona.class, id);
  }

  public void save(final Persona p) {
    em.persist(p);
  }

  public void actualizar(final Persona p) {
    em.merge(p);
  }

  public void delete(final Persona p) {
    em.remove(obtener(p.getId()));
  }

  public void delete(final int id) {
    em.remove(obtener(id));
  }

  public List<Persona> findAll() {
    return em.createQuery("select e from Persona e", Persona.class).getResultList();
  }
}
