/**
 * The world is a 2d grid of alive/true cells and dead/false cells.
 */
public class World {
    private boolean[][] cells;

    public World(int width, int height) {
        cells = new boolean[width][height];
    }


    public void timeStep() {
        boolean[][] newCells = new boolean[cells.length][cells[0].length];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[0].length; y++) {
                int neighborCount = getNeighborCount(x, y);
                if (cells[x][y]) {
                    newCells[x][y] = neighborCount >= 2 && neighborCount <= 3;
                } else {
                    newCells[x][y] = neighborCount == 3;
                }
            }
        }
        cells = newCells;
    }

    private int getNeighborCount(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int neighborX = x + i;
                int neighborY = y + j;
                if (neighborX >= 0 && neighborX < cells.length && neighborY >= 0 && neighborY < cells[0].length) {
                    if (cells[neighborX][neighborY]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}