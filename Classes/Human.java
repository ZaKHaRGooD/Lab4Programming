package Classes;

import Util.HaveLocation;

public abstract class Human implements HaveLocation {
    final private String name;
    protected Feelings[] feelings = new Feelings[5];
    protected Location location;
    final protected int weight;

    public String getNameWeight() {
        return nameWeight;
    }

    protected String nameWeight;


    public Human(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    abstract public void changeLocation(String newLocation);
    abstract public void changeCity(String newLocation, String newCity);
    abstract public void setLocation(Location location);
}
