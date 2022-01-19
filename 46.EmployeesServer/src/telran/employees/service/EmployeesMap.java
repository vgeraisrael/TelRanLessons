package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesMap implements IEmployees{

    Map<Integer, Employee> employeesById= new HashMap();

    //todo Complete all unimplemented methods

    @Override
    public boolean hireEmployee(Employee employee) {
        return employeesById.putIfAbsent(employee.getId(), employee) == null;
    }

    @Override
    public boolean fireEmployee(int id) {
        return false;
    }

    @Override
    public Employee getEmployeeData(int id) {
        return employeesById.get(id);
    }

    @Override
    public List<Employee> getEmployeesData(int salaryFrom, int salaryTo) {
        return null;
    }

    @Override
    public int getAvgSalary() {
        return 0;
    }

    @Override
    public List<CompanySalary> getCompaniesAvgSalary() {
        return null;
    }

    @Override
    public List<CompanySalary> getCompaniesGreaterAvgSalary() {
        return null;
    }
}
