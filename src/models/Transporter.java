// package the class is in
package models;

import exceptions.BoardException;
import exceptions.LoadException;

import java.util.ArrayList;

// class extends the blueprint of Spaceship.java
public final class Transporter extends MannedSpaceship {

    // new UNIQUE attributes to only this Transporter class
    private int currentLoad;
    private final int maxCapacity; // final means it's not possible to change the value

    // constructor for this object
    public Transporter(String designation, int xPos, int yPos, int currentLoad, int maxCapacity, int seats){
        // super means this constructor is using the variable declarations / initialisations of the parent
        // class, in this case Spaceship.java and by extension, MannedSpaceship.java
        super(designation, xPos, yPos, seats);

        // new unique attributes have to be declared separately
        this.currentLoad = currentLoad;
        this.maxCapacity = maxCapacity;
    }

    // constructor for quick generation
    public Transporter(String designation){
        // take the name from the parent constructor
        super(designation);
        // set attributes that haven't been set by the parent constructors yet
        this.seats = 5;
        this.currentLoad = 0;
        this.maxCapacity = 40;
        // using this constructor now results in the following:
        // A Spaceship object of the type Transporter with random x / y coordinates [set in Spaceship.java]
        // usedSeats is set to 0 [set in MannedSpaceship.java]
        // Has an empty ArrayList crew [set in MannedSpaceship.java]
        // seats set to 5 [set above]
        // currentLoad set to 0 [set above]
        // maxCapacity set to 40 [set above]

    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void board(Astronaut a) throws BoardException {
        if(this.usedSeats < seats) {
            this.crew.add(a);
            usedSeats++;
            System.out.println(a.getName() + " boarded the " + this.getDesignation());
        }
        else{
            throw new BoardException("No free seats");
        }
    }

    // BONUS: overrride toString();
    @Override
    public String toString() {
        return "Transporter: " +
                "Designation: " + this.getDesignation() +
                ", xPos: " + this.getxPos() +
                ", yPos: " + this.getyPos() +
                ", seats: " + seats +
                ", usedSeats: " + usedSeats +
                ", crew: " + crew +
                ", currentLoad: " + this.getCurrentLoad() +
                ", maxCapacity: " + this.getMaxCapacity();
    }

    // BONUS TASK
    // a method to manage the load of a Transporter
    public void manageLoad(int loadModifier) throws LoadException {

        // check whether the ship is getting loaded or unloaded. > 0 means getting loaded
        if(loadModifier > 0){
            // check if capacity is maxed out
            if(currentLoad == maxCapacity){
                throw new LoadException("You are already at max capacity!");
            }
            // check if the modified amount would go over the limit
            else if(currentLoad + loadModifier <= maxCapacity) {
                // add the specified amount of units
                currentLoad = currentLoad + loadModifier;
                System.out.println("Your new load is " + currentLoad + " units.");
            }
            else{
                int overLoad = currentLoad + loadModifier - maxCapacity;
                System.out.println("You are overloading the ship, please try a lower amount of units.");
                System.out.println("Your current capacity is " + currentLoad + ", you went over the max capacity by " + overLoad + " units");
            }
        }
        // check whether the ship is getting loaded or unloaded. < 0 means getting unloaded
        if(loadModifier < 0){
            // check if there are any units to unload
            if(currentLoad == 0){
                throw new LoadException("You have no current load on your ship to withdraw!");
            }
            // check if there are enough units to unload
            else if(currentLoad + loadModifier >= 0){
                currentLoad += loadModifier;
                System.out.println("Your new load is " + currentLoad + " units.");
            }
            // what if there aren't enough units
            else if(currentLoad + loadModifier < 0){
                throw new LoadException("There aren't enough units to unload");
                /* old error handling
                // save the amount of units previously loaded
                int prevCurrentLoad = currentLoad;
                // check how many units were tried to be withdrawn over the limit
                int overDraft = currentLoad + loadModifier;
                // set load to 0
                currentLoad = 0;
                // send out the message
                System.out.println("You only had " + prevCurrentLoad + " units in your ship, all of which were withdrawn. You went " + overDraft + " units over the limit.");
                System.out.println("Your new load is " + currentLoad + " units.");
                 */
            }
        }
    }
}
