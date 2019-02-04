package Lesson3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PeopleToXml {

  public static void main(String[] args) throws JAXBException, FileNotFoundException {

    JAXBContext context = JAXBContext.newInstance(People.class);

    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    People people = new People();
    people.getPeople().add(new People.Person(1, "Darkhan", "Bailov", 2000, new People.Person.Work(1, "Astana", 200)));
    people.getPeople().add(new People.Person(2, "Dastan", "Bailov", 5000, new People.Person.Work(2, "Almaty", 500)));

    marshaller.marshal(people, new FileOutputStream("people.xml"));

  }

}
