package telran.employees;

import telran.employees.items.HireEmployeeItem;
import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import telran.view.*;

public class EmployeesClientAppl {

    private static final String HOST = "localhost";
    private static final int PORT = 10000;

    public static void main(String[] args) {
        InputOutput inputOutput = new ConsoleInputOutput();
        IEmployees employees = new EmployeesTcpProxy(HOST, PORT);

        Item[] items = {
                new HireEmployeeItem(inputOutput, employees),
                new ExitItem()
        };



        Menu menu = new Menu(items, inputOutput);
        menu.runMenu();
    }
}
