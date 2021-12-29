public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] leftProduct = new int[nums.length];  
    int leftAccProduct = 1;
    for (int i = 0; i < nums.length; i++) {
      leftAccProduct *= nums[i];
      leftProduct[i] = leftAccProduct;
    }

    int[] rightProduct = new int[nums.length];  
    int rightAccProduct = 1;
    for (int i = nums.length - 1; i >=0; i--) {
      rightAccProduct *= nums[i];
      rightProduct[i] = rightAccProduct;
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i < 1) {
        result[i] = rightProduct[i + 1];
      } else if (i > nums.length - 2) {
        result[i] = leftProduct[i - 1];
      } else {
        result[i] = leftProduct[i - 1] * rightProduct[i + 1];
      }      
    }

    return result;
  }
}
