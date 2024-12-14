package NavigationSystem;

import java.util.*;

public class NavigationSystem {
    private CityMap cityMap;

    public NavigationSystem(CityMap cityMap) {
        this.cityMap = cityMap;
    }

    public List<String> findShortestPath(String start, String end) {
        // Dijkstra's algorithm
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();

        minHeap.add(new Node(start, 0));
        distances.put(start, 0);

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            String current = currentNode.name;

            if (current.equals(end)) {
                // Build the path
                List<String> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = previousNodes.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (CityMap.Edge neighbor : cityMap.getNeighbors(current)) {
                int newCost = currentNode.cost + neighbor.weight;
                if (!distances.containsKey(neighbor.node) || newCost < distances.get(neighbor.node)) {
                    distances.put(neighbor.node, newCost);
                    previousNodes.put(neighbor.node, current);
                    minHeap.add(new Node(neighbor.node, newCost));
                }
            }
        }

        return null; // No path found
    }

    public List<String> calculateRoute(String start, String end, UserPreferences userPrefs) {
        if (userPrefs.isAvoidTraffic()) {
            // Add traffic logic here (placeholder)
        }
        return findShortestPath(start, end);
    }

    static class Node {
        String name;
        int cost;

        Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }
}
