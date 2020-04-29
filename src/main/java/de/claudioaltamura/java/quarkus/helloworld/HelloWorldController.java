package de.claudioaltamura.java.quarkus.helloworld;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@ApplicationScoped
public class HelloWorldController {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello world!";
  }
}
