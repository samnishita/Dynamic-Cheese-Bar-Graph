/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author samnishita
 */
public class CheeseFXMLController implements Initializable {

//ADD FXML FEATURES
    @FXML
    private Label name1;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label name6;
    @FXML
    private Label name7;
    @FXML
    private Label name8;

    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Rectangle rect5;
    @FXML
    private Rectangle rect6;
    @FXML
    private Rectangle rect7;
    @FXML
    private Rectangle rect8;

    @FXML
    private Label num1;
    @FXML
    private Label num2;
    @FXML
    private Label num3;
    @FXML
    private Label num4;
    @FXML
    private Label num5;
    @FXML
    private Label num6;
    @FXML
    private Label num7;
    @FXML
    private Label num8;

    @FXML
    private Group group1;
    @FXML
    private Group group2;
    @FXML
    private Group group3;
    @FXML
    private Group group4;
    @FXML
    private Group group5;
    @FXML
    private Group group6;
    @FXML
    private Group group7;
    @FXML
    private Group group8;

    @FXML
    private Label yearLabel;
    @FXML
    private Label caveat;

    @FXML
    private ImageView iv1;
    @FXML
    private ImageView iv2;
    @FXML
    private ImageView iv3;
    @FXML
    private ImageView iv4;
    @FXML
    private ImageView iv5;
    @FXML
    private ImageView iv6;
    @FXML
    private ImageView iv7;
    @FXML
    private ImageView iv8;

    @FXML
    private ImageView cow;
    @FXML
    private ImageView cowbub;
    @FXML
    private Group cowgroup;
    @FXML
    private Label cowtext;

    @FXML
    private Group LG1;
    @FXML
    private Group LG2;
    @FXML
    private Group LG3;
    @FXML
    private Group LG4;
    @FXML
    private Group LG5;
    @FXML
    private Group LG6;

    @FXML
    private Group LG1S;
    @FXML
    private Group LG2S;
    @FXML
    private Group LG3S;
    @FXML
    private Group LG4S;
    @FXML
    private Group LG5S;
    @FXML
    private Group LG6S;

    @FXML
    private Label LL1;
    @FXML
    private Label LL2;
    @FXML
    private Label LL3;
    @FXML
    private Label LL4;
    @FXML
    private Label LL5;
    @FXML
    private Label LL6;

    @FXML
    private Label LL1S;
    @FXML
    private Label LL2S;
    @FXML
    private Label LL3S;
    @FXML
    private Label LL4S;
    @FXML
    private Label LL5S;
    @FXML
    private Label LL6S;

    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private Line line6;

    @FXML
    private Line line1S;
    @FXML
    private Line line2S;
    @FXML
    private Line line3S;
    @FXML
    private Line line4S;
    @FXML
    private Line line5S;
    @FXML
    private Line line6S;

    //FOR RANKED CHEESES EVERY YEAR
    private HashMap<Integer, ArrayList<Cheese>> cheeseData;

    //GROUP FXML OBJECTS INTO LISTS
    private final int groupsShown = 8;
    private final ArrayList<Label> names = new ArrayList(groupsShown);
    private final ArrayList<Rectangle> rects = new ArrayList(groupsShown);
    private final ArrayList<Label> nums = new ArrayList(groupsShown);
    private final ArrayList<Group> groups = new ArrayList(groupsShown);
    private final ArrayList<ImageView> ivs = new ArrayList(groupsShown);

    //GROUP FXML SCALE OBJECTS INTO LISTS
    private final ArrayList<Group> lgs = new ArrayList(6);
    private final ArrayList<Label> lls = new ArrayList(6);
    private final ArrayList<Line> lines = new ArrayList(6);
    private final ArrayList<Group> lgsS = new ArrayList(6);
    private final ArrayList<Label> llsS = new ArrayList(6);
    private final ArrayList<Line> linesS = new ArrayList(6);

    //LIST OF ALL ANIMATIONS
    private final ArrayList<Timeline> timelines = new ArrayList(1501);

    //ALL Y VALUES OF VARIOUS RANKS
    private final int rank1Y = 150;
    private final int rank2Y = rank1Y + 60;
    private final int rank3Y = rank2Y + 60;
    private final int rank4Y = rank3Y + 60;
    private final int rank5Y = rank4Y + 60;
    private final int rank6Y = rank5Y + 60;
    private final int rank7Y = rank6Y + 60;
    private final int rank8Y = rank7Y + 60;

    //DECIMAL FORMAT FOR NUMBER LABEL
    private final static DecimalFormat df2 = new DecimalFormat("#0.00");

    //HOW MANY SCALE LINES ARE VISIBLE
    private int linesVis = 0;

    //SET HOW FAST ANIMATIONS WILL PLAY
    private final int totalIterationTime = 500;
    private final int iterations = 30;
    private final int vertIterations = 6;

    
    private final double scaleOpac = 0.95;

    private ArrayList<RectangleCheese> rectcheeses = new ArrayList();

    private int customIter = 0;

    private ArrayList<Cheese> runningCheeses = new ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //IMPORT IMAGE FILES AND SET IMAGEVIEWS
        File fileCow = new File("src/main/resources/COW.png");
        Image cowIm = new Image(fileCow.toURI().toString());
        this.cow.setImage(cowIm);
        File fileBub = new File("src/main/resources/dialogue.png");
        Image bubIm = new Image(fileBub.toURI().toString());
        this.cowbub.setImage(bubIm);
        //SET HOW TO BEGIN THE RUN
        this.cow.setOnMouseClicked((e) -> {
            startRunCow();
        });
        //ADD ALL FXML ITEMS INTO LISTS FOR EASE OF USE
        makeLists();
        //MAKE CAVEAT LABEL INVISIBLE
        this.caveat.setVisible(false);
        //MAKE ALL SCALES INVISIBLE TO BEGIN
        for (int i = 0; i < 6; i++) {
            this.lgs.get(i).setOpacity(0.00);
            this.lgsS.get(i).setOpacity(0.00);
        }
        //GET ALL CHEESES RANKED FOR ALL YEARS
        CheeseModel model = new CheeseModel();
        try {
            model.importCheeseData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //INITIALIZE DATA STRUCTURE FOR FUTURE USE
        this.cheeseData = model.getHashMap();
        //INITIALIZE FIRST VISUAL
        preset(model);
        //USE TO FOLLOW FUTURE RECTANGLE GROWTH FOR CREATING ANIMATIONS
        presetRectangleValues();
        //PRELOAD ALL TIMELINE DATA
        makeTimelines();

    }

    //START RUN WHEN CLICK ON COW IMAGE
    @FXML
    private void startRunCow() {

        
        this.cowtext.setText("Bye!");
        //MAKE COW GROUP INVISIBLE
        this.cowgroup.setVisible(false);

        //RECURSIVE CALL TO PLAY TIMELINES ONE AFTER ANOTHER
        int i = 0;
        recTrans(this.timelines, i);//, true

        //PLAY FIRST TIMELINE
        this.timelines.get(0).play();
    }

    //INITIALIZE THE MODEL AT YEAR ONE BEFORE STARTING THE FULL RUN
    @FXML
    public void preset(CheeseModel model) {
        Integer firstYear = 1970;
        this.yearLabel.setText(firstYear + "");
        ArrayList<Cheese> cheeseArray = this.cheeseData.get(firstYear);
        //FOR EACH GROUP
        for (int i = 0; i < this.groupsShown; i++) {
            //THE FIRST RECTANGLE IS ALREADY SET TO 450
            if (i != 0) {
                this.rects.get(i).setWidth(450 * cheeseArray.get(i).getYearlyValue(firstYear) / cheeseArray.get(0).getYearlyValue(firstYear));
                cheeseArray.get(i).setRectangleCheese(new RectangleCheese(this.rects.get(i), 450 * cheeseArray.get(i).getYearlyValue(firstYear) / cheeseArray.get(0).getYearlyValue(firstYear)));
            } else {
                cheeseArray.get(i).setRectangleCheese(new RectangleCheese(this.rects.get(i), 450));
            }

            //SET CHEESE NAME 
            this.names.get(i).setText(cheeseArray.get(i).getDisplayName());
            //SET NUMBER LABEL TEXT
            this.nums.get(i).setText(cheeseArray.get(i).getYearlyValue(firstYear) + "");
            //SET NUMBER LABEL LOCATION
            this.nums.get(i).setLayoutX(this.rects.get(i).getLayoutX() + this.rects.get(i).getWidth() + 25);
            //SET CHEESE IMAGEVIEW
            this.ivs.get(i).setImage(cheeseArray.get(i).getImage());
            //ASSIGN CHEESE A GROUP
            cheeseArray.get(i).setGroup(this.groups.get(i));
            //ASSIGN CHEESE A NUMBER LABEL
            cheeseArray.get(i).setNumLabel(this.nums.get(i));
            //ASSIGN CHEESE A RECTANGLE
            cheeseArray.get(i).setRect(this.rects.get(i));
            //ASSIGN CHEESE AN IMAGEVIEW
            cheeseArray.get(i).setImageView(this.ivs.get(i));

            cheeseArray.get(i).setGroupYCoord(determineYCoord(cheeseArray.get(i).getYearlyRank(firstYear)));
//            System.out.println(cheeseArray.get(i).getDisplayName() + ": " + cheeseArray.get(i).getGroupYCoord());
            cheeseArray.get(i).setTrueInitial(cheeseArray.get(i).getGroupYCoord());
        }
        //SET SCALES
        presetScaleGroups(firstYear);

    }

    //MAKE THE TIMELINES BEFORE ANIMATIONS PLAY
    @FXML
    private void makeTimelines() {
        //PRESET SCALE LINE LABELS
        makeLineLabels();
        //DEFINE WHICH SCALE GROUP TO USE
        ArrayList<Group> scaleGroups = this.lgs;
        ArrayList<Line> scaleLines = this.lines;
        ArrayList<Label> scaleLabels = this.lls;
        boolean first = true;
        boolean switched = false;
        for (Cheese each : this.cheeseData.get(1970)) {
            this.runningCheeses.add(each);
        }

        //EACH YEAR FROM 1971-2019
        for (int yearInt = 1971; yearInt < 2019; yearInt++) {
//            System.out.println("YEAR: " + yearInt);
            int currentIterations = this.iterations;
            //this.customIter = 0;
            boolean finalize = false;

            for (Cheese each : this.cheeseData.get(yearInt)) {
                each.setCorrectY(determineYCoord(each.getYearlyRank(yearInt)));
//                System.out.println(each.getDisplayName() + " correctY: " + each.getCorrectY());
            }

            //SWITCH SCALES IF NEEDED
            if (first && this.cheeseData.get(yearInt).get(0).getYearlyValue(yearInt) > 7) {
                scaleGroups = this.lgsS;
                scaleLines = this.linesS;
                scaleLabels = this.llsS;

                presetScaleGroups(yearInt);
                first = false;
                switched = true;
            }

            //CREATE LISTS OF RANKED CHEESES TO COMPARE
            ArrayList<Cheese> cheesePrevYear = this.cheeseData.get(yearInt - 1);
            ArrayList<Cheese> cheeseCurYear = this.cheeseData.get(yearInt);
            //SET THE CHEESE'S RANK DIFFERENCE IF NONZERO
            for (Cheese each : cheesePrevYear) {
                //IF RANKDIFF<0 THEN THE CHEESE MOVES UP IN RANK
                int rankDiff = each.getYearlyRank(yearInt) - each.getYearlyRank(yearInt - 1);
                each.setRankDiff(rankDiff);
            }
            //INSTANTIATE YEAR TIMELINE
            Timeline tlYear = new Timeline();

            //ADD YEAR TEXT TRANSITION
            KeyValue kvYear = new KeyValue(this.yearLabel.textProperty(), yearInt + "");
            KeyFrame kfYear = new KeyFrame(Duration.millis(1), kvYear);
            tlYear.getKeyFrames().add(kfYear);

            //IT'S QUICK SO ADD IT HERE
            this.timelines.add(tlYear);

            //INSTANTIATE THE CAVEAT POPUP
            Timeline tlCaveat = new Timeline();
            //IF THE CAVEAT ISN'T VISIBLE THEN MAKE IT VISIBLE AFTER 1998
            if (yearInt >= 1998 && yearInt <= 2009 && !this.caveat.isVisible()) {
                KeyValue kvCaveat = new KeyValue(this.caveat.visibleProperty(), true);
                KeyFrame kfCaveat = new KeyFrame(Duration.millis(1), kvCaveat);
                tlCaveat.getKeyFrames().add(kfCaveat);
                this.timelines.add(tlCaveat);
            }

            //
            int index = 0;

            //IF CHEESE CHANGES RANKS THEN ADD IT TO A NEW LIST
            ArrayList<Cheese> cheesesWithRankDiff = new ArrayList();
            for (Cheese each : cheeseCurYear) {
                if (each.getRankDiff() != 0) {
                    cheesesWithRankDiff.add(each);
                }
            }

            //FOR EACH ITERATION
            for (int i = 1; i < this.iterations + 1; i++) {
//                System.out.println("    iteration: " + i);
                //INSTANTIATE TIMELINE
                Timeline timelineGen = new Timeline();

                //IF IT'S TIME TO CHANGE THE SCALES
                if (yearInt == 1981 && i < 7) {
                    this.linesVis = 0;
                    fadeOutScales(timelineGen, yearInt);
                    fadeInScales(timelineGen, yearInt);
                    presetScaleGroups(yearInt);
                    switched = true;
                }

                //CHANGE SCALE MULTIPLIER BASED ON YEAR
                int multiplier = 1;
                if (switched) {
                    multiplier = 2;
                }

                //MAKE NEW SCALE LINES VISIBLE IF NEEDED
                //CONDITIONS OF FEWER THAN SIX LINES; NOT VISIBLE; MAX CHEESE VALUE IS GREATER THAN (THE SCALE NUMBER PLUS A LITTLE EXTRA AS A BUFFER)
                if (this.linesVis < 6 && scaleGroups.get(this.linesVis).opacityProperty().get() == 0.00 && this.cheeseData.get(yearInt).get(0).getYearlyValue(yearInt) > (this.linesVis + 1 + multiplier / 3) * multiplier) {
                    KeyValue kvlg = new KeyValue(scaleGroups.get(this.linesVis).opacityProperty(), this.scaleOpac);
                    KeyFrame kflg = new KeyFrame(Duration.millis(1), kvlg);
                    timelineGen.getKeyFrames().add(kflg);
                    this.linesVis++;
                }

                //REMOVE EXTRA SCALE LINES IF NECESSARY
                if (this.cheeseData.get(yearInt).get(0).getYearlyValue(yearInt) < (this.linesVis) * multiplier) {
                    KeyValue kvlg = new KeyValue(scaleGroups.get(this.linesVis - 1).opacityProperty(), 0.00);
                    KeyFrame kflg = new KeyFrame(Duration.millis(100), kvlg);
                    timelineGen.getKeyFrames().add(kflg);
                    this.linesVis--;
                }

                //FOR EACH OF THE 8 CHEESES NO MATTER WHAT
                for (index = 0; index < 8; index++) {
                    //CHANGE RECTANGLE WIDTH
                    timelineGen.getKeyFrames().add(createRectangleKeys(i, index, yearInt));
                    //CHANGE NUMBER
                    timelineGen.getKeyFrames().add(createNumberKeys(i, index, yearInt));
                    //CHANGE NUMBER LABEL LOCATION
                    timelineGen.getKeyFrames().add(createNumberMovementKeys(i, index, yearInt));
                    //MOVE SCALE GROUPS IF VISIBLE
                    if (index < this.linesVis) {
                        timelineGen.getKeyFrames().add(createScaleMovementKeys(yearInt, index, i, scaleGroups, multiplier));
                    }
                }

                //FOR EACH CHEESE WITH A RANK DIFFERENCE
//                for (Cheese each : cheesesWithRankDiff) {
//                    //KeyFrame kfRankDiff = createGroupVertMovementKeys(each, yearInt, i);
//                    timelineGen.getKeyFrames().add(createGroupVertMovementKeys(each, yearInt, i));
//                }
                //FOR EACH CHEESE WITH A RANK DIFFERENCE
                //ANALYZE TWO CHEESES AT A TIME
//                if (i < this.vertIterations) {
//
//                    for (int j = 0; j < cheesesWithRankDiff.size() - 1; j = j + 2) {
//                        //FOR FIRST ITERATION SET THE ORIGINAL Y VALUE OF EACH CHEESE
//                        if (i == 1) {
//                            for (Cheese each : cheesesWithRankDiff) {
//                                each.setTrueInitial(each.getGroupYCoord());
//                                System.out.println("here ti: "+ each.getTrueInitial());
//                            }
//                        }
//
//                        //CHEESES PUT INTO ARRAY BASED ON CURRENT YEAR
//                        //IN THEORY THE TRANSITION ALREADY HAPPENED
//                        //SO IF THE CURRENT YEAR VALUE OF THE FIRST CHEESE IN THE ARRAY IS LESS THAN THE VALUE OF THE SECOND CHEESE
//                        //THEN THE TRANSITION SHOULD HAPPEN
//                        if (cheesesWithRankDiff.get(j + 1).getRectangleCheese().getRectWidthValue() < cheesesWithRankDiff.get(j).getRectangleCheese().getRectWidthValue()) {
////                        KeyFrame kfRankDiff = createGroupVertMovementKeys(cheesesWithRankDiff.get(j + 1), yearInt, i);
////                        KeyFrame kfRankDiff2 = createGroupVertMovementKeys(cheesesWithRankDiff.get(j), yearInt, i);
//                            finalize = true;
//
////                        System.out.println(yearInt + ": " + cheesesWithRankDiff.get(j).getDisplayName() + " " + cheesesWithRankDiff.get(j).getRectangleCheese().getRectWidthValue());
////                        System.out.println(yearInt + ": " + cheesesWithRankDiff.get(j + 1).getDisplayName() + " " + cheesesWithRankDiff.get(j + 1).getRectangleCheese().getRectWidthValue());
////                        System.out.println(currentIterations);
//                            System.out.println(cheesesWithRankDiff.get(j + 1).getDisplayName());
//                            timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheesesWithRankDiff.get(j + 1), yearInt-1));
//                            System.out.println(cheesesWithRankDiff.get(j).getDisplayName());
//                            timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheesesWithRankDiff.get(j), yearInt-1));
//                        }
//                    }
//                }
                ArrayList<Cheese> cheeses = this.cheeseData.get(yearInt);

                ArrayList<Cheese> tempCheeses = new ArrayList();

                for (int j = 0; j < 7; j++) {

                    Cheese cheese1 = this.runningCheeses.get(j);
                    Cheese cheese2 = this.runningCheeses.get(j + 1);
                    double correctY1 = determineYCoord(cheese1.getYearlyRank(yearInt));
                    double currentY1 = cheese1.getGroupYCoord();
                    double correctY2 = determineYCoord(cheese2.getYearlyRank(yearInt));
                    double currentY2 = cheese2.getGroupYCoord();
                    double rectW1 = cheese1.getRectangleCheese().getRectWidthValue();
                    double rectW2 = cheese2.getRectangleCheese().getRectWidthValue();
                    //IF BOTH CHEESES ARE NOT AT THE RIGHT Y VALUES
                    if (correctY1 != currentY1 && correctY2 != currentY2) {

//                        System.out.println("        " + cheese1.getDisplayName() + ": " + correctY1 + " != " + currentY1);
//                        System.out.println("        " + cheese2.getDisplayName() + ": " + correctY2 + " != " + currentY2);
                        //IF THE ABOVE CHEESE SHOULD BE MOVING DOWN
                        if (correctY1 < correctY2) {
//                            System.out.println("            " + cheese1.getDisplayName() + ": " + currentY1);
//                            System.out.println("            " + cheese2.getDisplayName() + ": " + currentY2);
                            //IF THE FALLING CHEESE RECT WIDTH IS LESS THAN THE RISING CHEESE RECT WIDTH
                            if (rectW1 > rectW2) {
//                                System.out.println("                " + cheese1.getDisplayName() + ": " + rectW1);
//                                System.out.println("                " + cheese2.getDisplayName() + ": " + rectW2);
//                                createGroupVertMovementKeys(cheese1, yearInt);
//                                createGroupVertMovementKeys(cheese1, yearInt);
                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese1, yearInt));
                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese2, yearInt));
//                                System.out.println("");
                            } else {
//                                System.out.println("                NOT ENTERED");
//                                System.out.println("                " + cheese1.getDisplayName() + ": " + rectW1);
//                                System.out.println("                " + cheese2.getDisplayName() + ": " + rectW2);
                            }

                        } else {//IF CORRECTY1 > CORRECTY2
                            if (yearInt == 2004) {
//                                System.out.println("                " + cheese1.getDisplayName() + ": " + rectW1);
//                                System.out.println("                " + cheese2.getDisplayName() + ": " + rectW2);
                            }
                            if (currentY1 < correctY1 && currentY1 > correctY2) {
//                                System.out.println("                " + cheese1.getDisplayName() + ": " + rectW1);
//                                System.out.println("                " + cheese2.getDisplayName() + ": " + rectW2);
//                                createGroupVertMovementKeys(cheese1, yearInt);
//                                createGroupVertMovementKeys(cheese1, yearInt);
//                                System.out.println("                entered");
                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese1, yearInt));
                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese2, yearInt));
//                                System.out.println("");
                            }
//                            timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese1, yearInt));
//                            timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheese2, yearInt));
                        }

                    }

                }

                for (int a = 0; a < 7; a++) {
                    if (this.runningCheeses.get(a).getRectangleCheese().getRectWidthValue() - this.runningCheeses.get(a + 1).getRectangleCheese().getRectWidthValue() < -0.01) {
                        tempCheeses.add(this.runningCheeses.get(a + 1));
                        tempCheeses.add(this.runningCheeses.get(a));
                        a = a + 1;
                    } else {
                        tempCheeses.add(this.runningCheeses.get(a));
                    }
                    if (a == 6) {
                        tempCheeses.add(this.runningCheeses.get(a + 1));
                    }
                }
                this.runningCheeses = tempCheeses;

                //boolean atCorrectY = true;
//                for (Cheese each : this.runningCheeses) {
////                    System.out.println("    " + each.getDisplayName() + " current Y Coord: " + each.getGroupYCoord());
//                    if (each.getGroupYCoord() != each.getCorrectY()) {
//                        System.out.println(each.getDisplayName());
//                        System.out.println(each.getGroupYCoord() +" != "+ each.getCorrectY());
//                        for (int n = 0; n < 7; n++) {
//                            System.out.println("            " + cheeses.get(n).getDisplayName() + " rect width: " + cheeses.get(n).getRectangleCheese().getRectWidthValue());
//                            //System.out.println("            " + this.runningCheeses.get(n + 1).getDisplayName() + " rect width: " + this.runningCheeses.get(n + 1).getRectangleCheese().getRectWidthValue());
//
//                            if (cheeses.get(n).getRectangleCheese().getRectWidthValue() -cheeses.get(n + 1).getRectangleCheese().getRectWidthValue()<0.1) {
////                                System.out.println("            " + this.runningCheeses.get(n).getDisplayName() + " rect width: " + this.runningCheeses.get(n).getRectangleCheese().getRectWidthValue());
////                                System.out.println("            " + this.runningCheeses.get(n + 1).getDisplayName() + " rect width: " + this.runningCheeses.get(n + 1).getRectangleCheese().getRectWidthValue());
//                                System.out.println("entered2");
//                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheeses.get(n + 1), yearInt));
//                                timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheeses.get(n), yearInt));
//                            }
//                        }
//                    }
//                }
//                for (int n = 0; n < 7; n++) {
//                    if (cheeses.get(n).getRectangleCheese().getRectWidthValue() < cheeses.get(n + 1).getRectangleCheese().getRectWidthValue()) {
//                        timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheeses.get(n + 1), yearInt - 1));
//                        timelineGen.getKeyFrames().add(createGroupVertMovementKeys(cheeses.get(n), yearInt - 1));
//                    }
//                }
                //ADD TIMELINE TO TIMELINE LIST
                this.timelines.add(timelineGen);
                if (!finalize) {
                    currentIterations--;
                }

            }
            //System.out.println("END YEAR");
        }
    }

    //RECURSIVE CALL TO PLAY EACH TRANSITION AFTER THE PREVIOUS ONE FINISHES
    @FXML
    public void recTrans(ArrayList<Timeline> list, int i
    ) { //, boolean first
        if (i + 1 < this.timelines.size()) {
            Timeline tl1 = this.timelines.get(i);
            Timeline tl2 = this.timelines.get(i + 1);

            tl1.setOnFinished(e -> tl2.play());
            recTrans(this.timelines, i + 1);//, false
        }

    }

    //TIMELINES WITH VERTICAL MOVEMENT WILL HAVE BOOLEAN TRUE
    @FXML
    public void recTransCustom(ArrayList<CustomTimeline> ctArray, int i
    ) { //, boolean first
        if (i + 1 < ctArray.size()) {
            Timeline tl1 = ctArray.get(i).getTL();
            Timeline tl2 = ctArray.get(i + 1).getTL();
            Timeline tl3 = ctArray.get(i + 2).getTL();
            boolean vert1 = ctArray.get(i).getVert();
            boolean vert2 = ctArray.get(i + 1).getVert();
            boolean vert3 = ctArray.get(i + 2).getVert();
            //IF VERTMOVE IS PRECEDED BY A DELAY TIMELINE (BOOLEAN TRUE)\

            //neither one or two or three needs to move
            if (!vert1 && !vert2 && !vert3) {
                tl1.setOnFinished(e -> tl2.play());

                //one and two dont move but three does
            } else if (!vert1 && !vert2 && vert3) {
                tl1.setOnFinished(e -> tl2.play());
                //tl1.setOnFinished(e -> tl3.play());
            } else if (vert1 && !vert2) {
                i = i + 2;
                while (ctArray.get(i).getVert()) {
                    i++;
                }
                tl3 = ctArray.get(i).getTL();
                //tl2.setOnFinished(e -> tl3.play());
                final Timeline tlf = tl3;
                tl2.setOnFinished(e -> tlf.play());
                recTransCustom(ctArray, i);
            } else if (!vert1 && vert2 && vert3) {

            } else if (vert1 && vert2) {
                tl1.setOnFinished(e -> tl2.play());
            }
//            final Timeline tlf= tl3;
//            if (vert1 && !vert2){
//                tl2.setOnFinished(e -> tlf.play());
//            }
//IF BOTH TL1 AND TL2 ARE NOT VERTMOVE
            ////tl1.setOnFinished(e -> tl2.play());
            //IF TL1 IS VERTMOVE AND TL2 IS NOT VERTMOVE
            //DO NOT WANT NEXT ANIMATION TO START ONCE TL1 FINISHES
            ////DEAL WITH BEFORE METHOD CALL
            //IF TL1 IS NOT VERTMOVE AND TL2 IS VERTMOVE
            //DO NOT WANT TL2 TO PLAY AFTER TL1 FINISHES
            ////!!!! tl1.setOnFinished(e -> SOMETHING.play());
            //IF BOTH TL1 AND TL2 ARE VERTMOVE
            //SHOULD HAPPEN WHEN CALLED BUT NOT ANYTHING ELSE
            //ADD TIMELINE THAT STALLS FOR X AMOUNT OF TIME THEN THE VERTMOVE TRANSITION
            //THAT GOES FOR 1-X TIME
            //tl1.setOnFinished(e -> tl2.play());
            {
                recTrans(this.timelines, i + 1);//, false
            }
        }

    }
    //CHOOSE WHAT Y COORDINATE A MOVING GROUP WILL MOVE TO 

    public int determineYCoord(int rank) {
        switch (rank) {
            case 1:
                return this.rank1Y;
            case 2:
                return this.rank2Y;
            case 3:
                return this.rank3Y;
            case 4:
                return this.rank4Y;
            case 5:
                return this.rank5Y;
            case 6:
                return this.rank6Y;
            case 7:
                return this.rank7Y;
            case 8:
                return this.rank8Y;
        }
        return 0;
    }

//    public KeyFrame createNumberKeys(int curIter, int index, int yearCur) {
//        Cheese cheese = this.cheeseData.get(yearCur).get(index);
//        double inc = (cheese.getYearlyValue(yearCur) - cheese.getYearlyValue(yearCur - 1)) / this.iterations;
//        double initial = cheese.getYearlyValue(yearCur - 1);
//        double moveAmt = Math.round((inc * curIter) * 100.0) / 100.0;
//        double sum = Math.round((initial + moveAmt) * 100.0) / 100.0;
//        Label num = cheese.getNumLabel();
//        int iterationTime = this.totalIterationTime / this.iterations;
//        String visible = sum + "";;
//        if (cheese.getYearlyValue(yearCur) == 0.00) {
//            visible = "N/A*";
//            iterationTime = 1;
//        } else if (cheese.getYearlyValue(yearCur) > 0.00 && cheese.getYearlyValue(yearCur - 1) == 0.00) {
//            iterationTime = 1;
//            visible = cheese.getYearlyValue(yearCur) + "";
//        } else {
//        }
//        KeyValue kvnum = new KeyValue(num.textProperty(), visible);
//        KeyFrame kfnum = new KeyFrame(Duration.millis(iterationTime), kvnum);
//        return kfnum;
//    }
    public KeyFrame createNumberKeys(int curIter, int index, int yearCur) {
        Cheese cheese = this.cheeseData.get(yearCur).get(index);
        double inc = (cheese.getYearlyValue(yearCur) - cheese.getYearlyValue(yearCur - 1)) / this.iterations;
        double initial = cheese.getYearlyValue(yearCur - 1);
        double moveAmt = Math.round((inc * curIter) * 100.0) / 100.0;
        double sum = Math.round((initial + moveAmt) * 100.0) / 100.0;
        Label num = cheese.getNumLabel();
        int iterationTime = this.totalIterationTime / this.iterations;
        String visible = sum + "";;
        if (cheese.getYearlyValue(yearCur) == 0.00) {
            visible = "N/A*";
            iterationTime = 1;
        } else if (cheese.getYearlyValue(yearCur) > 0.00 && cheese.getYearlyValue(yearCur - 1) == 0.00) {
            iterationTime = 1;
            visible = cheese.getYearlyValue(yearCur) + "";
        } else {
        }
        KeyValue kvnum = new KeyValue(num.textProperty(), visible);
        KeyFrame kfnum = new KeyFrame(Duration.millis(iterationTime), kvnum);
        return kfnum;
    }

    public KeyFrame createRectangleKeys(int curIter, int index, int yearCur) {
        Cheese cheese = this.cheeseData.get(yearCur).get(index);
        double inc = 0;
        double initial = 0;
        //moving up in rank (negative Y direction)
        //B
        if (cheese.getYearlyRank(yearCur) == 1 && cheese.getYearlyRank(yearCur - 1) == 2) {
            inc = (450 - 450 * (cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1))) / iterations;
            //initial = 450 * cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1);
            initial = cheese.getRectangleCheese().getRectWidthValue();

//moving down in rank (positive Y direction)
//A
        } else if (cheese.getYearlyRank(yearCur) == 2 && cheese.getYearlyRank(yearCur - 1) == 1) {
            inc = (450 * (cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur).get(0).getYearlyValue(yearCur)) - 450) / iterations;
            //initial = 450;
            initial = cheese.getRectangleCheese().getRectWidthValue();
            //C
        } else if (cheese.getYearlyValue(yearCur) == 0.00) {

        } else if (cheese.getYearlyValue(yearCur - 1) == 0.00 && cheese.getYearlyValue(yearCur) > 0.00) {
            //initial = 450 * cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur).get(0).getYearlyValue(yearCur);
            initial = 450 * this.runningCheeses.get(7).getYearlyValue(yearCur) / this.runningCheeses.get(0).getYearlyValue(yearCur);
        } else {
            inc = ((cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur).get(0).getYearlyValue(yearCur)) - (cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1))) / iterations * 450;
            //initial = 450 * cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1);
            initial = cheese.getRectangleCheese().getRectWidthValue();
        }

        //double moveAmt = inc * curIter;
        //double sum = initial + moveAmt;
        double sum = initial + inc;
        cheese.getRectangleCheese().setRectWidth(sum);
        int iterationTime = this.totalIterationTime / this.iterations;
        Rectangle rect = cheese.getRect();
        KeyValue kvrect = new KeyValue(rect.widthProperty(), sum);
        KeyFrame kfrect = new KeyFrame(Duration.millis(iterationTime), kvrect);
        return kfrect;
    }

    public KeyFrame createNumberMovementKeys(int curIter, int index, int yearCur) {
        Cheese cheese = this.cheeseData.get(yearCur).get(index);
        Rectangle rect = cheese.getRect();
        Label num = cheese.getNumLabel();
        double inc = 0.0;
        double initial = 0.0;
        //moving up in rank (negative Y direction)
        if (cheese.getYearlyRank(yearCur) == 1 && cheese.getYearlyRank(yearCur - 1) == 2) {
            inc = (750 - 450 * (cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1)) - 300) / iterations;
            initial = 275 + 450 * cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1) + 25;
//           
            //moving down in rank (positive Y direction)
        } else if (cheese.getYearlyRank(yearCur) == 2 && cheese.getYearlyRank(yearCur - 1) == 1) {
            inc = (450 * (cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur).get(0).getYearlyValue(yearCur)) + 300 - 750) / iterations;
            initial = 750;
        } else if (cheese.getYearlyValue(yearCur) == 0.00) {
            initial = 300;
        } else if (cheese.getYearlyValue(yearCur) > 0.00 && cheese.getYearlyValue(yearCur - 1) == 0.00) {
            initial = 450 * cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1) + 300;

        } else {
            inc = ((cheese.getYearlyValue(yearCur) / this.cheeseData.get(yearCur).get(0).getYearlyValue(yearCur)) - (cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1))) / iterations * 450;
            initial = 450 * cheese.getYearlyValue(yearCur - 1) / this.cheeseData.get(yearCur - 1).get(0).getYearlyValue(yearCur - 1) + 300;
        }
        int iterationTime = this.totalIterationTime / this.iterations;

        double moveAmt = inc * curIter;
        double sum = initial + moveAmt;
        KeyValue kvnum = new KeyValue(num.layoutXProperty(), sum);
        KeyFrame kfnum = new KeyFrame(Duration.millis(iterationTime), kvnum);
        return kfnum;
    }

    public KeyFrame createGroupVertMovementKeys(Cheese cheese, int year) {

        Group group = cheese.getGroup();
        //double yVal = 90 + (cheese.getYearlyRank(year - 1) * 60);
//        System.out.println("trueinitial: " + cheese.getTrueInitial());
//        double initial = cheese.getGroupYCoord();
//        System.out.println("initial:" + initial);
//        double yValTarget = determineYCoord(cheese.getYearlyRank(year));
//        System.out.println("target: " + yValTarget);
//        double inc = (yValTarget - cheese.getTrueInitial()) / this.vertIterations;
//        System.out.println("inc: " + inc);
//        double incTarget = initial + inc;
//        System.out.println("incTarget: " + incTarget);
//        cheese.setGroupYCoord(incTarget);
//        double iterationTime = (this.vertIterationTime / this.vertIterations);//* origIterationsLeft

        double initial = cheese.getGroupYCoord();
        double yValTarget = determineYCoord(cheese.getYearlyRank(year));
        int multiplier = 0;
        if (yValTarget - initial > 0) {
            multiplier = 1;
        } else {
            multiplier = -1;
        }
        double newMove = initial + (multiplier * 60 / this.vertIterations);
        cheese.setGroupYCoord(newMove);
        KeyValue kv = new KeyValue(group.layoutYProperty(), newMove);
        KeyFrame kf = new KeyFrame(Duration.millis(1), kv);
        return kf;

    }

    public KeyFrame createScaleMovementKeys(int yearCur, int index, int curIter, ArrayList<Group> scaleGroups, int multiplier) {
        Group group = scaleGroups.get(index);
        Cheese cheese = this.cheeseData.get(yearCur).get(0);
        Cheese cheesePrev = this.cheeseData.get(yearCur - 1).get(0);
        double goal = (index + 1) * multiplier * 450 / cheese.getYearlyValue(yearCur) + 275;
        double initial = (index + 1) * multiplier * 450 / cheesePrev.getYearlyValue(yearCur - 1) + 275;
        double inc = (goal - initial) / this.iterations;
        double moveAmt = initial + (inc * curIter);
        double iterationTime = this.totalIterationTime / this.iterations;
        KeyValue kv = new KeyValue(group.layoutXProperty(), moveAmt);
        KeyFrame kf = new KeyFrame(Duration.millis(iterationTime), kv);
        return kf;
    }

    @FXML
    public void makeSmaller() {
        this.cow.setFitHeight(this.cow.getFitHeight() - 20);
        this.cow.setX(this.cow.getX() + 10);
        this.cow.setY(this.cow.getY() + 10);
    }

    @FXML
    public void makeLarger() {
        this.cow.setFitHeight(125);
        this.cow.setX(0);
        this.cow.setY(0);
    }

    @FXML
    public void fadeOutScales(Timeline tl, int year) {
        for (int i = 0; i < 6; i++) {
            Group group = this.lgs.get(i);
            KeyValue kv = new KeyValue(group.opacityProperty(), 0.00);
            KeyFrame kf = new KeyFrame(Duration.millis(10), kv);
            tl.getKeyFrames().add(kf);
        }
    }

    @FXML
    public void fadeInScales(Timeline tl, int year) {
        int value = 2;
        int index = 0;
        while (value < this.cheeseData.get(year).get(0).getYearlyValue(year) && index < 6) {

            Group group = this.lgsS.get(index);
            KeyValue kv = new KeyValue(group.opacityProperty(), this.scaleOpac);
            KeyFrame kf = new KeyFrame(Duration.millis(50), kv);
            tl.getKeyFrames().add(kf);
            value = value + 2;
            index++;
            this.linesVis++;
        }
    }
    //adding features into lists now makes it easier in the future

    public void makeLists() {

        this.names.add(name1);
        this.names.add(name2);
        this.names.add(name3);
        this.names.add(name4);
        this.names.add(name5);
        this.names.add(name6);
        this.names.add(name7);
        this.names.add(name8);

        this.rects.add(rect1);
        this.rects.add(rect2);
        this.rects.add(rect3);
        this.rects.add(rect4);
        this.rects.add(rect5);
        this.rects.add(rect6);
        this.rects.add(rect7);
        this.rects.add(rect8);

        this.nums.add(num1);
        this.nums.add(num2);
        this.nums.add(num3);
        this.nums.add(num4);
        this.nums.add(num5);
        this.nums.add(num6);
        this.nums.add(num7);
        this.nums.add(num8);

        this.groups.add(group1);
        this.groups.add(group2);
        this.groups.add(group3);
        this.groups.add(group4);
        this.groups.add(group5);
        this.groups.add(group6);
        this.groups.add(group7);
        this.groups.add(group8);

        this.ivs.add(iv1);
        this.ivs.add(iv2);
        this.ivs.add(iv3);
        this.ivs.add(iv4);
        this.ivs.add(iv5);
        this.ivs.add(iv6);
        this.ivs.add(iv7);
        this.ivs.add(iv8);

        this.lgs.add(LG1);
        this.lgs.add(LG2);
        this.lgs.add(LG3);
        this.lgs.add(LG4);
        this.lgs.add(LG5);
        this.lgs.add(LG6);

        this.lgsS.add(LG1S);
        this.lgsS.add(LG2S);
        this.lgsS.add(LG3S);
        this.lgsS.add(LG4S);
        this.lgsS.add(LG5S);
        this.lgsS.add(LG6S);

        this.lls.add(LL1);
        this.lls.add(LL2);
        this.lls.add(LL3);
        this.lls.add(LL4);
        this.lls.add(LL5);
        this.lls.add(LL6);

        this.llsS.add(LL1S);
        this.llsS.add(LL2S);
        this.llsS.add(LL3S);
        this.llsS.add(LL4S);
        this.llsS.add(LL5S);
        this.llsS.add(LL6S);

        this.lines.add(line1);
        this.lines.add(line2);
        this.lines.add(line3);
        this.lines.add(line4);
        this.lines.add(line5);
        this.lines.add(line6);

        this.linesS.add(line1S);
        this.linesS.add(line2S);
        this.linesS.add(line3S);
        this.linesS.add(line4S);
        this.linesS.add(line5S);
        this.linesS.add(line6S);

    }

    @FXML
    public void presetScaleGroups(int year) {
        int max = 0;
        int multiplier = 0;
        ArrayList<Group> currentGroups = new ArrayList();
        this.linesVis = 0;
        if (year == 1970) {
            max = 7;
            multiplier = 1;
            currentGroups = this.lgs;
        } else {
            max = 12;
            multiplier = 2;
            currentGroups = this.lgsS;
        }

        if (this.cheeseData.get(year).get(0).getYearlyValue(year) < max) {
            int index = 0;
            int value = multiplier;
            while (value < this.cheeseData.get(year).get(0).getYearlyValue(year) && index < 6) {
                currentGroups.get(index).setLayoutX(value * 450 / this.cheeseData.get(year).get(0).getYearlyValue(year) + 275);
                if (year == 1970) {
                    currentGroups.get(index).setOpacity(this.scaleOpac);
                }
                index++;
                value = value + multiplier;
                this.linesVis++;
            }
        }
    }

    private void makeLineLabels() {
        for (int i = 0; i < 6; i++) {
            this.lls.get(i).setText(i + 1 + "");
            this.llsS.get(i).setText((i + 1) * 2 + "");
        }
    }

    //USE RECTANGLECHEESE TO LOG RECTANGLE WIDTH VALUES BEFORE ANIMATIONS HAPPEN
    //BECAUSE INCREMENTS != YEARLY VALUES
    private void presetRectangleValues() {
        for (int i = 0; i < this.rects.size(); i++) {
            this.rectcheeses.add(new RectangleCheese(this.rects.get(i), this.cheeseData.get(1970).get(i).getYearlyValue(1970)));
        }
    }

}
