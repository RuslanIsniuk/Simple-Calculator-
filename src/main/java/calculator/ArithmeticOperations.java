package calculator;

public class ArithmeticOperations {

    public String execute(String number1, String number2, String operation) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        String resultStr = "";

        if ("\"+\"".equals(operation)) {
            resultStr = Double.toString(num1 + num2);
        }

        if ("\"-\"".equals(operation)) {
            resultStr = Double.toString(num1 - num2);
        }

        if ("\"*\"".equals(operation)) {
            resultStr = Double.toString(num1 * num2);
        }

        if ("\"/\"".equals(operation)) {
            if (num2 != 0) {
                resultStr = Double.toString(num1 / num2);
            } else
                resultStr = "Infinity";

        }

        return resultStr;
    }
}
