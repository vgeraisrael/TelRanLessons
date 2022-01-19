package telran.employees.net;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.net.RequestJava;
import telran.net.ResponceJava;
import telran.net.TCPResponseCode;
import telran.net.server.ProtocolJava;

import java.io.Serializable;

public class EmployeesTCPProtocol implements ProtocolJava {
    IEmployees employees;

    public EmployeesTCPProtocol(IEmployees employees) {
        this.employees = employees;
    }

    @Override
    public ResponceJava getResponce(RequestJava requestJava) {
        Serializable requestData = requestJava.requestData;
        switch (requestJava.requestType) {
            case "hireEmployee" :
                return hireEmployee(requestData);

            case "fireEmployee" :
                return fireEmployee(requestData);

                //todo Prepare all known requests

            default :
                return new ResponceJava(TCPResponseCode.UNKNOWN, null);
        }
    }

    private ResponceJava fireEmployee(Serializable requestData) {
        try {
            int id = (Integer) requestData;
            boolean res = employees.fireEmployee(id);
            return new ResponceJava(TCPResponseCode.OK, res);
        } catch (Exception e) {
            return new ResponceJava(TCPResponseCode.WRONG_REQUEST, e.getMessage());
        }
    }

    private ResponceJava hireEmployee(Serializable requestData) {
        try {
            Employee employee = (Employee) requestData;
            boolean res = employees.hireEmployee(employee);
            return new ResponceJava(TCPResponseCode.OK, res);
        } catch (Exception e) {
            return new ResponceJava(TCPResponseCode.WRONG_REQUEST, e.getMessage());
        }
    }
}
