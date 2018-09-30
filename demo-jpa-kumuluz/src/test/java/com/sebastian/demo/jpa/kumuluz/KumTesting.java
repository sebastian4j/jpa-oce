package com.sebastian.demo.jpa.kumuluz;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.sebastian.demo.jpa.kumuluz.dominio.Persona;

@RunWith(Arquillian.class)
public class KumTesting {
  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class).addPackage(PersonaService.class.getPackage())
        .addPackage(Persona.class.getPackage()).addAsResource("config.yaml", "config.yaml")
        .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Inject
  private PersonaService ps;

  @Inject
  private JpakumuluzResources a;

  @Test
  public void injectTest() {
    Assert.assertNotNull(ps);
    Assert.assertTrue(ps.todas().isEmpty());
    Persona p = new Persona();
    p.setId(ThreadLocalRandom.current().nextInt());
    p.setNombre(UUID.randomUUID().toString());
    a.crearPersona(p);
    Assert.assertEquals(1, ps.todas().size());
  }
}
