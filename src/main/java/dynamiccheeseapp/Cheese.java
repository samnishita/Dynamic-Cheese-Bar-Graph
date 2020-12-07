/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author samnishita
 */
public class Cheese {

    private String name;
    private String displayName;
    private Double value;
    private int rank;
    private int rankDiff;
    private Group group;
    private ArrayList<Double> allValues = new ArrayList(50);
    private ArrayList<Integer> allRanks = new ArrayList(50);
    private Image image;
    private ImageView iv;

    private Label numLabel;
    private Rectangle rect;
    private Double rectWidthValue;
    
    private RectangleCheese rectCheese;
    private Double groupYCoord;
    private Double trueInitial;
    private Double correctY;

    public Cheese(String name) throws FileNotFoundException {
        this.name = name;
        this.value = 0.00;
        this.rank = 0;
        this.group = null;
        this.numLabel = null;
        this.rect = null;
        File file = null;
        this.groupYCoord=0.00;
        this.trueInitial=0.00;
        this.correctY=0.00;
        
        
        switch (name) {
            case "cheddar":
                this.displayName = "Cheddar";
                file = new File("src/main/resources/cheeseimages/cheddar.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "mozzarella":
                this.displayName = "Mozzarella";
                file = new File("src/main/resources/cheeseimages/mozzarella.png");
                this.image = new Image(file.toURI().toString());

                break;

            case "swiss":
                this.displayName = "Swiss";
                file = new File("src/main/resources/cheeseimages/swisscheese.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "blue":
                this.displayName = "Blue";
                file = new File("src/main/resources/cheeseimages/bluecheese.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "creamneufchatel":
                this.displayName = "Cream Cheese";
                file = new File("src/main/resources/cheeseimages/creamcheese.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "muenster":
                this.displayName = "Muenster";
                file = new File("src/main/resources/cheeseimages/muenster.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "jack":
                this.displayName = "Jack";
                file = new File("src/main/resources/cheeseimages/jackcheese.png");
                this.image = new Image(file.toURI().toString());
                break;

            case "processedcheese":
                this.displayName = "Processed";
                file = new File("src/main/resources/cheeseimages/processedcheese.png");
                this.image = new Image(file.toURI().toString());
                break;

        }
    }

    public String getName() {
        return this.name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String name) {
        this.displayName = name;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public int getRank() {
        return this.rank;
    }

    public int getRankDiff() {
        return this.rankDiff;
    }

    public void setRankDiff(int i) {
        this.rankDiff = i;
    }

    public void resetRankDiff() {
        this.rankDiff = 0;
    }

    @FXML
    public void setGroup(Group group) {
        this.group = group;
    }

    @FXML
    public Group getGroup() {
        return this.group;
    }

    public ArrayList<Double> getAllValues() {
        return this.allValues;
    }

    public Double getYearlyValue(int year) {
        return this.allValues.get(year - 1970);
    }

    public ArrayList<Integer> getAllRanks() {
        return this.allRanks;
    }

    public Integer getYearlyRank(int year) {
        return this.allRanks.get(year - 1970);
    }

    public void setNumLabel(Label label) {
        this.numLabel = label;
    }

    public Label getNumLabel() {
        return this.numLabel;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImageView(ImageView iv) {
        this.iv = iv;
    }

    public ImageView getImageView() {
        return this.iv;
    }
    
    public void setRectWidthValue(double width){
        this.rectWidthValue=width;
    }
    
    public double getRectWidthValue(){
        return this.rectWidthValue;
    }
    
    public void setRectangleCheese(RectangleCheese rectCheese){
        this.rectCheese=rectCheese;
    }
    
    public RectangleCheese getRectangleCheese(){
        return this.rectCheese;
    }
    public void setGroupYCoord(double y){
        this.groupYCoord=y;
    }
    
    public double getGroupYCoord(){
        return this.groupYCoord;
    }
    
     public void setTrueInitial(double ti){
        this.trueInitial=ti;
    }
    
    public double getTrueInitial(){
        return this.trueInitial;
    }
    public void setCorrectY(double cy){
        this.correctY=cy;
    }
    
    public double getCorrectY(){
        return this.correctY;
    }
}

