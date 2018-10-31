package com.sebastian.demo.jpa.kumuluz;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.sebastian.demo.jpa.kumuluz.dominio.Persona;

/**
 * servicio para la persistencia de personas.
 *
 * @author Sebastian Avila A.
 *
 */
@RequestScoped
@Transactional
public class PersonaService {

  @PersistenceContext(unitName = "kum-jpa")
  private EntityManager em;

  /**
   * obtiene una persona por su identificador.
   *
   * @param id
   * @return
   */
  public Persona obtener(final int id) {
    return em.find(Persona.class, id);
  }

  /**
   * persiste una persona.
   *
   * @param p
   */
  public void persistir(final Persona p) {
    em.persist(p);
  }

  /**
   * actualiza los datos de una persona.
   *
   * @param p
   */
  public void actualizar(final Persona p) {
    em.merge(p);
  }

  /**
   * elimina una persona por su identificador.
   *
   * @param id
   */
  public void eliminar(final int id) {
    em.remove(obtener(id));
  }

  /**
   * obtiene todas las personas.
   *
   * @return
   */
  public List<Persona> todas() {
    return em.createQuery("select e from Persona e", Persona.class).getResultList();
  }
}
