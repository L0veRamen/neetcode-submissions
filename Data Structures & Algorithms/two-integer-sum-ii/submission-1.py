class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # for i in range(len(numbers)-1):
        #     for j in range(i+1,len(numbers)):
        #         if numbers[i] + numbers[j] == target:
        #             return[i+1, j+1]
        # return []        

        left, right = 0, len(numbers)-1
        while left < right:
            res = numbers[left] + numbers[right]
            if res == target:
                break
            elif res < target:
                left +=1
            else:
                right -=1

        return [left + 1, right + 1]