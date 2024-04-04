public class Main {
    public static int[][] grid = {
    {9, 0, 5, 0, 1, 0, 8, 0, 7},
    {0, 2, 0, 7, 9, 0, 1, 3, 0},
    {3, 0, 0, 6, 2, 0, 0, 0, 0},
    {0, 4, 1, 0, 0, 0, 7, 0, 8},
    {0, 0, 3, 0, 0, 4, 2, 0, 5},
    {8, 0, 0, 0, 5, 9, 0, 0, 3},
    {2, 0, 0, 9, 0, 0, 0, 8, 0},
    {1, 3, 4, 0, 0, 6, 0, 7, 0},
    {0, 8, 0, 2, 0, 1, 5, 6, 0}
  };

  public static void printGrid() {
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        System.out.print(grid[row][col] + " ");
      }
      System.out.println();
    }
  }

  public static boolean possible(int row, int column, int newValue) {
    //checks for row
    for (int i = 0; i < grid[0].length; i++) {
      if (newValue == grid[row][i]) return false;
    }
    //checks for column
    for (int i = 0; i < grid.length; i++) {
      if (newValue == grid[i][column]) return false;
    }
    //checks for square
    for (int r = 3*(row/3); r < 3*(row/3) + 3; r++) {
      for (int c = 3*(column/3); c < 3*(column/3) + 3; c++) {
        if (newValue == grid[r][c]) return false;
      }
  }
    return true;
  }

  public static boolean solve() {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        // for each item in the grid
        if (grid[r][c] == 0) {
          for (int i = 1; i < 10; i++) {
            if (possible(r, c, i)) {
              System.out.println("found a fitting number");
              grid[r][c] = i;
              if (solve()) {
                return true;
              } else {
                grid[r][c] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }


  public static void main(String[] args) {

    if (solve()) {
      printGrid();
    }
  }
}
