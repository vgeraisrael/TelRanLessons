package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class EmployeesItem implements Item {
    protected InputOutput inputOutput;
    protected IEmployees employees;

    public EmployeesItem(InputOutput inputOutput, IEmployees employees) {
        this.inputOutput = inputOutput;
        this.employees = employees;
    }

    public Integer getNonExistingID() {
        Integer id = inputOutput.inputInteger("Enter ID");
        if(id == null) {
            return null;
        }

        Employee emp = employees.getEmployeeData(id);
        if(emp != null) {
            inputOutput.outputLine("Employee already exists");
            return null;
        }

        return id;
    }
}
