
class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length() / 2;
        for (int i = 1; i <= n; i++) {
            if (s.length() % i == 0) {
                int r = s.length() / i;
                String pattern = s.substring(0, i);
                StringBuilder check = new StringBuilder();
                for (int j = 0; j < r; j++) {
                    check.append(pattern);
                }
                if (check.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
