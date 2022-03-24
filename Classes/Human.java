package Classes;

import Util.HaveLocation;
import Exception.NegativeWeightException;

public abstract class Human implements HaveLocation {
    final protected int weight;
    final private String name;
    protected Feelings[] feelings = new Feelings[5];
    protected Location location;
    protected String nameWeight;

    public Human(String name, int weight) throws NullPointerException {
        NullPointerException exception = new NullPointerException();
        if (name == null) throw exception;
        if (weight <= 0) throw new NegativeWeightException("Масса героя не может быть отрицательной");
        this.name = name;
        this.weight = weight;
    }

    public String getNameWeight() {
        return nameWeight;
    }

    public String getName() {
        return name;
    }

    abstract public void changeLocation(String newLocation);

    abstract public void changeCity(String newLocation, String newCity);

    abstract public void setLocation(Location location);
}
