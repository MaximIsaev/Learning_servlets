package com.xml_parser;

import com.news_item.News;
import com.news_item.NewsContainer;
import com.json_news_item.JsonConverter;
import com.news_item.News;
import com.news_item.NewsContainer;
import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser extends DefaultHandler {

    public static void parser(News news) {
        try {
            // получаем xml парсер с настройками по умолчанию
            DocumentBuilder xml = DocumentBuilderFactory.
                    newInstance().newDocumentBuilder();

            // разбираем demo.xml и создаем Document
            Document doc = xml.parse(new File("D:/Tomcat/rss.builder.feedrss.builder.xml"));
            // корневой элемент документа
            Element rootel = doc.getDocumentElement();
            

            // имя корневого элемента
            System.out.println(rootel.getNodeName());

            // список имен дочерних элементов
            System.out.println("Child elements: ");
            NodeList lst = rootel.getChildNodes();
            NodeList itemList;


            for (int i = 0; i < lst.getLength(); i++) {
                System.out.println(lst.item(i).getNodeName());
                NodeList channelNodes = lst.item(i).getChildNodes();
                System.out.println("Channels child elements: " + channelNodes.getLength());
                for (int j = 2; j < channelNodes.getLength(); j++) {
                    System.out.println(channelNodes.item(j).getNodeName() + (j - 1));
                    itemList = channelNodes.item(j).getChildNodes();
                    displayItemChild(itemList);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void displayItemChild(NodeList list) {

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(" " + list.item(i).getNodeName() + ":" + list.item(i).getTextContent());
        }
    }
}


