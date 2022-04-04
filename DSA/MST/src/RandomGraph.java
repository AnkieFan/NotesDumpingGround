import java.util.Random;

public class RandomGraph {
    private static int MAX_WEIGHT = 20;
    private static Random random = new Random();

    // Generate a graph with nVertices vertices
    public static WeightedGraph randomGraph(int nVertices) {
        // compute the maximum possible number of edges
        // and randomly choose the number of edges less than
        // or equal to the maximum number of possible edges
        int nEdges = random.nextInt(nVertices * ((nVertices - 1) / 2) + 1);

        // Creating an adjacency list representation for the random graph
        WeightedGraph graph = new WeightedGraph(nVertices);

        int n = 0;
        int m = random.nextInt(nVertices - 1) + 1;
        int w = random.nextInt(MAX_WEIGHT);

        // Make sure that node 0 is connected (So your algorithms can always start at node 0)
        graph.insert(0, m, w);

        // A for loop to randomly generate edges
        for (int i = 0; i < nEdges; i++) {
            n = 0;
            m = 0;

            // randomly select two vertices to
            // create an edge between them
            while (n == m) {
                n = random.nextInt(nVertices);
                m = random.nextInt(nVertices);
            }
            w = random.nextInt(MAX_WEIGHT);
            // add an edge between them
            graph.insert(n, m, w);
        }

        return graph;
    }

    public static void main(String[] args) {
        WeightedGraph g = randomGraph(11);
        g.showGraph();
        g.minimumSpanningTree().showGraph();
    }
}
