package com.example.sebastian.demo.sb.jpa.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sebastian.demo.sb.jpa.dominio.Persona;
import com.example.sebastian.demo.sb.jpa.service.PersonaService;

@RestController
@RequestMapping("/")
public class PersonaRecursos {
  @Autowired
  // private PersonaRepo pr;
  private PersonaService pr;

  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Persona> listar() {
    return pr.findAll();
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @Transactional
  public List<Persona> nuevo(@RequestBody Persona p) {
    pr.save(p);
    return listar();
  }
}
