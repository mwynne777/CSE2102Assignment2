package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.text.*;

public class Main extends Application {

    Rectangle circle;
    private static String numberOfDotsString, probabilityString;
    private static int numberOfDots;
    private static double probability;
    private static double[][] array;
    private static ArrayList<Integer> linesStarts = new ArrayList<Integer>();
    private static ArrayList<Integer> linesEnds = new ArrayList<Integer>();
    Text t;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
        circle = new Rectangle(50,50,300,300);
        circle.setStroke(Color.BLACK);
        circle.setFill(null);
        circle.setStrokeWidth(3);
        circle.setArcWidth(300);
        circle.setArcHeight(300);
        //t = new Text(50, 50, numberOfDotsString);
        //t.setFont(new Font(20));

        Pane layout = new Pane();

        for(int a = 0; a < array[0].length; a ++){

            System.out.println("Reading point " + a + " x coord as " + array[0][a]);

            Rectangle point = new Rectangle(199 + array[0][a], 199 + array[1][a], 3, 3);
            point.setStroke(Color.BLACK);
            point.setArcWidth(3);
            point.setArcHeight(3);
            layout.getChildren().add(point);


        }

        for(int b = 0; b < linesStarts.size(); b++){

            Line line1 = new Line(200 + array[0][linesStarts.get(b)], 200 + array[1][linesStarts.get(b)], 200 + array[0][linesEnds.get(b)], 200 + array[1][linesEnds.get(b)]);
            line1.setStroke(Color.GRAY);
            layout.getChildren().add(line1);
        }


        layout.getChildren().add(circle);
        //layout.getChildren().add(t);
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        if(args.length != 0){

            numberOfDots = Integer.parseInt(args[0]);
            probability = Double.parseDouble(args[1]);

        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("How many dots would you like to see?");
            numberOfDotsString = sc.next();
            numberOfDots = Integer.parseInt(numberOfDotsString);
            System.out.println("What is the probability of pairing?");
            probabilityString = sc.next();
            probability = Double.parseDouble(probabilityString);
        }
        array = calculateLocations(numberOfDots, probability);
        launch(args);

    }

    public static double[][] calculateLocations(int numberOfDots, double probability){

        double[][] points = new double[2][numberOfDots];
        double angle = 360.0/numberOfDots;
        System.out.println("Angle:  " + angle);
        double currAngle = 0;
        for(int i = 0; i < numberOfDots; i++){

            double x = Math.cos(Math.toRadians(currAngle))*150;
            double y = Math.sin(Math.toRadians(currAngle))*150;

            System.out.println("Point number:  " + (i + 1));
            System.out.println("X coordinate:  " + x);
            System.out.println("Y coordinate:  " + y);
            points[0][i] = x;
            points[1][i] = y;
            System.out.println(currAngle);
            currAngle += angle;

        }

        for(int a = 0; a < numberOfDots; a ++) {

            for(int b = 0; b < numberOfDots; b++) {

                double rand = Math.random();
                if(a != b && rand < probability) {
                    //System.out.println("A:  " + a + " B: " + b);
                    linesStarts.add(a);
                    linesEnds.add(b);

                }
            }

        }

        for(int c = 0; c < linesStarts.size(); c++){

            System.out.println(linesStarts.get(c) + " to " + linesEnds.get(c));

        }

        return points;

    }
}
