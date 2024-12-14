package NavigationSystem;

import java.util.*;

public class CityMap {
    private Map<String, List<Edge>> graph;

    public CityMap() {
        this.graph = new HashMap<>();
    }

    public void addRoad(String start, String end, int weight) {
        // Add a directed edge from start to end
        graph.putIfAbsent(start, new ArrayList<>());
        graph.get(start).add(new Edge(end, weight));

        // Assuming bidirectional roads, add reverse as well
        graph.putIfAbsent(end, new ArrayList<>());
        graph.get(end).add(new Edge(start, weight));
    }

    public List<Edge> getNeighbors(String node) {
        return graph.getOrDefault(node, new ArrayList<>());
    }

    static class Edge {
        String node;
        int weight;

        Edge(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
