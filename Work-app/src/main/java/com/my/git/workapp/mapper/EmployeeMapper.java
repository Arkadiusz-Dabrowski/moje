package com.my.git.workapp.mapper;

import com.my.git.workapp.dto.EmployeeDto;
import com.my.git.workapp.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(target = "id", source = "employee_id" ),
            @Mapping(target ="firstName" , source = "firstName"),
            @Mapping(target = "secondName", source ="secondName" ),
            @Mapping(target ="email" , source ="email" ),
            @Mapping(target = "phoneNumber", source = "phoneNumber" ),

    })
    EmployeeDto employeeDto(Employee employee);
    List<EmployeeDto> employeeDto(Collection<Employee> employees);
    Employee toEmployeeEntity(EmployeeDto employeeDto);
}
