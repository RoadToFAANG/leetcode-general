class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.length && j < B.length) {
            if(intervalPairwise(A[i], B[j])!=null) res.add(intervalPairwise(A[i], B[j]));
            if(A[i][1] < B[j][1]) {
                i++;
            } else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
    
    public int[] intervalPairwise(int[] A, int[] B) {
        int[] pair = new int[2];
        if(A[1] < B[0] || A[0] > B[1]) return null;
        return new int[]{Math.max(A[0], B[0]), Math.min(A[1], B[1])};
    }
}