package Lesson3;

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.gesmes.org/xml/2002-08-01", name = "Envelope")
public class Envelope {

  @XmlElement(namespace = "http://www.gesmes.org/xml/2002-08-01", name = "subject")
  private String subject;

  public static class Sender {
    @XmlElement(namespace = "http://www.gesmes.org/xml/2002-08-01", name = "name")
    private String name;
  }

  @XmlElement(namespace = "http://www.gesmes.org/xml/2002-08-01", name = "Sender")
  private Sender sender;

  public static class Currency {
    @XmlAttribute(name = "currency")
    private String currency;

    @XmlAttribute(name = "rate")
    private Double rate;

    public String getCurrency() {
      return currency;
    }



    public Double getRate() {
      return rate;
    }

  }

  public static class OuterCube {
    @XmlElement(namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", name = "Cube")
    private Cube cube;

    public Cube getCube() {
      return cube;
    }

  }

  public static class Cube {
    @XmlAttribute(name = "time")
    private String time;

    @XmlElement(namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", name = "Cube")
    private Collection<Currency> currencies = new LinkedList<>();

    public Collection<Currency> getCurrencies() {
      return currencies;
    }


  }

  @XmlElement(namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", required = true, nillable = false, name = "Cube")
  private OuterCube cube;

  public OuterCube getCube() {
    return this.cube;
  }
}
