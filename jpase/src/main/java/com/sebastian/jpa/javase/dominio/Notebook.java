package com.sebastian.jpa.javase.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Sebastian Avila A. <sebastian4j at gmail.com>
 */
@Entity
public class Notebook {
    @Id
    private int id;
    private String marca;
    private String modelo;

    public Notebook() {
        
    }
    
    public Notebook(final String marca, final String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Notebook{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
}
