import java.util.*;

public class Dijkstra {
    static class Edge {
        String destination;
        int weight;
        
        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    public static Map<String, Integer> dijkstra(Map<String, List<Edge>> graph, String start) {
        // Initialize distances map with infinity for all nodes
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        // Priority queue to store (distance, node) pairs
        PriorityQueue<Map.Entry<Integer, String>> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getKey)
        );
        priorityQueue.add(new AbstractMap.SimpleEntry<>(0, start));
        
        // Keep track of visited nodes
        Set<String> visited = new HashSet<>();
        
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, String> current = priorityQueue.poll();
            int currentDistance = current.getKey();
            String currentNode = current.getValue();
            
            // Skip if we've already found a better path to this node
            if (currentDistance > distances.get(currentNode)) {
                continue;
            }
            
            // Mark node as visited
            visited.add(currentNode);
            
            // Check all neighbors
            for (Edge edge : graph.get(currentNode)) {
                String neighbor = edge.destination;
                if (visited.contains(neighbor)) {
                    continue;
                }
                
                int distance = currentDistance + edge.weight;
                
                // If we found a shorter path to the neighbor
                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    priorityQueue.add(new AbstractMap.SimpleEntry<>(distance, neighbor));
                }
            }
        }
        
        return distances;
    }
    
    public static void main(String[] args) {
        // Example graph represented as adjacency list
        Map<String, List<Edge>> graph = new HashMap<>();
        
        // Node A
        List<Edge> edgesA = new ArrayList<>();
        edgesA.add(new Edge("B", 1));
        edgesA.add(new Edge("C", 4));
        graph.put("A", edgesA);
        
        // Node B
        List<Edge> edgesB = new ArrayList<>();
        edgesB.add(new Edge("A", 1));
        edgesB.add(new Edge("C", 2));
        edgesB.add(new Edge("D", 5));
        graph.put("B", edgesB);
        
        // Node C
        List<Edge> edgesC = new ArrayList<>();
        edgesC.add(new Edge("A", 4));
        edgesC.add(new Edge("B", 2));
        edgesC.add(new Edge("D", 1));
        graph.put("C", edgesC);
        
        // Node D
        List<Edge> edgesD = new ArrayList<>();
        edgesD.add(new Edge("B", 5));
        edgesD.add(new Edge("C", 1));
        graph.put("D", edgesD);
        
        String startNode = "A";
        Map<String, Integer> shortestDistances = dijkstra(graph, startNode);
        
        System.out.println("Shortest distances from node " + startNode + ":");
        for (Map.Entry<String, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To " + entry.getKey() + ": " + entry.getValue());
        }
    }
} 