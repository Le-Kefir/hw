package Lesson3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class ObjectToXml {

  public static void main(String[] args) throws JAXBException, FileNotFoundException {
    JAXBContext contextObj = JAXBContext.newInstance(Employees.class);

    Marshaller marshallerObj = contextObj.createMarshaller();
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    Employees employees = new Employees();
    employees.getEmployees().add(new Employees.Employee(1, "Darkhan", 2000));
    employees.getEmployees().add(new Employees.Employee(2, "Dastan", 4000));

    marshallerObj.marshal(employees, new FileOutputStream("emp.xml"));

//    employees.add(emp);
//    employees.add(emp2);
//
//    marshallerObj.marshal(employees, new FileOutputStream("emp.xml"));
  }

}
