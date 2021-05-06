// package this class is in
package models;

// class
public class Spaceship{
    // class attributes, aka variables. ALL classes that extend this Spaceship class have access to these
    private String designation;
    private int xPos;
    private int yPos;

    // Class variables
    private static int numOfSpaceships;

    // constructor to set values
    public Spaceship(String designation, int xPos, int yPos) {
        this.designation = designation;
        this.xPos = xPos;
        this.yPos = yPos;
        numOfSpaceships++;
    }

    // constructor for default values for quick generation
    public Spaceship(String designation){
        this.designation = designation;
        // creates random numbers for x and y. (int) converts a double into an integer
        this.xPos = (int) Math.round(Math.random());
        this.yPos = (int) Math.round(Math.random());
        numOfSpaceships++;
    }

    // getter / setter, generated via the IDE
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public int getxPos() {
        return xPos;
    }
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    public static int getNumOfSpaceships() {
        return numOfSpaceships;
    }
    public static void setNumOfSpaceships(int numOfSpaceships) {
        Spaceship.numOfSpaceships = numOfSpaceships;
    }

    // fly method, accepts 2 int parameters
    public void fly(int x, int y){
        xPos += x;
        yPos += y;
        System.out.println("The new position is now (" + xPos + "|" + yPos + ")");
    }

    // BONUS: override toString();
    @Override
    public String toString() {
        return "Spaceship: " +
                "Designation: " + designation +
                ", xPos: " + xPos +
                ", yPos: " + yPos;
    }
}
