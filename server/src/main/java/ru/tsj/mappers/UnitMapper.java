package ru.tsj.mappers;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.tsj.unit.Unit;

import java.util.List;

public interface UnitMapper {

    @Select("SELECT * FROM TSJ")
    List<Unit> getUnits();

    @Update("INSERT INTO TSJ (NAME, CODE, LOGO, TELEPHONE) VALUES (#{name}, #{code}, #{logo}, #{telephone})")
    void addUnit(Unit unit);
}
