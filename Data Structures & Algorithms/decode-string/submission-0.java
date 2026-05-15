class Solution {
    private int i = 0; // global index shared across all recursive calls

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        while (i < s.length() && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                // Build the repeat count
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                i++; // skip '['
                String decoded = decodeString(s); // recurse inside brackets
                i++; // skip ']'

                // Append decoded string k times
                result.append(decoded.repeat(num));

            } else {
                // Regular letter
                result.append(s.charAt(i++));
            }
        }

        return result.toString();
    }
}