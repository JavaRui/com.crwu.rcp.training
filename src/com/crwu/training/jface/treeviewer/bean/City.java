package com.crwu.training.jface.treeviewer.bean;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import com.crwu.common.img.ImageFoctory;
import com.crwu.training.jface.treeviewer.provider.ITreeFace;
public class City implements ITreeFace {
	private int id;
    private String name;
    private List children = new ArrayList();
    public City(){
    }
    public City(String name){
        this.name = name;
    }
    public List getChildren() {
        return children;
    }
    public void setChildren(List children) {
        this.children = children;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Image getImg() {
        
        return ImageFoctory.getImgByRoot("icons/back.gif");
    }
    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", children=" + children + "]";
    }
}

