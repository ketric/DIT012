package samples.basics;


import static java.lang.System.*;

/**
 * Object model for dice wars (not complete)
 */
public class OOModel {

    public static void main(String[] args) {
        new OOModel().program();
    }


    void program() {
        // Create objects and connect them
        Player p1 = new Player("pelle");
        Player p2 = new Player("fia");
        Country c1 = new Country("aaa", p1, 4);  // Use constructor to connect
        Country c2 = new Country("bbb", p1, 3);
        Country c3 = new Country("ccc", p2, 2);
        c1.neighbours = new Country[]{c2, c3};
        c2.neighbours = new Country[]{c1};
        c3.neighbours = new Country[]{c1};

        Country[] cs = {c1, c2, c3};
        Map m = new Map(cs);     // Use constructor to connect

        // Now we can start to add the logic ....

        // ... but for now we just print some data
        out.println(m.countries[2].name);
        out.println(m.countries[0].owner.name);
        out.println(m.countries[0].neighbours[1].owner.name);
        out.println(m.countries[2].hasBorder(c1));
        out.println(m.countries[1].hasBorder(c3));
        out.println(m.hasBorders(c1, c2));
    }

    // --- Classes -----

    class Map {
        Country[] countries;

        Map(Country[] countries) {
            this.countries = countries;
        }

        boolean hasBorders(Country c1, Country c2) {
            for (int i = 0; i < countries.length; i++) {
                if (countries[i] == c1 && countries[i].hasBorder(c2)) {
                    return true;
                }
            }
            return false;
        }
    }

    class Country {
        final String name;
        Country[] neighbours;
        Player owner;
        int nDices;

        Country(String name, Player owner, int nDices) {
            this.name = name;
            this.owner = owner;
            this.nDices = nDices;
        }

        boolean hasBorder(Country other) {
            for (int i = 0; i < neighbours.length; i++) {
                if (neighbours[i] == other) {
                    return true;
                }
            }
            return false;
        }
    }

    class Player {
        final String name;

        Player(String name) {
            this.name = name;
        }
    }
}


