package com.crwu.training.jface;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-14  
 */
//FileManager.java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
public class FileManager {
  private String fileName;
  private boolean dirty = false;
  private String content;
  public FileManager(){
      
  }
  
  public void load(String name){
      final String textString;
      try{
          File file = new File(name);
          FileInputStream stream = new FileInputStream(file.getPath());
          Reader in = new BufferedReader(new InputStreamReader(stream));
          char[] readBuffer = new char[2048];
          StringBuffer buffer = new StringBuffer((int)file.length());
          int n;
          while((n=in.read(readBuffer))>0){
              buffer.append(readBuffer, 0 ,n);
          }
          textString = buffer.toString();
          stream.close();
      }catch(FileNotFoundException e){
          MainWindow.getApp().getStatusLineManager().setMessage("文件未找到："+fileName);
          return;
      }catch(IOException e){
          MainWindow.getApp().getStatusLineManager().setMessage("读文件出�?: "+fileName);
          return;
      }
      content = textString;
      this.fileName= name;
  }
  
  public void save(String name){
      final String textString = content;
      try{
          File file = new File(name);
          FileOutputStream stream = new FileOutputStream(file.getPath());
          Writer out = new OutputStreamWriter(stream);
          out.write(textString);
          out.flush();
          stream.close();
      }catch(FileNotFoundException e){
          MainWindow.getApp().getStatusLineManager().setMessage("文件未找到："+fileName);
          return;
      }catch(IOException e){
          MainWindow.getApp().getStatusLineManager().setMessage("读文件出�?: "+fileName);
          return;
      }
  }
  
  public String getContent(){
      return content;
  }
  
  public void setContent(String content){
      this.content = content;
  }
  
  public boolean isDirty(){
      return dirty;
  }
  
  public void setDirty(boolean dirty){
      this.dirty = dirty;
  }
  
  public String getFileName(){
      return fileName;
  }
  
  public void setFileName(String fileName){
      this.fileName = fileName;
  }
}

