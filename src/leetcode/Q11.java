package leetcode;

public class Q11 {
    public static void main(String[] args) {
        int [] height = {4,4,4,4};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;

        while (left<right){
            System.out.println("1 left : "+left+" right: "+right);
            int temp= Math.min(height[left],height[right])*(right-left);
            System.out.println("2 temp : "+temp+" left : "+left+" height[left] : " +height[left]+" height[right]: "+height[right]+" right: "+right);
            maxArea = Math.max(maxArea,temp);

            if(height[left] < height[right]){
                System.out.println("2 left : "+left+" right: "+right);
                left++;
            }
            else {
                System.out.println("3 left : "+left+" right: "+right);
                right--;
            }
            System.out.println("4 left : "+left+" right: "+right);
        }
        return maxArea;
    }
}
