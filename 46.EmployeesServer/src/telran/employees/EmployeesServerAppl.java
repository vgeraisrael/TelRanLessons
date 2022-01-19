package telran.employees;

import telran.employees.net.EmployeesTCPProtocol;
import telran.employees.service.EmployeesMap;
import telran.employees.service.IEmployees;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;

import java.io.IOException;

public class EmployeesServerAppl {
    public static final int PORT = 10000;
    public static void main(String[] args) throws IOException {

        IEmployees employees = new EmployeesMap();
        ProtocolJava protocol = new EmployeesTCPProtocol(employees);

        ServerJava server = new ServerJava(protocol, PORT);

        server.run();
    }
}
