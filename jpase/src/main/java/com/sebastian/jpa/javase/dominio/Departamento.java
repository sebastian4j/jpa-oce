package com.sebastian.jpa.javase.dominio;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Departamento {
  @Id
  @GeneratedValue(generator = "dep_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "dep_gen", sequenceName = "dep_seq", allocationSize = 1)
  private int numero;
  @Enumerated(EnumType.STRING)
  private OrientacionGeografica og;
  @ManyToOne
  private Persona persona;

  public Departamento() {

  }

  public Departamento(OrientacionGeografica og, Persona persona) {
    this.og = og;
    this.persona = persona;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public OrientacionGeografica getOg() {
    return og;
  }

  public void setOg(OrientacionGeografica og) {
    this.og = og;
  }
}
