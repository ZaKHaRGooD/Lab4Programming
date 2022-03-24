package Util;

import Classes.Location;

public interface HaveLocation {
    void changeLocation(String newLocation);
    void changeCity(String newLocation, String newCity);
    void setLocation(Location location);
}
