package com.utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.crwu.rcp.training.Activator;
/**
 * @author WuChengRui
 * @date 2018-5-15
 * @desc 文件处理�??
 */
public class FileUtils {
    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytesFromFile(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
    /**
     * 获取文件内的字符�??
     * 
     * @param fileName
     * @return
     */
    public static String getStringFromFile(String fileName) {
        String encoding = "UTF-8";
        return getStringFromFile(fileName, encoding);
    }
    /**
     * 获取文件内的字符�??
     * 
     * @param fileName
     *            文件路径
     * @param encoding
     *            编码
     * @return
     */
    public static String getStringFromFile(String fileName, String encoding) {
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取项目的src的路�??
     * 
     * @return
     */
    public static String getSrcDir() {
        String filePath = "";
        //rcp项目
        if (Activator.getDefault() != null) {
            
            String location = Activator.getDefault().getBundle().getLocation();
            filePath = location.replace("initial@reference:file:", "");
        } 
        //�??般项�??
        else {
            filePath = System.getProperty("user.dir") + File.separatorChar + "";
        }
        return filePath;
    }
   
}

