package com.main_servlet;

import com.json_news_item.Fill_JSON;
import com.json_news_item.JSONContainer;
import com.news_item.FillNews;
import com.news_item.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.xml_parser.XMLParser;
import org.json.*;


public class NewsServlet extends HttpServlet {
//    File file = new File("D:/Tomcat/rss.builder.feedrss.builder.xml");


    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        News news = new News();
        FillNews.addContent(news);
        JSONObject jsonObject = new JSONObject();
        Fill_JSON.addJSON(jsonObject,news);

        PrintWriter out = resp.getWriter();
        JSONContainer.displayJsonObjects(out);

//        SAXParserFactory factory = SAXParserFactory.newInstance();
//
//
//        try {
//            SAXParser parser = factory.newSAXParser();
//            XMLParser xmlParser = new XMLParser();
//            parser.parse(file, xmlParser);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
