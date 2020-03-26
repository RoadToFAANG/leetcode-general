import java.util.HashSet;
import java.util.List;
import java.util.Set;

// time complex O(2^n) space O(n)
// method dfs and set to check unique
class Solution {
    int res = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;
        dfs(arr, 0, "");
        return res;
    }

    public void dfs(List<String> arr, int index, String str) {
        if (isUniqueString(str)) {
            res = Math.max(res, str.length());
        }
        if (index == arr.size() || !isUniqueString(str))
            return;
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, str + arr.get(i));
        }
    }

    public boolean isUniqueString(String str) {
        Set<Character> set = new HashSet();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}