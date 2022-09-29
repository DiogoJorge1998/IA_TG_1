package services;

import java.util.*;

public class BestFirst {
    protected Queue<State> abertos;
    private Map<Ilayout, State> fechados;
    private State actual;
    private Ilayout objective;

    public static class State {
        private Ilayout layout;
        private State father;
        private double g;

        public State(Ilayout l, State n) {
            layout = l;
            father = n;
            if (father != null)
                g = father.g + l.getG();
            else
                g = 0.0;
        }

        public String toString() {
            return layout.toString();
        }

        public double getG() {
            return this.g;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public boolean equals(Object o) {
            if (o == null)
                return false;
            if (this.getClass() != o.getClass())
                return false;
            State n = (State) o;
            return this.equals(n);
        }
    }

    final private List<State> sucessores(State n) {
        List<State> sucs = new ArrayList<>();
        List<Ilayout> children = n.layout.children();
        for (Ilayout e : children) {
            if (n.father == null || !e.equals(n.father.layout)) {
                State nn = new State(e, n);
                sucs.add(nn);
            }
        }
        return sucs;
    }

    final public Iterator<State> solve(Ilayout s, Ilayout goal) {
        objective = goal;
        abertos = new PriorityQueue<>(10,
                (s1, s2) -> (int) Math.signum(s1.getG() - s2.getG()));

        fechados = new HashMap<>();
        abertos.add(new State(s, null));
        List<State> sucs;

        try {
            while (true) {
                if (abertos.isEmpty()) return null;

                actual = abertos.poll(); // Poll retrieves and removes the head of the list

                if (actual.layout.isGoal(objective)) {
                    List<State> path = new ArrayList<>();
                    State temp = actual;
                    while (temp != null) {
                        path.add(temp);
                        temp = temp.father;
                    }
                    Collections.reverse(path);
                    return path.iterator();
                }
                else {
                    sucs = sucessores(actual);
                    fechados.put(actual.layout, actual);
                    for (State cpy : sucs) {
                        if (!fechados.containsKey(cpy.layout)) abertos.add(cpy);
                    }
                }
            }
        } catch (OutOfMemoryError error) {
            System.out.println("error");
            System.exit(-1);
        }
        return null;
    }
}
