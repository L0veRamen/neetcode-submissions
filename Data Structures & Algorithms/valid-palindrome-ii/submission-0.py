class Solution:
    def isPalindrome(self, s: str) -> bool:
        return s == s[::-1]

    def validPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]:
                # delete s[l] or s[r]
                return self.isPalindrome(s[l + 1 : r + 1]) or self.isPalindrome(s[l:r])
            l += 1
            r -= 1
        return True
