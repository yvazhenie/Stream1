package com.MAKAROV.Collections11.Controller;
import com.MAKAROV.Collections11.models.Employee;
import com.MAKAROV.Collections11.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int department) {
        return departmentService.maxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeesByDepartment(@RequestParam(required = false)Integer department ) {
        return departmentService.employeesByDepartment(department);
    }


}
