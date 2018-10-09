package com.sebastian.jpa.javase.dominio;

import javax.persistence.Embeddable;

@Embeddable
public class MascotaPatas {
  private int qPatasIzquierdas;
  private int qPatasDerechas;

  public MascotaPatas(int qpi, int qpd) {
    qPatasDerechas = qpd;
    qPatasIzquierdas = qpi;
  }

  public MascotaPatas() {

  }

  /**
   * @return the qPatasIzquierdas
   */
  public int getqPatasIzquierdas() {
    return qPatasIzquierdas;
  }

  /**
   * @param qPatasIzquierdas the qPatasIzquierdas to set
   */
  public void setqPatasIzquierdas(int qPatasIzquierdas) {
    this.qPatasIzquierdas = qPatasIzquierdas;
  }

  /**
   * @return the qPatasDerechas
   */
  public int getqPatasDerechas() {
    return qPatasDerechas;
  }

  /**
   * @param qPatasDerechas the qPatasDerechas to set
   */
  public void setqPatasDerechas(int qPatasDerechas) {
    this.qPatasDerechas = qPatasDerechas;
  }

}
