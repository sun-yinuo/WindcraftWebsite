package com.sunyinuo.windcraftbackend.utils.ip;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 获取用户ip
 * @author sunyinuo
 */
public class GetIp {

    /**
     * 获取ip
     * @return ip
     */
    public static String getClientIp(){
        Document document = null;
        try {
            document = Jsoup.connect("https://2022.ip138.com/").get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assert document != null;
        return document.selectXpath("/html/body/p[1]/a[1]").get(0).text();
    }
}
