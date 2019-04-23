package com.sebastian.mueve.lista;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Sebastián Ávila A.
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(generator = "persona_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "persona_gen", sequenceName = "persona_seq")
    private int id;
    private String nombre;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Cosa> cosas;

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

    public Set<Cosa> getCosas() {
        if (cosas == null) {
            cosas = new HashSet<>();
        }
        return cosas;
    }

    public void setCosas(Set<Cosa> cosas) {
        this.cosas = cosas;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
