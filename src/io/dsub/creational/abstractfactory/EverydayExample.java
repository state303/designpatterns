package io.dsub.creational.abstractfactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class EverydayExample {

    public static void main(String[] args) throws Exception {
        String xml = "<document><body><stock>AAPL</stock></body></document>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();

        Document doc = factory.parse(bais);

        doc.getDocumentElement().normalize();
        printAll(doc);

        System.out.println(abstractFactory.getClass());
        System.out.println(factory.getClass());
    }

    private static void printAll(Node node) {
        if (node == null) return;
        System.out.println(node.getNodeName());
        NodeList list = node.getChildNodes();
        int sz = list.getLength();
        for (int i = 0; i < sz; i++) {
            printAll(list.item(i));
        }
    }
}
