package com.imtf.siron.supporttool.exception.mapper;

import com.imtf.siron.supporttool.exception.InvalidPathException;
import com.imtf.siron.supporttool.exception.SecurityException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {


    @Override
    public Response toResponse(Exception exception) {

        if (exception instanceof SecurityException) {
            return Response.status(Response.Status.FORBIDDEN)
                    .build();
        } else if (exception instanceof InvalidPathException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }

        return Response.status(Response.Status.BAD_REQUEST)
                .build();
    }
}
