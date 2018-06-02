package com.sda.scrum;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SaveToFile {
    public static void saveCollectionToFile(String site, ArrayList<String> arrayList){
        SimpleDateFormat df2 = new SimpleDateFormat("yyyymmdd");
        String fileName = df2.format(System.currentTimeMillis()) +"_"+ site;

        PrintWriter save = null;
        try {
            save = new PrintWriter(fileName);
            PrintWriter finalSave = save;
            arrayList.forEach(it -> finalSave.println(it.toString()));
            save.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
