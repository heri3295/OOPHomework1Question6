import java.util.Scanner;

public class CirclesTouching {

    public static class Circle{
        double XCOOR;
        double YCOOR;
        double radii;

        public Circle(){
            XCOOR = 0.0;
            YCOOR = 0.0;
            radii = 0.0;
        }
    }

    static double ReadInValues(){
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextDouble()) { return reader.nextDouble(); }
        else {
            System.out.println("Error, value not allowed. Using 0.0 instead. ");
            return 0;
        }
    }

    static double DetermineDistance (Circle pointone, Circle pointtwo){
        double distance = 0.0;
        distance = Math.sqrt( Math.pow( pointtwo.XCOOR - pointone.XCOOR , 2) + Math.pow( pointtwo.YCOOR - pointone.YCOOR , 2) );
        return distance;
    }

    static  void DetermineOverlap (double distance, Circle larger, Circle smaller){
        if ( (larger.radii + smaller.radii) < distance){ System.out.println("These circles are not touching."); }
        if ( (larger.radii + smaller.radii) > distance ) {
            if ( (smaller.radii + distance) < larger.radii) { System.out.println("The circles are within one another. "); }
            else { System.out.println("The circles are overlapping. "); }
        }
        if ( (larger.radii + smaller.radii) == distance ) { System.out.println("These circles are tangents of each other. ");}
    }

    public static void main(String[] args){

        Circle pointOne = new Circle();
        Circle pointTwo = new Circle();

        double distanceBtwnCircles = 0.0;

        System.out.print("Please input an X coordinate for the center of Circle 1: ");
        pointOne.XCOOR = ReadInValues();
        System.out.print("Please input an Y coordinate for the center of Circle 1: ");
        pointOne.YCOOR = ReadInValues();
        System.out.print("Please input a radius for Circle 1: ");
        pointOne.radii = ReadInValues();
        System.out.print("Please input an X coordinate for the center of Circle 2: ");
        pointTwo.XCOOR = ReadInValues();
        System.out.print("Please input an Y coordinate for the center of Circle 2: ");
        pointTwo.YCOOR = ReadInValues();
        System.out.print("Please input a radius for Circle 2: ");
        pointTwo.radii = ReadInValues();

        distanceBtwnCircles = DetermineDistance(pointOne, pointTwo);
        System.out.println("The distance between the two center's of the circles is: " + distanceBtwnCircles);
        if (pointOne.radii >= pointTwo.radii) {
            DetermineOverlap(distanceBtwnCircles, pointOne, pointTwo); //The arguments are double, LARGER Circle, SMALLER Circle.
        } else {
            DetermineOverlap(distanceBtwnCircles, pointTwo, pointOne); //The arguments are double, LARGER Circle, SMALLER Circle.
        }
    }
}
