package com.scarit.mapper;

import com.scarit.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> select(Employee employee);

    List<Employee> selectByDid(Employee employee);
}
