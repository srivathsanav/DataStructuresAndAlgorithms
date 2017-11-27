import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 6/21/2017.
 */
public class SearchMaze {

    private static List<Coordinate> searchMaze(List<List<COLOR>> coordinates, Coordinate s, Coordinate e) {
        List<Coordinate> paths = new ArrayList<>();
        paths.add(s);
        coordinates.get(s.x).set(s.y, COLOR.BLACK);
        if (!searchMazeHelper(coordinates, s, e, paths )) {
            paths.remove(paths.size() - 1);
        }
        return paths;
    }


    private static boolean searchMazeHelper(List<List<COLOR>> coordinates, Coordinate cur, Coordinate e, List<Coordinate> paths) {
        if (cur.equals(e)) {
            return true;
        }

        int[][] values = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

        for (int value[] : values) {
            Coordinate now = new Coordinate(cur.x+value[0], cur.y+value[1]);
            if (isFlexible(now, coordinates)) {
                coordinates.get(value[0]).set(value[1], COLOR.BLACK);
                paths.add(now);
                if (searchMazeHelper(coordinates, now, e, paths)) {
                    return true;
                }
                paths.remove(paths.size() -1 );
            }
            return false;
        }
        return false;
    }

    private static boolean isFlexible(Coordinate current, List<List<COLOR>>  maze) {
        if (current.x > 0 && current.x <= maze.size() && current.y > 0 && current.y <= maze.get(current.x).size()) {
            if (maze.get(current.x).get(current.y) == COLOR.WHITE) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }

    enum COLOR {
        WHITE, BLACK;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            return y == that.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public int getY() {

            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
