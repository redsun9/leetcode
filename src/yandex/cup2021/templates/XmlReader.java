package yandex.cup2021.templates;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, SAXException {
        String file = "src/yandex/cup2021/templates/customer.xml";
        List<Customer> customers = parseEmployeesXML(file);
        customers.forEach(c -> {
            System.out.println(c.getId());
            System.out.println(c.getName());
            System.out.println(c.getAge());
            System.out.println();
        });
    }


    private static List<Customer> parseEmployeesXML(String file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(file));
        document.getDocumentElement().normalize();

        List<Customer> employees = new ArrayList<Customer>();
        Customer customer = null;
        NodeList nList = document.getElementsByTagName("customer");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                //Create new Employee Object
                customer = new Customer();
                customer.setId(Integer.parseInt(eElement.getAttribute("id")));
                customer.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                customer.setAge(Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent()));
                employees.add(customer);
            }
        }
        return employees;
    }

    @XmlRootElement
    public static class Customer {
        String name;
        int age;
        int id;

        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @XmlElement
        public void setAge(int age) {
            this.age = age;
        }

        public int getId() {
            return id;
        }

        @XmlAttribute
        public void setId(int id) {
            this.id = id;
        }
    }
}
