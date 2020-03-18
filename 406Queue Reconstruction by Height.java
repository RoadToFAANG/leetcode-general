// 406. Queue Reconstruction by Height

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr2[0] - arr1[0];
            }
        });
        
        
        List<int[]> res = new LinkedList<>();
        
        for(int[] i: people) {
            res.add(i[1], i);
        }
        
        int length = people.length;
        
        return res.toArray(new int[length][2]);
    }
}