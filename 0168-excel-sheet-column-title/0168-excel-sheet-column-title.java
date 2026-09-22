class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            int s = (columnNumber-1)%26;
            sb.append((char)('A'+s));
            columnNumber = (columnNumber-1)/26;

        }
        return sb.reverse().toString();
    }
}