package com.sebastian.jpa.javase.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sebastian Avila A. <sebastian4j at gmail.com>
 */
@Entity
public class Hijo {

  @Id
  private int rut;
  private String nombre;
  @ManyToOne(cascade = CascadeType.ALL)
  private Persona padre;

  public Hijo() {}

  public Persona getPadre() {
    return padre;
  }

  public void setPadre(Persona padre) {
    this.padre = padre;
  }

  public Hijo(final int rut, final String nombre, final Persona p) {
    this.rut = rut;
    this.nombre = nombre;
    padre = p;
  }

  public int getRut() {
    return rut;
  }

  public void setRut(int rut) {
    this.rut = rut;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
