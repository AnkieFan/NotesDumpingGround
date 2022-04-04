import java.util.Arrays;

public class WeightedGraph {
    private int vertexNum;
    private int[] vertexes;
    private int[][] weights;

    // Initialize an empty graph with a maximum of size vertices
    public WeightedGraph(int size) {
        this.vertexNum = size;
        vertexes = new int[vertexNum];
        for (int i = 0; i < size; i++) {
            vertexes[i] = i;
        }
        weights = new int[vertexNum][vertexNum];
        for (int[] i : weights) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
    }

    // Returns the degree of vertex with id/index n
    public int degree(int n) {
        int count = 0;

        for (int j = 0; j < weights[n].length; j++) {
            if (weights[n][j] != Integer.MAX_VALUE)
                count++;
        }
        return count;
    }

    // Returns the total number of edges in the graph
    public int edgeCount() {
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                if (weights[i][j] != Integer.MAX_VALUE)
                    count++;
            }
        }
        return count / 2;
    }

    // Returns the weight of the edge connecting vertices m and n. 
    // If the vertices are equal, return 0. 
    // If the vertices are not adjacent, return -1
    public int adjacent(int m, int n) {
        if (m == n)
            return 0;

        if (weights[m][n] == Integer.MAX_VALUE)
            return -1;

        return weights[m][n];
    }

    // Return the minimum spanning tree of this WeightedGraph in the form of a new WeightedGraph
    public WeightedGraph minimumSpanningTree() {
        WeightedGraph newG = new WeightedGraph(vertexNum);

        int[] visited = new int[vertexNum];
        visited[0] = 1;
        int h1 = -1;
        int h2 = -2;
        int minWeight = Integer.MAX_VALUE;

        for (int k = 1; k < vertexNum; k++) {

            for (int i = 0; i < vertexNum; i++) {
                for (int j = 0; j < vertexNum; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && weights[i][j] < minWeight) {
                        minWeight = weights[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            if (minWeight == Integer.MAX_VALUE)
                break;
            newG.insert(h1, h2, minWeight);
            System.out.println("Edge<" + vertexes[h1] + ", " + vertexes[h2] + " > weight: " + minWeight);
            visited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }

        return newG;
    }

    // If the weight w is 0, remove any edge between m and n (if any). 
    // Otherwise, add an edge between vertices m and n with weight w. 
    // If an edge already exists, replace the weight of the edge with the new weight. 
    // If the vertices do not exist or are equal, throw an exception.
    public void insert(int m, int n, int w) {
        if (m > vertexNum || n > vertexNum || m == n)
            throw new RuntimeException();

        if (w == 0) {
            weights[m][n] = Integer.MAX_VALUE;
            weights[n][m] = Integer.MAX_VALUE;
        } else {
            weights[m][n] = w;
            weights[n][m] = w;
        }

    }

    public void showGraph() {
        for (int[] edges : weights) {
            System.out.println(Arrays.toString(edges));
        }
    }

    // Give your submission a name here so you can recognise the results when posted (keep it civil though please :))
    public String getName() {
        return "Break?";
    }


}
