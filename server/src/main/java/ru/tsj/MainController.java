package ru.tsj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tsj.bean.HelloService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@Component
public class MainController extends AbstractTemplateController {

    @Autowired
    HelloService helloService;

    @GET
    @Produces("text/plain")
    public String main() {
        return helloService.hello("world");
    }

    @GET
    @Path("tl")
    @Produces("text/html")
    public Response thymeleaf() {
        return ok("hello");
    }

}
