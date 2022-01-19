package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class HireEmployeeItem extends EmployeesItem{

    private static final Integer MIN_SALARY = 5400;
    private static final Integer MAX_SALARY = 120_000;

    public HireEmployeeItem(InputOutput inputOutput, IEmployees employees) {
        super(inputOutput, employees);
    }

    @Override
    public String displayName() {
        return "Hire employee";
    }

    @Override
    public void perforn() throws Exception {

        Integer id = getNonExistingID();

        String company = inputOutput.inputString("Enter company name");
        if(company == null) {
            return;
        }

        String name= inputOutput.inputString("Enter name");
        if(name == null) {
            return;
        }

        Integer salary = inputOutput.inputInteger(String.format("Enter salary in range[%d - %d]",
                MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
        if(salary == null) {
            return;
        }

        Employee emp = new Employee(id, company, name, salary);
        inputOutput.outputLine(employees.hireEmployee(emp));

    }


}
