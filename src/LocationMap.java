import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    /** TODO
     * create a static locations HashMap
     */
    public static HashMap<Integer, Location> locations = new HashMap<Integer, Location>();

    static {
        /** TODO
         * create a FileLogger object
         */
        FileLogger fl = new FileLogger();

        /** TODO
         * create a ConsoleLogger object
         */
        ConsoleLogger cl = new ConsoleLogger();

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put each location in the locations HashMap using temporary empty hashmaps for exits
         */
        try(Scanner fileReader = new Scanner(new FileReader(LOCATIONS_FILE_NAME))){
            cl.log("Available locations:");
            fl.log("Available locations:\n");
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineArray = line.split(",", 2);
                locations.put(Integer.parseInt(lineArray[0]), new Location(Integer.parseInt(lineArray[0]), lineArray[1], null));
                fl.log(String.format("%s: %s%n", lineArray[0], lineArray[1]));
                System.out.printf("%s: %s%n", lineArray[0], lineArray[1]);
            }
        } catch (IOException e) {
        }


        /**TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * for each location, create a new location object and add its exit
         */
        try(Scanner fileReader = new Scanner(new FileReader(DIRECTIONS_FILE_NAME))){
            cl.log("Available directions:");
            fl.log("Available directions:\n");
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineArray = line.split(",");
                locations.get(Integer.parseInt(lineArray[0])).addExit(lineArray[1], Integer.parseInt(lineArray[2]));
                fl.log(String.format("%s: %s: %s%n", lineArray[0], lineArray[1], lineArray[2]));
                cl.log(String.format("%s: %s: %s", lineArray[0], lineArray[1], lineArray[2]));
            }
        } catch (IOException e) {
        }
    }

    /**TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return locations.containsKey(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        //TODO
        locations.putAll(m);
    }

    @Override
    public void clear() {
        //TODO
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return locations.entrySet();
    }
}
