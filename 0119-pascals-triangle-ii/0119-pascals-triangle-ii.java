class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        long value = 1;

        ans.add(1);

        for (int i = 0; i < rowIndex; i++) {

            value = value * (rowIndex - i) / (i + 1);

            ans.add((int) value);
        }

        return ans;
    }
}