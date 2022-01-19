package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private int id;
    private String company;
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String company, String name, int salary) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getSalary() == employee.getSalary() && Objects.equals(getCompany(), employee.getCompany()) && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompany(), getName(), getSalary());
    }
}
