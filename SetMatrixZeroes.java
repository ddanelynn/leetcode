import java.util.*;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // ArrayList<int[]> arr = new ArrayList<>();
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if (matrix[i][j] == 0) {
        //             arr.add(new int[] {i, j});
        //         }
        //     }
        // }

        // HashSet<Integer> row = new HashSet<>();
        // HashSet<Integer> col = new HashSet<>();
        // for (int[] coor: arr) {
        //     if (!row.contains(coor[0])) {
        //         row.add(coor[0]);
        //         for (int i = 0; i < matrix[0].length; i++) {
        //             matrix[coor[0]][i] = 0;
        //         }
        //     }

        //     if (!col.contains(coor[1])) {
        //         col.add(coor[1]);
        //         for (int i = 0; i < matrix.length; i++) {
        //             matrix[i][coor[1]] = 0;
        //         }
        //     }
        // }

        Set<Integer> setRows = new HashSet<Integer>();
        Set<Integer> setCols = new HashSet<Integer>();
        
        for (int i=0; i< matrix.length;i++) {
            for (int j=0; j<matrix[i].length;j++) {
                if (matrix[i][j]==0) {
                setRows.add(i);
                setCols.add(j);
                }                
            }
        }
        for (int i=0; i< matrix.length;i++) {
            for (int j=0; j<matrix[i].length;j++) {
                if (setRows.contains(i)||setCols.contains(j)) {
                    matrix[i][j]=0;
                }             
            }
        }
    }
}
