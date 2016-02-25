package ru.tsj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tsj.mappers.UnitMapper;
import ru.tsj.services.UnitService;
import ru.tsj.unit.Unit;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.ok;
import static ru.tsj.util.ViewUtil.view;

@Path("/")
@Component
@Consumes("application/json")
public class MainController {

    @Autowired
    UnitService unitService;

    @Autowired
    UnitMapper unitMapper;

    @GET
    @Path("hello")
    @Produces("text/plain")
    public String main() {
        return unitService.hello("world");
    }

    @GET
    @Path("units")
    @Produces("application/json")
    public List<Unit> units() {
        return unitService.getUnits();
    }

    @PUT
    @Path("units")
    public void addUnit(Unit unit) {
        unitMapper.addUnit(unit);
    }

    @GET
    @Produces("text/html")
    public Response thymeleaf() {
        return ok(view("hello", unitMapper.getUnits())).build();
    }

}
