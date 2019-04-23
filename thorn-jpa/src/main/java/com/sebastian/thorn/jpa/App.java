package com.sebastian.thorn.jpa;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/")
@Path("/")
public class App extends Application {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hola() {
    return "holax";
  }
}
