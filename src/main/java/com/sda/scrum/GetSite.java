package com.sda.scrum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetSite {

    public static String getSiteContext(String siteAddress) {
        URL url;
        String context = "";

        try {
            url = new URL(siteAddress); //https://pl.lipsum.com/index.html
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader dane = new BufferedReader(in);
            String line;
            while ((line = dane.readLine()) != null) {
                context = context + line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context;
    }
}
