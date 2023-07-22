package prosky.skyspringhomework.service;


import org.springframework.stereotype.Service;
import prosky.skyspringhomework.employee.Employee;
import prosky.skyspringhomework.exception.EmployeeAlreadyAddedException;
import prosky.skyspringhomework.exception.EmployeeNotFoundException;
import prosky.skyspringhomework.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final List<Employee>
        employees = new ArrayList<>(List.of(
                new Employee("Jean", "Reno"),
                new Employee("Gerard", "Depardieu"),
                new Employee("Luc", "Besson"),
                new Employee("Robert", "Patrick"),
                new Employee("Uma", "Thurman"),
                new Employee("Scarlett", "Johansson"),
                new Employee("Gal", "Gadot"),
                new Employee("Christopher", "Pine"),
                new Employee("Morgan", "Freeman")
        ));



    @Override
    public String getEmployee(Integer number) {
        final Employee employee;
        if (number >= employees.size()) {
            throw new EmployeeNotFoundException();
        }
//           if (number <= employees.size()) {
//        throw new EmployeeAlreadyAddedException();
//        }
//        } else  (number >= employees.size()){
//            throw new EmployeeStorageIsFullException();
//
        employee = employees.get(number);
        String employeeDescription = "firstName:"
                + employee.getFirstName()
                + " lastName: "
                + employee.getLastName();
        return employeeDescription;

    }

//    @Override
//    public String addEmployee(Employee employee)
//            throws EmployeeStorageIsFullException {
//        try {
//            addEmployee( employee);
//        } catch (EmployeeStorageIsFullException e) {
//            return "Превышен лимит количества сотрудников";
//        } catch (EmployeeAlreadyAddedException e) {
//            return "Такой сотрудник уже есть";
//        }
//        employees.add(employee);
//        return "Превышен лимит кол-ва сотрудников";
//    }


//    @Override
//    public Collection<Employee> printEmployee(List<Employee> employee) {
//        for (int i = 0; i < employees.size(); i++)
//         employees.size();
//         printEmployee( employees);
//        return printEmployee(employees);
//    }


//    @Override
//    public String removeEmployee(Employee employee)
//            throws EmployeeNotFoundException{
//        try {
//            removeEmployee(employee);
//        } catch (EmployeeNotFoundException e) {
//            return "Сотрудник не найден";
//        }
//        employees.remove(employee);
//        return "Сотрудник не найден!";
//
//    }

//    @Override
//    public String findEmployee(Employee employee)
//            throws EmployeeNotFoundException {
//        try {
//            findEmployee(employee);
//        } catch (EmployeeNotFoundException e) {
//            return "СОТРУДНИК не найден";
//            employees.contains(employee);
//        }
//        return "Сотрудник Не Найден";

//    }

//    @Override
//    public Collection<Employee> printEmployee(int size) {
//        return null;
//    }
//    @Override
//    public Collection<Employee> printEmployee(int size) {
//        return printEmployee(employees);
//    }
}