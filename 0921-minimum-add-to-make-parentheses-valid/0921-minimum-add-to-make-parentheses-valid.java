class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // unmatched '(' so far
        int add = 0;    // '(' we must insert to match unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (open > 0) {
                open--;     // this ')' matches an earlier '('
            } else {
                add++;      // no '(' available, so insert one
            }
        }
        return add + open;  // inserted '(' plus '(' still unmatched (need ')')
    }
}