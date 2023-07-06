package com.MAKAROV.Collections11.Controller;
import com.MAKAROV.Collections11.models.Employee;
import com.MAKAROV.Collections11.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


    @RestController
    @RequestMapping("/employee")
    public class EmployeeController {

        @ExceptionHandler({RuntimeException.class})
        public ResponseEntity<String> handleException(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping(path = "/add")
        public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int id,@RequestParam String fio, @RequestParam int salary, @RequestParam int department) {
            return employeeService.add(firstName, lastName, id , fio ,salary , department);
        }

        @GetMapping(path = "/get")
        public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int id,@RequestParam String fio, @RequestParam int salary, @RequestParam int department) {
            return employeeService.find(firstName, lastName, id , fio ,salary , department);
        }

        @GetMapping(path = "/remove")
        public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int id,@RequestParam String fio, @RequestParam int salary, @RequestParam int department) {
            return employeeService.remove(firstName, lastName, id , fio ,salary , department);
        }

        @GetMapping(path = "/getAll")
        public List<Employee> getEmployees() {
            return employeeService.getAll();
        }
    }
