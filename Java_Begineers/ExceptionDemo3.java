package Java_Begineers;

public class ExceptionDemo3 {
    public static  void  division(int dividend , int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        System.out.println("The result is: " + dividend / divisor);
    }
    public static void main(String[] args) {
        division(10,0);
        // The above line will throw an ArithmeticException because of division by zero
    }
}
