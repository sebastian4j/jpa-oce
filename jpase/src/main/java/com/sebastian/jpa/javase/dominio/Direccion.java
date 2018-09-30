package com.sebastian.jpa.javase.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Direccion {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dir_seq_gen")
  @SequenceGenerator(allocationSize = 1, name = "dir_seq_gen", sequenceName = "dir_seq")
  private int id;
  private String ciudad;
  private String comuna;

  public Direccion() {

  }

  public Direccion(int id, String ciudad, String comuna) {
    this.id = id;
    this.ciudad = ciudad;
    this.comuna = comuna;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getComuna() {
    return comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }

  @Override
  public String toString() {
    return "Direccion [id=" + id + ", ciudad=" + ciudad + ", comuna=" + comuna + "]";
  }

}
