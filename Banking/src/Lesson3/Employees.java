package Lesson3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Employees {

//  @XmlElementWrapper(name = "employees")
  @XmlElement(name = "employee")
  List<Employee> employees = new ArrayList<>();

  public static class Employee {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private int salary;

    public Employee() {}

    public Employee(int id, String name, int salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public int getSalary() {
      return salary;
    }

  }

  public List<Employee> getEmployees() {
    return employees;
  }
}

