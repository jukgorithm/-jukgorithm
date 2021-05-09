class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int end = nums1.size(), n1 = nums1.size();
        int n2 = nums2.size();
        // 두 길이중 더 짧은것 사용
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int midLen = (n1 + n2 + 1) / 2;
 
        int l = 0;
        int r = end;
        
        // 이진탐색 실행
        while (l < r) {
            // 
            int posX = l + (r - l) / 2;
            int posY = midLen - posX;
            // posX 
            if (nums1[posX] < nums2[posY - 1])
                l = posX + 1;
            else
                r = posX;
        }
        
        int m1 = l;
        int m2 = midLen - l;
        
        int c1 = max(m1 <= 0 ? INT_MIN : nums1[m1 - 1], m2 <= 0 ? INT_MIN : nums2[m2 - 1]);
 
        if ((n1 + n2) % 2 == 1)
            return c1;    
        
        int c2 = min(m1 >= n1 ? INT_MAX : nums1[m1], m2 >= n2 ? INT_MAX : nums2[m2]);
                
        return (c1 + c2) * 0.5;
    }
};