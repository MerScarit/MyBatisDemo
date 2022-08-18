package com.scarit.mapper;

import com.scarit.entity.Dept;

import java.util.List;

public interface DeptMapper {

    List<Dept> select(Dept dept);

    List<Dept> selectAll(Dept dept);

    List<Dept> select2(Dept dept);
}
