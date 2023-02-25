package me.angelfire.rpcard.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void createfile(File file) throws IOException{
    	if(file != null && !file.exists()) {
    		file.getParentFile().mkdir();
    		file.createNewFile();
    	}
    }

    public static void save(File file, String content) {


    	final FileWriter fw;
        try {
        	createfile(file);

            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String loadContent(File file) {
        if (file != null && file.exists()) {
        try {
        	final BufferedReader reader = new BufferedReader(new FileReader(file));
        	final StringBuilder sb = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        return "";
    }
}

