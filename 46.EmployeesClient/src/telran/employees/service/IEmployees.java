package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

import java.util.List;

public interface IEmployees {
    boolean hireEmployee (Employee employee) throws Exception;
    boolean fireEmployee (int id) throws Exception;
    Employee getEmployeeData(int id);
    List<Employee> getEmployeesData(int salaryFrom, int salaryTo) throws Exception;
    int getAvgSalary() throws Exception;
    List<CompanySalary> getCompaniesAvgSalary();
    List<CompanySalary> getCompaniesGreaterAvgSalary();
}
