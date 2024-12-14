package NavigationSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a city map
        CityMap cityMap = new CityMap();
        cityMap.addRoad("A", "B", 5);
        cityMap.addRoad("A", "C", 10);
        cityMap.addRoad("B", "C", 3);
        cityMap.addRoad("B", "D", 2);
        cityMap.addRoad("C", "D", 1);

        // Initialize the navigation system
        NavigationSystem navSystem = new NavigationSystem(cityMap);

        // User preferences
        UserPreferences userPrefs = new UserPreferences("car", true);

        // Find a route
        String start = "A";
        String end = "D";
        List<String> path = navSystem.calculateRoute(start, end, userPrefs);

        if (path != null) {
            System.out.println("Shortest path from " + start + " to " + end + ": " + path);
        } else {
            System.out.println("No path found from " + start + " to " + end);
        }
    }
}
