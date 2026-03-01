import java.util.Random;

public class Main {
    public static void main(String[] args) {
       int [][] grid=griGenarator();
    }
    public static int [][] griGenarator(){
        Random rand = new Random();
        //n should be random number between 0 and 10
        int n= rand.nextInt(9)+1;
        while(n==1){
            n=rand.nextInt(9)+1;
        }
        //the grid has to be an n by n
        int [][] grid =new int [n][n];

        for (int row =0; row<grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                grid[row][col]=rand.nextInt(n-1)+1;
                System.out.print (grid[row][col]+" ");
            }
            System.out.println();
        }
        return grid;


    }
    public static boolean canReach(int[][]arr, int row,int col, boolean[] []visited, String[][] labels) {
        // Base case: out of bounds
        if (row < 0 || row >= arr.length || col < 0 || col >= arr.length) {
            return false;
        }
        // Base case: already visited
        if (visited[row][col]) {
            return false;
        }
        // Base case: reached the end
        if (row == arr.length - 1 && col == arr.length - 1) {
            labels[row][col] = "*";
            return true;
        }


        // Mark as visited
        visited[row][col] = true;


        int steps = arr[row][col];

        // Try jumping right or left
        // Moving Down
        labels[row][col] = "D";
        if (canReach(arr, row + steps, col, visited, labels)) {
            return true;
        }
        labels[row][col] = null; // erase - this direction didn't work

// Moving Up
        labels[row][col] = "U";
        if (canReach(arr, row - steps, col, visited, labels)) {
            return true;
        }
        labels[row][col] = null;

// Moving Right
        labels[row][col] = "R";
        if (canReach(arr, row, col + steps, visited, labels)) {
            return true;
        }
        labels[row][col] = null;

// Moving Left
        labels[row][col] = "L";
        if (canReach(arr, row, col - steps, visited, labels)) {
            return true;
        }
        labels[row][col] = null;

        // Backtrack - unmark if no path found from here
        visited[row][col] = false;
        return false;
    }
//    public boolean void pathFinder(int[][] grid, boolean[][] visited,String[][] labels, int row, int col,int[] pathLength){
//
//    }
}