package MainClass;

import Classes.*;
import Util.JoinToStory;
import Exception.NotNameException;

import java.util.ArrayList;

public class Story {
    ArrayList<Hero> heroes = new ArrayList<>();
    ArrayList<Transport> transports = new ArrayList<>();
    ArrayList<Location> locations = new ArrayList<>();

    // anonymous inner class
    JoinToStory joinToStory = new JoinToStory() {
        @Override
        public void joinToStory(Hero hero) {
            System.out.println("Герой " + hero.getNameWeight() + hero.getName() + " присоединился к истории");
        }

        @Override
        public void joinToStory(Transport transport) {
            System.out.println("Транспорт " + transport.getName() + " появился");
        }

        @Override
        public void joinToStory(Location location) {
            System.out.println("Локация " + location.getNameLocation() + " в месте " + location.getNamePlace() + " появилась");
        }
    };

    public static void main(String[] args) {
        Story story = new Story();
        StoryStarter storyStarter = new StoryStarter();
        storyStarter.storyStart();

        Location forest = new Location("поляна", "лес");
        story.addLocation(forest);
        Hero fatCop = new Hero("полицейский", 90);
        Hero.Body fatCopBody = fatCop.new Body();
        fatCopBody.addNameWeight();
        story.addHero(fatCop);
        Hero vintik = new Hero("Винтик", 70);
        Hero.Body vintikBody = vintik.new Body();
        vintikBody.addNameWeight();
        story.addHero(vintik);
        Hero friendsVintik = new Hero("друзья Винтика", 70);
        Hero.Body friendsVintikBody = friendsVintik.new Body();
        friendsVintikBody.addNameWeight();
        story.addHero(friendsVintik);

        fatCop.setLocation(forest);
        vintik.setLocation(forest);
        friendsVintik.setLocation(forest);
        fatCop.addFeeling(Feelings.RESENTMENT);
        try {
            fatCop.kick(vintik);
        } catch (NotNameException e) {
            System.out.println(e.getMessage());
        }

        fatCop.setLocation(forest);
        Transport car = new Transport("машина", true);
        story.addTransport(car);
        car.setLocation(forest);
        vintik.goByTransport(car);
        friendsVintik.goByTransport(car);

        try {
            Thread.sleep(1000);
            System.out.print("Некоторое время спустя\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Location exitForest = new Location("выезд", "выезд с леса");
        story.addLocation(exitForest);
        car.setLocation(exitForest);
        vintik.goByTransport(car);
        friendsVintik.goByTransport(car);

        Location village = new Location("деревня", "Нееловка");
        story.addLocation(village);
        car.setLocation(village);
        vintik.goByTransport(car);
        friendsVintik.goByTransport(car);
        Location houseVillage = new Location("дома деревни", "Нееловка");
        story.addLocation(houseVillage);
        Hero countryPeople = new Hero("жители Нееловки", 70);
        Hero.Body countryPeopleBody = countryPeople.new Body();
        countryPeopleBody.addNameWeight();
        story.addHero(countryPeople);
        countryPeople.setLocation(houseVillage);
        countryPeople.runOutOfHouse(car);
        countryPeople.addFeeling(Feelings.FEAR);
        countryPeople.doMove(car);
        StoryEnder storyEnder = new StoryEnder();
        storyEnder.storyEnd();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
        joinToStory.joinToStory(hero);
    }

    public void addTransport(Transport transport) {
        transports.add(transport);
        joinToStory.joinToStory(transport);
    }

    public void addLocation(Location location) {
        locations.add(location);
        joinToStory.joinToStory(location);
    }

    // static nested class
    private static class StoryStarter {
        public void storyStart() {
            System.out.println("Начинается история");
        }
    }

    // static nested class
    private static class StoryEnder {
        public void storyEnd() {
            System.out.println("История закончилась");
        }
    }
}
