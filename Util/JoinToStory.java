package Util;

import Classes.Hero;
import Classes.Location;
import Classes.Transport;

public interface JoinToStory {
    void joinToStory(Hero hero);

    void joinToStory(Transport transport);

    void joinToStory(Location location);
}
