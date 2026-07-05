package Projects.RatInMaze;

import java.util.*;

class Sol1 {
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        
        traverse(maze, n, m, 0, 0, "", visited, result);
        Collections.sort(result);
        return result;
    }
    
    static void traverse(int[][] maze, int n, int m, int i, int j, 
    String path, boolean[][] visited, ArrayList<String> result) {
        
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (maze[i][j] != 1) {
            return;
        }
        if (i == n-1 && j == m-1) {
            result.add(path);
            return;
        }

        visited[i][j] = true;
        traverse(maze, n, m, i + 1, j, path + "D", visited, result);
        traverse(maze, n, m, i, j + 1, path + "R", visited, result);
        traverse(maze, n, m, i - 1, j, path + "U", visited, result);
        traverse(maze, n, m, i, j - 1, path + "L", visited, result);
        visited[i][j] = false;
    }
}