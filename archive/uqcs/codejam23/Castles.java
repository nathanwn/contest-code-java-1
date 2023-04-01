package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.*;

public class Castles {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int numCastles = in.nextInt();
        String[] builders = new String[numCastles];
        int[] buildingScore = new int[numCastles];
        for (int i = 0; i < numCastles; i++) {
            builders[i] = in.next();
        }
        for (int i = 0; i < numCastles; i++) {
            buildingScore[i] = in.nextInt();
        }
        HashMap<Character, Builder> builderMap = new HashMap<>();
        for (String bs : builders) {
            for (char b : bs.toCharArray()) {
                if (!builderMap.containsKey(b)) {
                    builderMap.put(b, new Builder(b));
                }
            }
        }
        for (int i = 0; i < numCastles; i++) {
            for (char c : builders[i].toCharArray()) {
                builderMap.get(c).score.add(buildingScore[i]);
            }
        }
        for (char c : builderMap.keySet()) {
            Collections.sort(builderMap.get(c).score);
        }

        ArrayList<Builder> builderList = new ArrayList<>();
        for (char c : builderMap.keySet()) {
            builderList.add(builderMap.get(c));
        }
        Collections.sort(builderList);

        out.println(builderList.get(0).c);
    }

    class Builder implements Comparable<Builder> {
        char c;
        ArrayList<Integer> score;

        public Builder(char c) {
            this.c = c;
            this.score = new ArrayList<>();
        }

        @Override
        public int compareTo(Builder other) {
            for (int i = 0; i < score.size(); i++) {
                if (!score.get(i).equals(other.score.get(i))) {
                    return Integer.compare(other.score.get(i), score.get(i));
                }
            }
            return 0;
        }
    }
}
