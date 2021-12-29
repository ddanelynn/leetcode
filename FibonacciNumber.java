public class FibonacciNumber {
  public static int[] fib(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("n must be non-negative");
    } else {
        int[] numberArr = new int[n + 1];
        if (n == 0) {
          numberArr[0] = 0;
        } else if (n == 1) {
          numberArr[0] = 0;
          numberArr[1] = 1;
        } else {
          numberArr[0] = 0;
          numberArr[1] = 1;
          int accNumber = 0;
          for (int i = 2; i < n + 1; i++) {
            accNumber = numberArr[i - 2] + numberArr[i - 1];
            numberArr[i] = accNumber;
          }
        }
        
        return numberArr;
    }
  }

  public static void main(String[] args) {
    int[] result = fib(5);
    String resultStr = "[";
    for (int number: result) {
      resultStr += number + ", ";
    }
    resultStr = resultStr.substring(0, resultStr.length() - 2);
    resultStr += "]";
    System.out.println(resultStr);
  }
}
