package Classes;

import Exception.NotNameException;

public class Hero extends Human {
    protected boolean isRunOutOfHouse;

    public Hero(String name, int weight) throws NullPointerException {
        super(name, weight);
    }

    public void kick(Hero hero) throws NotNameException {
        if (this.equals(hero)) {
            throw new NotNameException("Герой не может сам себя пнуть");
        } else {
            for (Feelings feeling : feelings) {
                if (feeling == Feelings.RESENTMENT) {
                    System.out.println("Герой " + this.nameWeight + this.getName() + " не смог уйти от расплаты, поэтому пнул Героя " + this.nameWeight + hero.getName());
                    delFeeling(Feelings.RESENTMENT);
                } else {
                    System.out.println("Герой " + this.nameWeight + this.getName() + " смог уйти от расплаты, поэтому Герой " + this.nameWeight + hero.getName() + " остался без пинка");
                }
                break;
            }
        }
    }

    public void goByTransport(Transport transport) {
        changeCity("внутри " + transport.getName(), transport.getNamePlace());
        System.out.println("Герой " + this.nameWeight + this.getName() + " едет на траспорте " + transport.getName());
    }

    public void runOutOfHouse(Transport transport) {
        if ((location.compareLocation(this, transport)) && (transport.isNoisy)) {
            System.out.println(this.nameWeight + this.getName() + " услышали шум транспорта " + transport.getName() + " выбежал(и) из дома(ов)");
            changeCity("дорога перед домом", location.getNamePlace());
        } else {
            System.out.println(this.nameWeight + this.getName() + " ничего странного не услышал(и)");
            location.changeLocation("дом");
        }
    }

    public void doMove(Transport transport) {
        for (Feelings feeling : feelings) {
            if (feeling == Feelings.FEAR) {
                System.out.println("Герой(и) " + this.nameWeight + this.getName() + " успугались незнакомого транспорта " + transport.getName() + ", поэтому в страхе попятелись");
                changeCity("дверь дома", location.getNamePlace());
                delFeeling(Feelings.FEAR);
                break;
            }
            if (feeling == Feelings.GLADNESS) {
                System.out.println("Герой(и) " + this.nameWeight + this.getName() + " обрадовались, увидев транспорт " + transport.getName() + ", поэтому пошли его встречать");
                changeCity("около " + transport.getName(), location.getNamePlace());
                delFeeling(Feelings.GLADNESS);
                break;
            }
            if (feeling == Feelings.SURPRISE) {
                System.out.println("Герой(и) " + this.nameWeight + this.getName() + " удивились, увидев транспорт " + transport.getName() + ", потому остались стоять ошарашенными некоторое время");
                changeCity("дорого перед домом", location.getNamePlace());
                delFeeling(Feelings.GLADNESS);
                break;
            }
        }
    }

    public void addFeeling(Feelings feel) {
        for (int i = 0; i < feelings.length; i++) {
            if (feelings[i] == null) {
                feelings[i] = feel;
                System.out.println("Герой(и) " + this.nameWeight + this.getName() + " начал(и) чувствовать " + feel.toString());
                break;
            }
        }
    }

    public void delFeeling(Feelings feel) {
        for (int i = 0; i < feelings.length; i++) {
            if (feelings[i] == feel) {
                feelings[i] = null;
                System.out.println("Герой(и) " + this.nameWeight + this.getName() + " перестал(и) чувствовать " + feel.toString());
                break;
            }
        }
    }

    public void setMove(Transport transport) {
        isRunOutOfHouse = transport.isNoisy;
    }

    @Override
    public void changeLocation(String newLocation) {
        location.changeLocation(newLocation);
        System.out.println("Герой " + this.nameWeight + this.getName() + " поменял свою локацию на " + location.getNameLocation() + " в месте " + location.getNamePlace());
    }

    @Override
    public void changeCity(String newLocation, String namePlace) {
        location.changeCity(newLocation, namePlace);
        System.out.println("Герой " + this.nameWeight + this.getName() + " поменял свою локацию на " + location.toString());
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
        System.out.println("Герой(и) " + this.nameWeight + this.getName() + " находится в " + location.toString());
    }

    public String getNamePlace() {
        return location.getNamePlace();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Hero hero = (Hero) otherObject;
        return (this.feelings == hero.feelings && this.location == hero.location && this.getName().equals(hero.getName()) && this.isRunOutOfHouse == hero.isRunOutOfHouse);
    }

    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : getName().hashCode();
        result += 31 * weight;
        result += 31 * location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Герой(и) " + this.nameWeight + this.getName() + " присоединился к истории";
    }

    // non-static nested class (inner class)
    public class Body {
        public void addNameWeight() {
            if (weight >= 80) {
                nameWeight = "Толстый ";
            }
            if ((weight < 80) && (weight >= 60)) {
                nameWeight = "";
            }
            if (weight < 60) {
                nameWeight = "Худой ";
            }
        }
    }
}

