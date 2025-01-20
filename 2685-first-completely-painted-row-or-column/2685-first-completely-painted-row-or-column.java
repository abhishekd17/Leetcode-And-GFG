class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int x = arr.length;
        int n = mat.length;
        int m = mat[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        int freq[][] = new int[m * n + 1][3];
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < m ; c++){
                freq[mat[r][c]][0] = mat[r][c];
                freq[mat[r][c]][1] = r;
                freq[mat[r][c]][2] = c;
            }
        }

        for(int k = 0 ; k < x ; k++){
            row[freq[arr[k]][1]]++;
            col[freq[arr[k]][2]]++;

            if(row[freq[arr[k]][1]] == m || col[freq[arr[k]][2]] == n) return k;
        }
        return -1;
    }
}


// brute force
/*
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int x = arr.length;
        int n = mat.length;
        int m = mat[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for(int i = 0 ; i < x ; i++){
            for(int r = 0 ; r < n ; r++){
                for(int c = 0 ; c < m ; c++){
                    if(arr[i] == mat[r][c]){
                        row[r]++;
                        col[c]++;
                    }
                }
            }

            for(int k = 0 ; k < n ; k++){
                if(row[k] == m) return i;
            }

            for(int k = 0 ; k < m ; k++){
                if(col[k] == n ) return i;
            }
        }
        return -1;
    }
} */