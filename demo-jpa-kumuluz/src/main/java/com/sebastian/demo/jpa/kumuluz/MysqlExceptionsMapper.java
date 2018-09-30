package com.sebastian.demo.jpa.kumuluz;

import javax.transaction.RollbackException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MysqlExceptionsMapper implements ExceptionMapper<RollbackException> {
  @Override
  public Response toResponse(final RollbackException e) {
    return Response.status(Response.Status.CONFLICT).type(MediaType.TEXT_PLAIN)
        .entity("Identificador de registro duplicado ").build();
  }
}
