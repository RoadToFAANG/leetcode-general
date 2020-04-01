class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int point = 0;
        for(int i: arr) {
            int x = i;
            int countOnes = 0;
            while(x > 0){
                countOnes = x % 2 == 1 ? countOnes + 1 : countOnes; 
                x /= 2;
            }
            ArrayList<Integer> list = map.getOrDefault(countOnes, new ArrayList<Integer>());
            list.add(i);
            map.put(countOnes, list);
        }
        for(int i: map.keySet()) {
            Collections.sort(map.get(i));
            
            for(int ele: map.get(i)) {
                System.out.println(ele);
                arr[point++] = ele;
            }
        }
        return arr;
    }
}