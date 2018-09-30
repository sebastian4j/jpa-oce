package com.example.sebastian.demo.sb.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sebastian.demo.sb.jpa.dominio.Persona;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {

}
