package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: seba
 * Date: 9/6/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Element {

    private char type;
    private Vector<Integer> position;
    private List<Element> neighbours = new ArrayList<Element>();
    private Element parent;


    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public List<Element> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Element> neighbours) {
        this.neighbours = neighbours;
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public Vector<Integer> getPosition() {
        return position;
    }

    public void setPosition(Vector<Integer> position) {
        this.position = position;
    }
}
