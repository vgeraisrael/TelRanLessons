package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.net.TCPClientJava;

import java.util.List;

public class EmployeesTcpProxy extends TCPClientJava implements IEmployees{


    public EmployeesTcpProxy(String hostName, int port) {
        super(hostName, port);
    }

    @Override
    public boolean hireEmployee(Employee employee) throws Exception {
        return sendRequest("hireEmployee", employee);
    }

    @Override
    public boolean fireEmployee(int id) throws Exception {
        return sendRequest("fireEmployee", id);
    }

    @Override
    public Employee getEmployeeData(int id) {
        return null;
    }

    @Override
    public List<Employee> getEmployeesData(int salaryFrom, int salaryTo) throws Exception {
        Integer[] data = {salaryFrom, salaryTo};
        return sendRequest("getEmployeesData", data);
    }

    @Override
    public int getAvgSalary() throws Exception {
        return sendRequest("getAverageSalary", null);
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
