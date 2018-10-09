package com.sebastian.jpa.javase.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyTemporal;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.TemporalType;
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

  @ElementCollection
  @CollectionTable(joinColumns = @JoinColumn(name = "TELEFONO_MAP_REF"))
  @MapKeyColumn(name = "TELEFONO_MAP_KEY")
  @Column(name = "FONO")
  @MapKeyEnumerated(EnumType.STRING)
  private Map<TelefonoTipo, String> telefonoMap;

  // una persona podra tener un departamento por piso
  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
  private Map<Integer, Departamento> deptos;

  // una persona tendra muchos notebooks y un notebook lo pueden usar muchos
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "persona_note", joinColumns = @JoinColumn(name = "persona_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id"))
  @MapKeyColumn(name = "fecha_asigna_note") // att_KEY x defecto
  @MapKeyTemporal(TemporalType.TIMESTAMP)
  private Map<Date, Notebook> notebooks;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "padre")
  @MapKey(name = "rut")
  private Map<Integer, Hijo> hijos;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
  private Map<MascotaPatas, Mascota> mascotas;

  public Persona() {
    telefonoMap = new HashMap<>();
  }

  /**
   * @return the mascotas
   */
  public Map<MascotaPatas, Mascota> getMascotas() {
    if (mascotas == null) {
      mascotas = new HashMap<>();
    }
    return mascotas;
  }

  /**
   * @param mascotas the mascotas to set
   */
  public void setMascotas(Map<MascotaPatas, Mascota> mascotas) {
    this.mascotas = mascotas;
  }

  public Map<Integer, Hijo> getHijos() {
    return hijos;
  }

  public void setHijos(Map<Integer, Hijo> hijos) {
    this.hijos = hijos;
  }

  public Map<Integer, Departamento> getDeptos() {
    if (deptos == null) {
      deptos = new HashMap<>();
    }
    return deptos;
  }

  public void setDeptos(Map<Integer, Departamento> deptos) {
    this.deptos = deptos;
  }

  public Map<TelefonoTipo, String> getTelefonoMap() {
    if (telefonoMap == null) {
      telefonoMap = new HashMap<>();
    }
    return telefonoMap;
  }

  public void setTelefonoMap(Map<TelefonoTipo, String> telefonoMap) {
    this.telefonoMap = telefonoMap;
  }

  public Persona(final int id, final String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Map<Date, Notebook> getNotebooks() {
    if (notebooks == null) {
      notebooks = new HashMap<>();
    }
    return notebooks;
  }

  public void setNotebooks(Map<Date, Notebook> notebooks) {
    this.notebooks = notebooks;
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
