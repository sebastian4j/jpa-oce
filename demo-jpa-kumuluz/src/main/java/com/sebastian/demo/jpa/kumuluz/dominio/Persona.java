package com.sebastian.demo.jpa.kumuluz.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * representa la persona.
 *
 * @author Sebastian Avila A.
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
