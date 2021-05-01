import os
import sys
from collections import Counter
from collections import deque

from functools import cmp_to_key
from typing import List

from queue import PriorityQueue
from bisect import bisect_left
from itertools import combinations, permutations

class Solution:

    def threeSumClosest(self, nums: List[int], target: int) -> int:

        nums.sort()

        ans = 123456789

        nums_len = len(nums)

        for i in range(nums_len-2):
            l,r = i+1, nums_len-1

            v = nums[i]

            while l < r:
                sum = nums[l] + nums[r] + v

                if target - sum >= 0 :
                    l += 1
                else:
                    r -= 1

                ans = sum if abs(sum-target) < abs(ans-target) else ans



        return ans


solution = Solution()

