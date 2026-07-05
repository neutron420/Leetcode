import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] student, int[] cookie) {
        Arrays.sort(student);
        Arrays.sort(cookie);
        int i = 0;
        int j = 0;
        while (i < student.length && j < cookie.length) {
            if (cookie[j] >= student[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}