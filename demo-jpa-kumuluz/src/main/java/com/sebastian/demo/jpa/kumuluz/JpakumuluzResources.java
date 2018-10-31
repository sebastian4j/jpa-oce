package com.sebastian.demo.jpa.kumuluz;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sebastian.demo.jpa.kumuluz.dominio.Persona;

/**
 * recursos para la persistencia de personas.
 *
 * @author Sebastian Avila A.
 *
 */
@RequestScoped
@Path("/v1/persona")
public class JpakumuluzResources {
  @Inject
  private PersonaService ps;

  @PostConstruct
  private void init() {
    try {
      final Context ctx = new InitialContext();
      listContext(ctx);
      final DataSource ds = (DataSource) ctx.lookup("jdbc/persona");
      Logger.getLogger(getClass().getName()).info("DS: " + ds);
    } catch (final NamingException e) {
      Logger.getLogger(getClass().getName()).log(Level.WARNING, "error de lookup", e);
    }
  }

  private void listContext(final Context ctx) {
    try {
      final NamingEnumeration<Binding> list = ctx.listBindings("");
      while (list.hasMore()) {
        final Binding item = list.next();
        final String className = item.getClassName();
        final String name = item.getName();
        Logger.getLogger(getClass().getName()).info(className + " " + name);
        final Object o = item.getObject();
        if (o instanceof javax.naming.Context) {
          listContext((Context) o);
        }
      }
    } catch (final NamingException ex) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex, () -> "naming error");
    }
  }


  /**
   * obtiene una persona por su id.
   *
   * @param id identificador de la persona
   * @return la persona si existe
   */
  @GET
  @Path("/obtener/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerPersona(@PathParam(value = "id") final int id) {
    return Response.ok(ps.obtener(id)).build();
  }

  /**
   * crea una nueva persona si no hay error de persistencia.
   *
   * @param p nueva persona que se creará
   * @return
   */
  @POST
  @Path("/crear")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearPersona(final Persona p) {
    Logger.getLogger(getClass().getName()).info(p.toString());
    ps.persistir(p);
    return Response.ok(p).build();
  }

  /**
   * crea una persona pero lanza una unchecked exception para generar un rollback.
   *
   * @param p persona que NO será persistida
   * @return
   */
  @POST
  @Path("/no-crear")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public Response noCrearPersona(final Persona p) {
    Logger.getLogger(getClass().getName()).info(p.toString());
    ps.persistir(p);
    p.setId(p.getId() + 1);
    ps.persistir(p);
    p.setId(p.getId() + 1);
    ps.persistir(p);
    if (p.getId() != p.getId() + 1) {
      throw new RuntimeException();
    }
    return Response.ok(p).build();
  }

  /**
   * lista todas las personas que existen en la base de datos.
   *
   * @return
   */
  @GET
  @Path("/listar")
  @Produces(MediaType.APPLICATION_JSON)
  public Response listarPersonas() {
    return Response.ok(ps.todas()).build();
  }
}
