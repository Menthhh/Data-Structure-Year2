package code;
import java.util.regex.Pattern;


public class MyRPN_651610 {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) 
    {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        MyStackA_651610 stack = new MyStackA_651610();
        // MyStackL stack = new MyStackL();
        String[] tokens = rpn.split(" ");
        for (String t : tokens) {
            if (isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            } else {
                if (t.equals("+")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                } else if (t.equals("-")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                } else if (t.equals("*")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);
                } else if (t.equals("/")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}