import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    static RomanToArab romanToArab = new RomanToArab();
    static ConvertCalc convert = new ConvertCalc();
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;
    public static void main (String[] args) throws Exception {

        System.out.print("Введите выражение: ");
        String scan = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < scan.length(); i++) {
            under_char[i] = scan.charAt(i);

            switch (under_char[i]){
                case '+'-> operation = '+';
                case '-'-> operation = '-';
                case '*'-> operation = '*';
                case '/'-> operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = ConvertCalc.romanToNumber(stable00);
        num2 = ConvertCalc.romanToNumber(string03);

        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            String resultRoman = RomanToArab.convertIntegerToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        result = calculated(num1, num2, operation);
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }
        public static int calculated (int num1, int num2, char op) {
            int result = 0;
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Число должно быть от 1 до 10");

                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
            return result;
        }
    }


