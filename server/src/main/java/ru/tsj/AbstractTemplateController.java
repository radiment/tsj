package ru.tsj;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.core.Response;

public class AbstractTemplateController {

    protected Response ok(String template) {
        return Response.ok(new Viewable(template)).build();
    }
}
