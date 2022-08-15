public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = new int[5][2];
        edges[0][0] = 1;
        edges[0][1] = 2;
        edges[1][0] = 2;
        edges[1][1] = 3;
        edges[2][0] = 3;
        edges[2][1] = 4;
        edges[3][0] = 1;
        edges[3][1] = 4;
        edges[4][0] = 1;
        edges[4][1] = 5;

        findRedundantConnection(edges);
    }

    public static int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int par[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];

            int lx = find(par, par[u]);
            int ly = find(par, par[v]);

            if (lx != ly) {
                par[lx] = ly;
            } else {
                return new int[] { u, v };
            }
        }
        return null;
    }

    public static int find(int par[], int x) {

        if (x == par[x]) {
            return x;
        }
        int temp = find(par, par[x]);
        par[x] = temp;
        return temp;
    }
}
