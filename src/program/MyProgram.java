// the package this class is in
package program;

// imported packages
import exceptions.BoardException;
import models.Astronaut;
import models.Fighter;
import models.Spaceship;
import models.Transporter;

// main class
public class MyProgram {
    public static void main(String[] args){

        // class variables - get # of generated ships
        System.out.println(Spaceship.getNumOfSpaceships() + " Spaceships were generated");
        System.out.println();

        // create spaceship objects
        Spaceship s1 = new Spaceship("'Oreon'", 10, 10);
        Fighter f1 = new Fighter("'Delorean'", 0, 0, 5, 2);
        Transporter t1 = new Transporter("'Hawkins'", 20, 20, 0, 50, 10);

        // use alternative constructors
        Spaceship s2 = new Spaceship("'Borealis'");
        Fighter f2 = new Fighter("'The Eagle'");
        Transporter t2 = new Transporter("'Wellerman'");

        /* Old
        Spaceship s2 = new Fighter("Delorean", 0, 0, 5, 2);
        Spaceship s3 = new Transporter("Hawkins", 20, 20, 0, 50, 10);
         */

        // create Astronaut objects

        Astronaut a1 = new Astronaut("Neil Armstrong", 6);
        Astronaut a2 = new Astronaut("Buzz Aldrin", 5);
        Astronaut a3 = new Astronaut("Michael Collins", 6);
        Astronaut a4 = new Astronaut("Gary Bruckheimer");
        Astronaut a5 = new Astronaut("Hank Turner");
        Astronaut a6 = new Astronaut("Mark Rober", 100);

        // let em fly
        s1.fly(4, 3);
        f1.fly(2, 2);
        t1.fly(15, 15);
        System.out.println();

        // use a getter. totally pointless, but ey.
        System.out.println("The name of the F1 is: " + f1.getDesignation());
        System.out.println();

        // use the shoot method
        f1.shoot(2);
        System.out.println();

        // manage load for a transporter
        t1.manageLoad(5);
        t1.manageLoad(-3);
        t1.manageLoad(-5);
        System.out.println();

        try {
            // add astronauts to ships
            f1.board(a1);
            f1.board(a2);
            // overload the f1
            f1.board(a3);
            // make one of them exit...twice
            f1.exit(a1);
            f1.exit(a1);
            // re-try
            f1.board(a3);
            System.out.println();
        }
        catch(BoardException e){
            System.out.println(e.getMessage());
        }
        // board another spaceship
        try{
            t2.board(a4);
            t2.board(a5);
        }
        catch(BoardException e){
            System.out.println(e.getMessage());
        }
        try{
            f2.board(a6);
        }
        catch (BoardException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        // overwritten toString methods
        System.out.println(s1.toString());
        System.out.println();
        System.out.println(f2.toString());
        System.out.println();
        System.out.println(t1.toString());

        // WIP - get crewmember names, not addresses
        f1.getCrew();

        // class variables - get # of generated ships
        System.out.println(Spaceship.getNumOfSpaceships() + " Spaceships were generated");
    }
}
