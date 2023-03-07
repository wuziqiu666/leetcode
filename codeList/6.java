
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= 1) {
            return s;
        }
        int charInSection = 2 * (numRows - 1);
        int n = s.length();
        StringBuilder answer = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int index = row;
            while (index < n) {
                answer.append(s.charAt(index));
                if (row != 0 && row != numRows - 1) {
                    int charInBetween = charInSection - 2 * row;
                    int secondIndex = index + charInBetween;

                    if (secondIndex < n) {
                        answer.append(s.charAt(index));
                    }
                }
                index += charInSection;
            }
        }
        return answer.toString();

    }
}
