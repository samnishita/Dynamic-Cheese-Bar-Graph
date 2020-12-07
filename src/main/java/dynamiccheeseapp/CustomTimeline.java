/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import javafx.animation.Timeline;

/**
 *
 * @author samnishita
 */
public class CustomTimeline {

    private Timeline tl;
    private boolean vert;

    public CustomTimeline(Timeline tl, boolean vert) {
        this.tl = tl;
        this.vert = vert;
    }

    public Timeline getTL() {
        return this.tl;
    }

    public boolean getVert() {
        return this.vert;
    }
}
