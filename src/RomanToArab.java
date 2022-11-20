public class RomanToArab {
    static int last = 2000;
    static int[] numbers = {1, 4, 5, 9, 10, 50, 100, 500, 1000};
    static String[] letters = {"I", "IV", "V", "IX", "X", "L", "C", "D", "M"};

    static String convertIntegerToRoman ( int number){
        StringBuilder romanValue = new StringBuilder();
        int N = number;
        while (N > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (N < numbers[i]) {
                    N -= numbers[i - 1];
                    romanValue.append(letters[i - 1]);
                    break;
                }
            }
        }
        return romanValue.toString();
    }
}
