package Lesson3;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToObject {
  public static void main(String[] args) {
    try {
      File file = new File("emp.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Employees employees = (Employees) jaxbUnmarshaller.unmarshal(file);
      for (Employees.Employee e : employees.getEmployees()) {
        System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
      }

//      Employee e=(Employee) jaxbUnmarshaller.unmarshal(file);
//      System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());

    } catch (JAXBException e) {e.printStackTrace(); }

  }
}