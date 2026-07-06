class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        m = n * 2
        res = []
        path = [""] * m  # []

        def dfs(i: int, open: int) -> None:
            if i == m:
                res.append("".join(path))
                return
            #  choose '('
            if open < n:
                path[i] = "("
                dfs(i + 1, open + 1)
            # not choose '(' = choose ')'
            if i - open < open:
                path[i] = ")"
                dfs(i + 1, open)

        dfs(0, 0)
        return res
