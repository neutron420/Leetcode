class Solution {
  public int countVowelSubstrings(String word) {
    int n = word.length();
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!isVowel(word.charAt(i))) continue;

      int[] freq = new int[5];
      int unique = 0;

      for (int j = i; j < n; j++) {
        char c = word.charAt(j);
        if (!isVowel(c)) break;

        int idx = "aeiou".indexOf(c);
        if (freq[idx] == 0) unique++;
        freq[idx]++;

        if (unique == 5) count++;
      }
    }
    return count;
  }

  private boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
  }
}
