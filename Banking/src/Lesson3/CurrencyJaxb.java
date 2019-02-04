package Lesson3;

import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class CurrencyJaxb {
  private static final String XML_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

  public static void main(String[] args) throws Exception {
    URL url = new URL(XML_URL);
    InputStream is = url.openStream();
    JAXBContext context = JAXBContext.newInstance(Envelope.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    Envelope e = (Envelope) unmarshaller.unmarshal(is);

    for (Envelope.Currency c : e.getCube().getCube().getCurrencies()) {
      System.out.println("currency " + c.getCurrency() + " rate: " + c.getRate());
    }
  }

}
