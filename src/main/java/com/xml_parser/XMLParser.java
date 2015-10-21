package com.xml_parser;

import com.json_news_item.Fill_JSON;
import com.json_news_item.JSONContainer;
import com.news_item.News;
import com.news_item.NewsContainer;
import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class XMLParser extends DefaultHandler {

    private NewsContainer items;
    private News item;
    private boolean inItem = false;
    JSONObject newsJson;


    private StringBuilder content;

    public XMLParser() {
        content = new StringBuilder();
    }


    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

        content = new StringBuilder();
        if (localName.equalsIgnoreCase("item")) {
            inItem = true;
            item = new News();
            newsJson = new JSONObject();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (localName.equalsIgnoreCase("title")) {
            if (inItem) {
                item.setTitle(content.toString());
            }
        } else if (localName.equalsIgnoreCase("description")) {
            if (inItem) {
                item.setDescription(content.toString());
            }
        } else if (localName.equalsIgnoreCase("author")) {
            if (inItem) {
                item.setAuthor(content.toString());
            }
        } else if (localName.equalsIgnoreCase("pubdate")) {
            if (inItem) {
                item.setPubdatee(content.toString());
            }
        } else if (localName.equalsIgnoreCase("item")) {
            inItem = false;
            NewsContainer.setNewsList(item);
            Fill_JSON.addJSON(newsJson, item);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

    @Override
    public void endDocument(){}
}

