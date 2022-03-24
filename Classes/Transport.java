package Classes;

import Util.HaveLocation;
import Util.ThingInterface;

public class Transport implements HaveLocation, ThingInterface {
    private final String name;
    protected Location location;
    protected boolean isNoisy;

    public Transport(String name, boolean isNoisy) {
        this.name = name;
        this.isNoisy = isNoisy;
    }

    @Override
    public void changeLocation(String newLocation) {
        location.changeLocation(newLocation);
        System.out.println("Транспорт " + this.getName() + " поменял свою локацию на " + location.getNameLocation() + " в месте " + location.getNamePlace());
    }

    public String getNamePlace() {
        return location.getNamePlace();
    }

    @Override
    public void changeCity(String newLocation, String newCity) {
        location.changeCity(newCity, newLocation);
        System.out.println("Транспорт " + this.getName() + " поменял свою локацию на " + location.toString());
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
        System.out.println("Транспорт " + this.getName() + " находится в " + location.toString());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Transport transport = (Transport) otherObject;
        return (this.name.equals(transport.name) && this.isNoisy && transport.isNoisy);
    }

    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : name.hashCode();
        result += 31 * location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Транспорт " + name;
    }

    // вложенный нестатитчный класс
    public class partOfTransport {
        String name;
        boolean isNoisy;

        partOfTransport(String name, boolean isNoisy) {
            this.name = name;
            this.isNoisy = isNoisy;
        }
    }
}
