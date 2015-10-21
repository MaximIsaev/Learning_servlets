package com.json_news_item;

import org.json.JSONObject;
import com.news_item.News;

public class Fill_JSON {
    public static void addJSON(JSONObject rec, News nrec) {

        rec.put("ID", nrec.getId());
        rec.put("Title", nrec.getTitle());
        rec.put("Description", nrec.getDescription());
        rec.put("Author", nrec.getAuthor());
        rec.put("PubDate", nrec.getPubdate());
        JSONContainer.setJsonNewsList(rec);

    }
}
