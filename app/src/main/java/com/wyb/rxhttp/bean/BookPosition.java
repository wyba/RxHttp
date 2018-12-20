package com.wyb.rxhttp.bean;

public class BookPosition {

    private String lib_id;

    private String floor;

    private String area;

    private String columns;

    private String section;

    private String layer;

    private String noodles;

    public String getLib_id() {
        return lib_id;
    }

    public void setLib_id(String lib_id) {
        this.lib_id = lib_id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getNoodles() {
        return noodles;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    @Override
    public String toString() {
        return "BookPosition{" +
                "lib_id='" + lib_id + '\'' +
                ", floor='" + floor + '\'' +
                ", area='" + area + '\'' +
                ", columns='" + columns + '\'' +
                ", section='" + section + '\'' +
                ", layer='" + layer + '\'' +
                ", noodles='" + noodles + '\'' +
                '}';
    }
}
