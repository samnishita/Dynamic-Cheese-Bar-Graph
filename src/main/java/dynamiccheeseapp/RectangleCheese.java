/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author samnishita
 */
public class RectangleCheese extends Rectangle{

    private Rectangle rectangle;
    private double width;

    public RectangleCheese(Rectangle rect, double width) {
        this.rectangle=rect;
        this.width=width;
    }
    
    public void setRectangle(Rectangle rect){
        this.rectangle=rect;
    }
    
    public Rectangle getRectangle(){
        return this.rectangle;
    }
    
    public void setRectWidth(double width){
        this.width=width;
    }
    
    public double getRectWidthValue(){
        return this.width;
    }
}
