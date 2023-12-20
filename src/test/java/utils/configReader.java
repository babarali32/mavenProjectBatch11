package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
            static Properties pro;
    public static Properties read(String path){
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            pro =new Properties();
            pro.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;

    }
        public static String getvalue(String key){
        return  pro.getProperty(key);
        }
}