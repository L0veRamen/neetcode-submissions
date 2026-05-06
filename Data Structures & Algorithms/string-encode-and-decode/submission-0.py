class Solution:

    """
    Length Prefix Approach - RECOMMENDED
    Format: "4#neet4#code4#love3#you"
    Each string is prefixed with its length followed by '#'
    """
    
    def encode(self, strs: List[str]) -> str:
        """Encode list of strings using length prefix"""
        result = ""
        for s in strs:
            # Format: length + '#' + string
            result += str(len(s)) + "#" + s
        return result
    
    def decode(self, s: str) -> List[str]:
        """Decode string back to list using length prefix"""
        result = []
        i = 0
        
        while i < len(s):
            # Find the '#' delimiter
            delimiter_pos = s.find('#', i)
            # Extract length
            length = int(s[i:delimiter_pos])
            # Extract the actual string using the length
            start = delimiter_pos + 1
            result.append(s[start:start + length])
            # Move to next string
            i = start + length
            
        return result
