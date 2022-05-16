package com.example.lab11.controller;

import com.example.lab11.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/test")
    public String test() {
        return "Testing the API";
    }
    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Person> readEmployees() {
        //return getPersons();
        return Collections.emptyList();
    }

    @RequestMapping(value="/employees", method= RequestMethod.POST)
    public Person createEmployee(@RequestBody Person p) {
        //return createPerson(emp);
        return p;
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public Person readEmployees(@PathVariable(value = "pId") Long id, @RequestBody Person p) {
        //return updateEmployee(id, pDetails);
        return p;
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empServ.deleteEmployee(id);
    }

}
