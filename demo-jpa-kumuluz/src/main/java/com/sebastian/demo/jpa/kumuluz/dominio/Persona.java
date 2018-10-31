package com.sebastian.demo.jpa.kumuluz.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * representa la persona.
 *
 * @author Sebastian Avila A.
 *
 */
@Entity
public class Persona {
  private @Id int id;
  private String nombre;

  public Persona() {}

  public Persona(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Persona [id=" + id + ", nombre=" + nombre + "]";
  }

}
