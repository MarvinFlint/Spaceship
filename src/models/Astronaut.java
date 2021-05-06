package models;

public class Astronaut {
    // attributes for the Astronaut object
    private String name;
    private int enduresG ;

    // first constructor for both attributes
    public Astronaut(String name, int enduresG){
        this.name = name;
        this.enduresG = enduresG;
    }

    // "convenient" second constructor
    public Astronaut(String name){
        this.name = name;
        this.enduresG = 3;
    }

    // getters, setters, you know the drill
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getenduresG() {
        return enduresG;
    }

    public void setenduresG(int enduresG) {
        this.enduresG = enduresG;
    }
}
