package DOM;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlParser {
    public static void main(String[] args) {
        try {
            // Read user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user-id of the Student");
            String userId = scanner.next();

            // Parse XML file
            File inputFile = new File("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            // Get student nodes
            NodeList students = document.getElementsByTagName("student");

            // Find student by user-id
            boolean studentFound = false;
            for (int i = 0; i < students.getLength(); i++) {
                Node node = students.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element student = (Element) node;
                    String currentUserId = student.getElementsByTagName("userid").item(0).getTextContent();
                    if (currentUserId.equals(userId)) {
                        printStudentInfo(student);
                        studentFound = true;
                        break;
                    }
                }
            }

            // Handle student not found
            if (!studentFound) {
                System.out.println("The given user-id " + userId + " is not present in XML Document");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printStudentInfo(Element student) {
        System.out.println("Student roll no : " + student.getElementsByTagName("userid").item(0).getTextContent());
        System.out.println("Student Name : " + student.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Student Gender : " + student.getElementsByTagName("gender").item(0).getTextContent());
        System.out.println("Marks : " + student.getElementsByTagName("marks").item(0).getTextContent());
    }
}