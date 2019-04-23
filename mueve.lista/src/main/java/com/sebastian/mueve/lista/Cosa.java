package com.sebastian.mueve.lista;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Sebastián Ávila A.
 */
@Entity
@Table(name = "cosa")
public class Cosa {
    @Id
    @GeneratedValue(generator = "cosa_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "cosa_gen", sequenceName = "cosa_seq")
    private int id;
    private String nombre;
    @OneToOne(fetch = FetchType.EAGER)
    private Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Cosa{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
