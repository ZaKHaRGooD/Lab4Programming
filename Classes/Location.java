package Classes;

public class Location {
    private String nameLocation;
    private String namePlace;

    public Location(String nameLocation, String namePlace) {
        this.nameLocation = nameLocation;
        this.namePlace = namePlace;
        validateNameLocation(nameLocation, namePlace);
    }

    // method-local inner class
    private void validateNameLocation(String nameLocation, String namePlace) {
        class NameLocation {
            public void CheckName() {
                if ((nameLocation == null) || (namePlace == null)) {
                    System.out.println("Имя локации и места не могут быть null");
                }
            }
        }
        NameLocation nameLocation1 = new NameLocation();
        nameLocation1.CheckName();
    }

    public void changeLocation(String newLocation) {
        nameLocation = newLocation;
    }

    public void changeCity(String newLocation, String newPlace) {
        nameLocation = newLocation;
        namePlace = newPlace;
    }


    public boolean compareLocation(Hero hero, Transport transport) {
        return hero.getNamePlace().equals(transport.getNamePlace());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location l = (Location) o;
        return namePlace.equals(l.namePlace);
    }

    @Override
    public int hashCode() {
        int result = nameLocation == null ? 0 : nameLocation.hashCode();
        result += namePlace == null ? 0 : namePlace.hashCode() * 31;
        return result;
    }

    @Override
    public String toString() {
        return "Локация " + nameLocation + " в месте " + namePlace;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public String getNamePlace() {
        return namePlace;
    }
}


