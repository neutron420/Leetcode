class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp =new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p, dp);
    }
    private boolean solve(int stringIndex,int patternIndex,String s, String p,Boolean[][] dp) {

        if (stringIndex == s.length()
                && patternIndex == p.length()) {

            return true;
        }

        if (patternIndex == p.length()) {
            return false;
        }

        if (dp[stringIndex][patternIndex] != null) {
            return dp[stringIndex][patternIndex];
        }

        if (stringIndex == s.length()) {
            int currentPattern = patternIndex;
            while (currentPattern + 1 < p.length()
                    && p.charAt(currentPattern + 1) == '*') {
                currentPattern += 2;
            }
            return dp[stringIndex][patternIndex] =
                    currentPattern == p.length();
        }
        boolean currentMatches = s.charAt(stringIndex) == p.charAt(patternIndex) || p.charAt(patternIndex) == '.';
        boolean answer;

        if (patternIndex + 1 < p.length() && p.charAt(patternIndex + 1) == '*') {
            boolean skipPattern =solve(stringIndex, patternIndex + 2, s, p, dp  );

            boolean usePattern = currentMatches && solve( stringIndex + 1,  patternIndex, s, p, dp );
            answer = skipPattern|| usePattern;

        } else {
            answer = currentMatches &&
            solve( stringIndex + 1, patternIndex + 1, s, p, dp);
        }
          return dp[stringIndex][patternIndex] =
                answer;
    }
}