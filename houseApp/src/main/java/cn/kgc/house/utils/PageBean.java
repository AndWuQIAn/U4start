package cn.kgc.house.utils;

import java.applet.Applet;
import java.awt.*;

public class PageBean {
    private Integer p=1;
    private Integer pageSize=6;

    public PageBean() {
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

class T1 extends Applet{
    @Override
    public void paint(Graphics g) {
        g.drawString("helloWorld",25,25);
    }

}
