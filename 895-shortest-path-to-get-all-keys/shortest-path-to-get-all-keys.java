class Pair {
    int row, col, keys;
    public Pair(int row, int col, int keys) {
        this.row = row;
        this.col = col;
        this.keys = keys;
    }
}

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int totalKeys = 0;
        int startRow = 0, startCol = 0;
        
        // Count total keys and find start position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        // Direction vectors for BFS
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        // BFS queue
        Queue<Pair> q = new LinkedList<>();
        // Visited array, storing (row, col, keyState)
        boolean[][][] visited = new boolean[m][n][1 << totalKeys];
        
        // Initial state (starting point, 0 keys collected)
        q.offer(new Pair(startRow, startCol, 0));
        visited[startRow][startCol][0] = true;
        
        int steps = 0;
        int finalKeyState = (1 << totalKeys) - 1;  // All keys collected when all bits are 1
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                int r = current.row;
                int c = current.col;
                int keys = current.keys;
                
                // If all keys are collected, return the number of steps
                if (keys == finalKeyState) {
                    return steps;
                }
                
                // Explore 4 possible directions
                for (int j = 0; j < 4; j++) {
                    int newRow = r + drow[j];
                    int newCol = c + dcol[j];
                    
                    // Check boundaries
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        char ch = grid[newRow].charAt(newCol);
                        
                        // If it's a wall, skip
                        if (ch == '#') continue;
                        
                        // New key state after moving
                        int newKeys = keys;
                        
                        // If it's a key, pick it up
                        if (ch >= 'a' && ch <= 'f') {
                            newKeys |= (1 << (ch - 'a'));
                        }
                        
                        // If it's a lock, check if we have the corresponding key
                        if (ch >= 'A' && ch <= 'F' && (keys & (1 << (ch - 'A'))) == 0) {
                            continue;
                        }
                        
                        // If this state (newRow, newCol, newKeys) has not been visited, add to queue
                        if (!visited[newRow][newCol][newKeys]) {
                            visited[newRow][newCol][newKeys] = true;
                            q.offer(new Pair(newRow, newCol, newKeys));
                        }
                    }
                }
            }
            steps++;
        }
        
        // If we exhaust the queue without finding all keys, return -1
        return -1;
    }
}
