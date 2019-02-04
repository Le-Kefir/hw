package Lesson3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class People {

  private List<Person> people = new ArrayList<>();

//  @XmlElementWrapper
  @XmlElement(name = "person")
  public List<Person> getPeople() {
    return people;
  }

  public void setPeople(List<Person> people) {
    this.people = people;
  }

  public static class Person {

    public Person() {}

    public Person(int id, String name, String surname, int salary, Work work) {
      this.id = id;
      this.name = name;
      this.surname = surname;
      this.salry = salary;
      this.work = work;
    }

    private int id;
    private String name;
    private String surname;
    private int salry;
    private Work work;

    @XmlAttribute
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @XmlAttribute
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @XmlAttribute
    public String getSurname() {
      return surname;
    }

    public void setSurname(String surname) {
      this.surname = surname;
    }

    @XmlAttribute
    public int getSalry() {
      return salry;
    }

    public void setSalry(int salry) {
      this.salry = salry;
    }

    @XmlElement(name = "work")
    public Work getWorks() {
      return work;
    }

    public void setWorks(Work works) {
      this.work = works;
    }

    public static class Work {

      public Work() {}

      public Work(int id, String address, int capacity) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
      }

      private int id;
      private String address;
      private int capacity;

      @XmlAttribute
      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      @XmlAttribute
      public String getAddress() {
        return address;
      }

      public void setAddress(String address) {
        this.address = address;
      }

      @XmlAttribute
      public int getCapacity() {
        return capacity;
      }

      public void setCapacity(int capacity) {
        this.capacity = capacity;
      }
    }
  }
}
