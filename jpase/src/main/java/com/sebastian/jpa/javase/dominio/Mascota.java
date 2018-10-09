package com.sebastian.jpa.javase.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Mascota {
  @Id
  @GeneratedValue(generator = "mas_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(allocationSize = 1, name = "mas_gen", sequenceName = "mas_seq")
  private int id;
  @Embedded
  private MascotaPatas patas;
  @ManyToOne
  private Persona persona;

  public Mascota() {

  }

  public Mascota(MascotaPatas mp) {
    this.patas = mp;
  }

  /**
   * @return the persona
   */
  public Persona getPersona() {
    return persona;
  }

  /**
   * @param persona the persona to set
   */
  public void setPersona(Persona persona) {
    this.persona = persona;
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
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the patas
   */
  public MascotaPatas getPatas() {
    return patas;
  }

  /**
   * @param patas the patas to set
   */
  public void setPatas(MascotaPatas patas) {
    this.patas = patas;
  }

}
