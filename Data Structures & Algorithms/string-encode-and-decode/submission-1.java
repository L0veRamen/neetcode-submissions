class Solution {

    public String encode(List<String> strs) {
         // Encode: prefix each string with its length and '#'
        // ["Hello", "World"] -> "5#Hello5#World"
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            // find # that ends the length prefix
            int j = i;
            while(s.charAt(j) != '#'){
                j++;
            }
            // parse the length
            int len = Integer.parseInt(s.substring(i, j));

            //extract exavtly 'len' characters after #
            String word = s.substring(j + 1, j + len + 1);
            result.add(word);
            // move pointer to next word
            i = j+1+len;
        }
        return result;
    }
}
