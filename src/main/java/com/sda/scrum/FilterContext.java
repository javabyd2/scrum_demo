package com.sda.scrum;

public class FilterContext {
    public static String filterSiteContex(String siteContext) {
        String filteredContet = "";
        Boolean markup = false;
        for (int i = 0; i < siteContext.length(); i++) {
            if (!markup) {
                if (siteContext.substring(i, i+1).equals("<")) {
                    markup = true;
                }
            } else {
                if (siteContext.substring(i, i+1).equals(">")) {
                    markup = false;
                }
            }
            if (!markup && !siteContext.substring(i, i+1).equals(">")) {
                filteredContet = filteredContet + siteContext.substring(i, i+1);
            }
        }
        return filteredContet;
    }
}
