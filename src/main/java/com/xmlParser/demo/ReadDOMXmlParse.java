package com.xmlParser.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadDOMXmlParse {
    public static void main(String [] args) throws ParserConfigurationException, IOException, SAXException {
        File fxmlFile=new File("./src/bank.xml");
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder=dbFactory.newDocumentBuilder();
        Document doc=dbuilder.parse(fxmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element:>"+doc.getDocumentElement().getNodeName());
        NodeList nodeList=doc.getElementsByTagName("client");
        for(int i=0;i<nodeList.getLength();i++)
        {   Node nNode=nodeList.item(i);
            System.out.println(("\nCurrent Element:"+nNode.getNodeName()));
            if(nNode.getNodeType()==Node.ELEMENT_NODE)
            {
                Element element=(Element)nNode;
                System.out.println("Customer Id:"+element.getAttribute("clientID"));
                System.out.println("Customer Name:"+element.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Customer Balance:"+element.getElementsByTagName("balance").item(0).getTextContent());

            }
        }


    }
}
