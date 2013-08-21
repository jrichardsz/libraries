/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.component.dragdrop;

import javax.swing.JComponent;

import com.linet.api.swing.listener.move.component.MovementComponentListener;


/**
 *
 * @author RM-RCMJ
 */
public class DragDropComponent {

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }
    
    public void setCoordenadas(int x, int y){
        component.setLocation(x, y);
        setX(x);
        setY(y);
    }
    
    public void setDimension(int width, int height){
        component.setSize(width, height);
        setWidth(width);
        setHeight(height);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MovementComponentListener getListener() {
        return listener;
    }

    public void setListener(MovementComponentListener listener) {
        this.listener = listener;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public int getWidth() {
		return getComponent().getSize().width;
	}

	public void setWidth(int width) {
		getComponent().setSize(width, getWidth());
	}

	public int getHeight() {
		return getComponent().getSize().height;
	}

	public void setHeight(int height) {
		getComponent().setSize(getWidth(), height);
	}



	private JComponent component;
    private MovementComponentListener listener;
    private int x;
    private int y;
    private String id;
    private String style;
    private String text;
    private String name;
    private int type;// 2 outputText 1 inputText 0 commandButton 3 Panelgrid



}
