class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0, one = 0;

        for (int s : students) {
            if (s == 0) zero++;
            else one++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zero == 0) break;
                zero--;
            } else {
                if (one == 0) break;
                one--;
            }
        }

        return zero + one;
    }
}