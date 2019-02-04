package classes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class CurParser {

  public static double convert(String curCode, double amount, String targetCode) throws IOException, SAXException, ParserConfigurationException {
//        File file = new File(String.valueOf(fileName));
    URL fileName = new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fileName.openStream());
    doc.getDocumentElement().normalize();

    double from = 0;
    double to = 0;

    NodeList currencies = doc.getElementsByTagName("Cube");

    for (int i = 0; i < currencies.getLength(); i++) {
      Node nCur = currencies.item(i);

      if (nCur.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) nCur;
        if (element.getAttribute("currency").equals(curCode)) {
//                    System.out.println(element.getAttribute("rate"));
          from = Double.parseDouble(element.getAttribute("rate"));
        } else if (element.getAttribute("currency").equals(targetCode)) {
//                    System.out.println(element.getAttribute("rate"));
          to = Double.parseDouble(element.getAttribute("rate"));
        } else if (curCode.equals("EUR")) {
          from = 1;
        } else if (targetCode.equals("EUR")) {
          to = 1;
        }
      }
    }
    double result = 0;
    if (from != 0 && to != 0) {
       result = amount / from * to;
//      System.out.println(result);
    } else if (from == 1) {
       result = amount * to;
//      System.out.println(result);
    } else if (to == 1) {
      result = amount / from;
//      System.out.println(result);
    }
    return result;
  }

}
