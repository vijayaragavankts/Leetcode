
class Pair {
    int row;
    int col;
    int health;

    public Pair(int row, int col, int health) {
        this.row = row;
        this.col = col;
        this.health = health;
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

         Queue<Pair> queue = new LinkedList<>();
        if(grid.get(0).get(0) == 1 && health > 0){
            visited[0][0] = health-1;
            queue.offer(new Pair(0,0,health-1));
        }
        else{
            visited[0][0] = health;
            queue.offer(new Pair(0,0,health));
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            int currentHealth = current.health;

            if (row == m - 1 && col == n - 1 && currentHealth > 0) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int r = row + drow[i];
                int c = col + dcol[i];

                if (r >= 0 && r < m && c >= 0 && c < n) {
                    int newHealth = currentHealth - (grid.get(r).get(c) == 1 ? 1 : 0);

                    if (newHealth > 0 && (visited[r][c] == -1 || visited[r][c] < newHealth)) {
                        visited[r][c] = newHealth;
                        queue.offer(new Pair(r, c, newHealth));
                    }
                }
            }
        }

        return false;
    }
}
