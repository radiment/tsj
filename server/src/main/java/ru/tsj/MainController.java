package ru.tsj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class MainController {

    @GET
    @Produces("text/plain")
    public String main() {
        return "Hello World";
    }
}
