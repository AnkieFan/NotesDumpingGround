import java.util.*;

public class Search<E> {

    public void Search() {

    }

    public List<E> BFS(Graph<E> g, E startNode) {
        Queue<E> visited = new LinkedList<>();
        List<E> result = new ArrayList<>();

        visited.add(startNode);

        while (!visited.isEmpty()) {
            E current = visited.poll();

            if (!result.contains(current)) {
                result.add(current);
            }

            List<E> everyEdges = g.neighbors(current);
            for (int i = 0; i < everyEdges.size(); i++) {
                if(!result.contains(everyEdges.get(i)))
                    visited.add(g.neighbors(current).get(i));
            }
        }

        return result;
    }



}
