/**
 * The world is a 2d grid of alive/true cells and dead/false cells.
 */
public class World {
    private boolean[][] cells;

    public World(int width, int height) {
        cells = new boolean[width][height];
    }

    /**
     * Initialises the world with a grid / chromosome, placing it in the center of the world.
     * @param grid The 2D array which is the start state.
     */
    public void initialiseWorld(boolean[][] grid) {
        int gridWidth = grid.length;
        int gridHeight = grid[0].length;
        if (gridWidth > cells.length || gridHeight > cells[0].length) {
            throw new IllegalArgumentException("Grid dimensions too large");
        }

        int startX = (cells.length - gridWidth) / 2;
        int startY = (cells[0].length - gridHeight) / 2;

        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                cells[startX + x][startY + y] = grid[x][y];
            }
        }
    }

    private void setCell(int x, int y, boolean alive) {
        if (x >= 0 && x < cells.length && y >= 0 && y < cells[0].length) {
            cells[x][y] = alive;
        }
    }

    /**
     * Progresses the world by one step using conways game of life rules.
     */
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

    /**
     * Finds the number of alive neighbors for a given cell.
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     * @return The number of alive neighbors, min 0, max 8.
     */
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