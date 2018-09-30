package com.sebastian.jpa.javase.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
public class Persona {
  @Id
  private int id;
  private String nombre;
  @Transient
  private int abc;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @OrderBy("comuna DESC")
  private List<Direccion> direccion;
  @ElementCollection
  @OrderColumn
  private List<Integer> telefonos;

  public Persona() {

  }

  public Persona(final int id, final String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public List<Integer> getTelefonos() {
    if (telefonos == null) {
      telefonos = new ArrayList<>();
    }
    return telefonos;
  }

  public void setTelefonos(List<Integer> telefonos) {
    this.telefonos = telefonos;
  }

  public int getId() {
    return id;
  }

  public List<Direccion> getDireccion() {
    if (direccion == null) {
      direccion = new ArrayList<>();
    }
    return direccion;
  }

  public void setDireccion(List<Direccion> direccion) {
    this.direccion = direccion;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }


  @Override
  public String toString() {
    return "Persona [id=" + id + ", nombre=" + nombre + ", abc=" + abc + ", direccion=" + direccion
        + ", telefonos=" + telefonos + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Persona other = (Persona) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
