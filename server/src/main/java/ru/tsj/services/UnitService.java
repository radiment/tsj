package ru.tsj.services;

import org.springframework.stereotype.Component;
import ru.tsj.unit.Unit;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitService {

    public String hello(String name) {
        return "Hello " + name;
    }

    public List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        Unit unit = new Unit();
        unit.setName("ТСЖ Академия");
        unit.setCode("academy");
        unit.setLogo("academy.png");
        unit.setTelephone("+72122454");
        units.add(unit);
        unit = new Unit();
        unit.setName("ТСЖ Киров");
        unit.setCode("kirov");
        unit.setLogo("kirov.png");
        unit.setTelephone("+822454");
        units.add(unit);
        return units;
    }
}
