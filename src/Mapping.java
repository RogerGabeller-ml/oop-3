import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    public static LocationMap loc = new LocationMap();

    public static HashMap<String, String> vocabulary = new HashMap<String, String>();

    FileLogger fl = new FileLogger();

    ConsoleLogger cl = new ConsoleLogger();


    public Mapping() {
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTHWEST", "NW");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("UP", "U");
        vocabulary.put("DOWN", "D");
    }

    public void mapping() {

        /** TODO
         * create a Scanner object
         */
        Scanner sc = new Scanner(System.in);

        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        int location = INITIAL_LOCATION;

        while (true) {

            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            cl.log(loc.get(location).getDescription());
            fl.log(loc.get(location).getDescription() + "\n");

            /** TODO
             * verify if the location is exit
             */
            if(location == 0) {break;}

            /** TODO
             * get a map of the exits for the location
             */
            Map<String, Integer> exits = loc.get(location).getExits();

            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */

            String[] lexits = exits.keySet().toArray(new String[0]);
            cl.log("Available exits are " + String.join(", ", lexits) + ", ");
            fl.log("Available exits are " + String.join(", ", lexits) + ", \n");

            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            String[] inp = sc.nextLine().split(" ");

            String dir = null;
            for(String s : inp) {
                if (vocabulary.containsKey(s.toUpperCase())) {
                    dir = vocabulary.get(s.toUpperCase());
                }
                if (vocabulary.containsValue(s.toUpperCase()) && inp.length == 1) {
                    dir = s.toUpperCase();
                }
            }

            /** TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
            if (dir == null) {
                System.out.println("You cannot go in that direction");
                fl.log("You cannot go in that direction\n");
            } else if (dir.equals("Q")) {
                location = 0;
            } else {
                if (exits.containsKey(dir)) location = exits.get(dir); else {
                    System.out.println("You cannot go in that direction");
                    fl.log("You cannot go in that direction\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping mapping = new Mapping();
        mapping.mapping();
    }

}
