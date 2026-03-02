package com.grid.task3;

import java.util.Random;

    public class GridTraversal {

        /** Generates an n×n grid, n randomly chosen from 2..9 */
        public static int[][] griGenarator() {
            Random rand = new Random();
            int n = rand.nextInt(8) + 2;           // 2..9 (avoids n=1 edge case)
            return griGenarator(n);
        }

        /** Generates an n×n grid with values 1..(n-1) */
        public static int[][] griGenarator(int n) {
            Random rand = new Random();
            int[][] grid = new int[n][n];
            for (int row = 0; row < n; row++)
                for (int col = 0; col < n; col++)
                    grid[row][col] = rand.nextInt(n - 1) + 1;
            return grid;
        }

        /** Recursive path finder. Returns true if (0,0) -> (n-1,n-1) exists. */
        public static boolean canReach(int[][] arr, int row, int col,
                                       boolean[][] visited, String[][] labels) {
            if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length)
                return false;
            if (visited[row][col])
                return false;
            if (row == arr.length - 1 && col == arr[0].length - 1) {
                labels[row][col] = "*";
                return true;
            }

            visited[row][col] = true;
            int steps = arr[row][col];

            labels[row][col] = "D";
            if (canReach(arr, row + steps, col, visited, labels)) return true;
            labels[row][col] = null;

            labels[row][col] = "U";
            if (canReach(arr, row - steps, col, visited, labels)) return true;
            labels[row][col] = null;

            labels[row][col] = "R";
            if (canReach(arr, row, col + steps, visited, labels)) return true;
            labels[row][col] = null;

            labels[row][col] = "L";
            if (canReach(arr, row, col - steps, visited, labels)) return true;
            labels[row][col] = null;

            visited[row][col] = false;
            return false;
        }

        /** Prints the grid with path annotations and path length. */
        public static void printResult(int[][] grid, String[][] labels, boolean pathExists) {
            int pathLength = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (labels[row][col] != null) {
                        System.out.printf("%-4s", grid[row][col] + labels[row][col]);
                        if (!labels[row][col].equals("*"))
                            pathLength += grid[row][col];
                    } else {
                        System.out.printf("%-4s", grid[row][col] + " ");
                    }
                }
                System.out.println();
            }
            if (pathExists) {
                System.out.println("Path exists | Path length = " + pathLength);
            } else {
                System.out.println("No path exists.");
            }
            System.out.println();
        }

        /** Convenience: run and print a grid in one call. */
        public static void solveAndPrint(int[][] grid) {
            String[][] labels   = new String[grid.length][grid[0].length];
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            boolean found = canReach(grid, 0, 0, visited, labels);
            printResult(grid, labels, found);
        }
    }


