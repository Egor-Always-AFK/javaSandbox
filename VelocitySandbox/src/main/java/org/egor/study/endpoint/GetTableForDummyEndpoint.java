package org.egor.study.endpoint;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.io.VelocityWriter;
import org.egor.study.model.UserRq;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.io.StringWriter;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_HTML;

@Path("v1/service/getTableForDummy")
public class GetTableForDummyEndpoint {

    VelocityEngine velocityEngine;

    @Autowired
    public GetTableForDummyEndpoint(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
        this.velocityEngine.init();
    }

    @Autowired
    public GetTableForDummyEndpoint() {
        this.velocityEngine = new VelocityEngine();
        this.velocityEngine.init();
    }
    @Path("html")
    @Produces(TEXT_HTML)
    @Consumes(APPLICATION_JSON)
    @GET
    public Response explainHTML(@BeanParam UserRq request) {
        Template template = velocityEngine.getTemplate("resources.table-velocity-template.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("data", request);

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        return Response.ok(template).build();
    }

}
