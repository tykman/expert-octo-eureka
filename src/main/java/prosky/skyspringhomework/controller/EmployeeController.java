package prosky.skyspringhomework.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prosky.skyspringhomework.employee.Employee;
import prosky.skyspringhomework.exception.EmployeeAlreadyAddedException;
import prosky.skyspringhomework.exception.EmployeeNotFoundException;
import prosky.skyspringhomework.exception.EmployeeStorageIsFullException;
import prosky.skyspringhomework.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;

@RestController
public abstract class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private Object List;

    public EmployeeController (EmployeeServiceImpl employeeService) {

        this.employeeService = employeeService;
    }

     @GetMapping(path = "/employee")
    public String getEmployeeInfo(@RequestParam("number")Integer number)
            throws  EmployeeNotFoundException {
        try {
            final String employee = employeeService.getEmployee(number);
            return employee;
        } catch ( EmployeeNotFoundException e) {
            return "Такой сотрудник не найден!";
        } finally {
            System.out.println("Работа метода getEmployeeInfo завершена");
        }
    }
//    @GetMapping(path = "/employee/name")
//    public  Collection<Employee> printEmployee(@RequestParam("firstName")String firstName,
//                                               @RequestParam("lastName")String lastName) {
//           return employeeService.printEmployee( printEmployee(firstName,lastName).size());
//        return  "{ firstName: " + firstName + " -  " + "lastName: " + lastName + "}";
//    }

//    @RequestMapping(path = "/employee/add")
//    public String addEmployee(@RequestParam ("firstName")String firstName,
//                               @RequestParam ("lastName") String lastName)
//           throws EmployeeStorageIsFullException {
//        try {
//            String employee = employeeService.addEmployee(new Employee(firstName,lastName));
//            return employee;
//        } catch (EmployeeStorageIsFullException e ) {
//            return "Превышен лимит количества сотрудников";
//        } catch (EmployeeAlreadyAddedException e)  {
//            return "Такой сотрудник уже есть";
//        } finally {
//            System.out.println("Работа метода addEmployee завершена");;
//        }
//    }

//    @RequestMapping(path = "/employee/remove")
//    private String removeEmployee(@RequestParam("firstName")String firstName,
//                                  @RequestParam("lastName")String lastName)
//              throws EmployeeNotFoundException {
//        try {
//            String employee = employeeService.removeEmployee(new Employee(firstName,lastName));
//            return employee;
//        } catch (EmployeeNotFoundException e) {
//            return "Сотрудник не найден";
//        } finally {
//            System.out.println("Работа метода removeEmployee завершена");
//        }
//    }
//    @RequestMapping(path = "/employee/find")
//    public String findEmployee(@RequestParam("firstName")String firstName,
//                               @RequestParam("lastName")String lastName)
//            throws EmployeeNotFoundException {
//        try {
//            String employee =
//            employeeService.findEmployee(new Employee(firstName,lastName));
//            return employee;
//        } catch (EmployeeNotFoundException e) {
//            return "Employee founded";
//        } finally {
//            System.out.println("Работа метода findEmployee завершена");
//        }
//    }
}
