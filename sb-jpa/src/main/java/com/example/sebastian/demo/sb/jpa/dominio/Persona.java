package com.example.sebastian.demo.sb.jpa.dominio;

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

  @Override
  public String toString() {
    return "Persona [id=" + id + ", nombre=" + nombre + "]";
  }


}
