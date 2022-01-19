package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

public class CompanySalary implements Serializable {
    private String companyName;
    private double avgSalary;

    public CompanySalary() {
    }

    public CompanySalary(String companyName, double avgSalary) {
        this.companyName = companyName;
        this.avgSalary = avgSalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "CompanySalary{" +
                "companyName='" + companyName + '\'' +
                ", avgSalary=" + avgSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanySalary)) return false;
        CompanySalary that = (CompanySalary) o;
        return Double.compare(that.getAvgSalary(), getAvgSalary()) == 0 && Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyName(), getAvgSalary());
    }
}
