package com.xzj.jsoup;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
class JsoupApplicationTests {

    @Test
    void jsoup() {
        try {
            Document document = Jsoup.connect("https://xueqiu.com/S/SH603369").get();
            log.info(document.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void link(){
        try {
            Document document = Jsoup.connect("https://xueqiu.com/S/SH603369").get();
            Elements links = document.select("a[href]");
            for (Element link : links)
            {
                log.info("link : " + link.attr("href"));
                log.info("text : " + link.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void image(){
        try {
            Document document = Jsoup.connect("https://www.bilibili.com/").get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images)
            {
                log.info("src : " + image.attr("src"));
                log.info("height : " + image.attr("height"));
                log.info("width : " + image.attr("width"));
                log.info("alt : " + image.attr("alt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
