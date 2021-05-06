// package the class is in
package models;

import exceptions.BoardException;

import java.lang.reflect.Array;
import java.util.ArrayList;

// class extends the blueprint of Spaceship.java
public class Fighter extends MannedSpaceship {

    // new attribute "ammo"
    private int ammo;

    // constructor for this object
    public Fighter(String designation, int xPos, int yPos, int ammo, int seats){
        // super means this constructor is using the variable declarations / initialisations of the parent
        // class, in this case Spaceship.java and by extension, MannedSpaceship.java
        super(designation, xPos, yPos, seats);

        // ammo us UNIQUE to this class "Fighter", hence it needs to be declared separately
        this.ammo = ammo;
    }

    // constructor for quick generation with set default values
    public Fighter(String designation){
        // take the name from the parent constructor
        super(designation);
        // hasn't been set in any of the parent constructors and thus needs to be set here
        this.seats = 2;
        this.ammo = 10;
        // using this constructor now results in the following:
        // A Spaceship object of the type Fighter with random x / y coordinates [set in Spaceship.java]
        // usedSeats is set to 0 [set in MannedSpaceship.java]
        // Has an empty ArrayList crew [set in MannedSpaceship.java]
        // seats set to 2 [set above]
        // ammo set to 10 [set above]
    }
    // shoot method
    public void shoot(int rounds){
        if(ammo > 0){
            System.out.println("You shot " + rounds + " rounds of ammunition into the void");
            ammo--;
        }
        else{
            System.out.println("You have no ammo left!");
        }
    }

    // getter / setter for ammo
    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    // board method
    public void board(Astronaut a) throws BoardException {
        // check whether the Astronaut has a g-Endurance of less than 5
        if(a.getenduresG() <= 5){
            System.out.println(a.getName() + " has not boarded the " + this.getDesignation());
            System.out.println("Astronauts need at least a G-endurance of 5 to board a fighter");
        }
        // if not, check if there is an available seat
        else if(this.usedSeats < seats){
            this.crew.add(a);
            usedSeats++;
            System.out.println(a.getName() + " boarded the " + this.getDesignation());
        }
        // if there is no available seat, print an error message
        else{
            throw new BoardException("Failed to board the " + this.getDesignation());
        }
    }

    // BONUS: override toString();

    @Override
    public String toString() {
        return "Fighter: " +
                "Designation: " + this.getDesignation() +
                ", xPos: " + this.getxPos() +
                ", yPos: " + this.getyPos() +
                ", ammo: " + this.getAmmo() +
                ", seats: " + seats +
                ", usedSeats: " + usedSeats +
                ", crew: " + crew;
    }
}
