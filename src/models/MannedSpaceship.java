package models;

import exceptions.BoardException;

import java.util.ArrayList;

// extending the class Spaceship means, by definition, that Spaceship is always "unmanned"
abstract class MannedSpaceship extends Spaceship{
    // new attributes for the abstract class MannedSpaceships
    protected int seats;
    protected int usedSeats;
    protected ArrayList<Astronaut> crew;

    // constructor to set values
    public MannedSpaceship(String designation, int xPos, int yPos, int seats) {
        super(designation, xPos, yPos);
        this.seats = seats;
        this.usedSeats = 0;
        this.crew = new ArrayList<Astronaut>();
    }

    // constructor to pass along only the name. any variable not set here will be set in the specific class constructors
    public MannedSpaceship(String designation){
        super(designation);
        this.usedSeats = 0;
        this.crew = new ArrayList<Astronaut>();
    }

    // abstract method board because both child classes have different versions
    abstract void board(Astronaut a) throws BoardException;

    // exit is the same for every ship and thus can be defined here
    public void exit(Astronaut a) throws BoardException{
        if(!crew.remove(a)){
            throw new BoardException(a.getName() + " is currently not on the " + this.getDesignation());
        }
        else{
            System.out.println(a.getName() + " left the " + this.getDesignation());
            this.usedSeats--;
        }
    }

    public void getCrew(){
        for(Astronaut crewman: this.crew){
            System.out.println(crewman.getName());
        }
    }
    // BONUS: override toString();
    @Override
    public String toString() {
        return "MannedSpaceship: " +
                "Designation: " + this.getDesignation() +
                ", xPos: " + this.getxPos() +
                ", yPos: " + this.getyPos() +
                ", seats: " + seats +
                ", usedSeats: " + usedSeats +
                ", crew: " + crew;
    }
}
