package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

import java.util.List;

public interface IEmployees {
    boolean hireEmployee (Employee employee);
    boolean fireEmployee (int id);
    Employee getEmployeeData(int id);
    List<Employee> getEmployeesData(int salaryFrom, int salaryTo);
    int getAvgSalary();
    List<CompanySalary> getCompaniesAvgSalary();
    List<CompanySalary> getCompaniesGreaterAvgSalary();
}
