public class Main {
    public static void main(String[] args) {
        String inputText = "Hello World! e-mail: test@gmail.com";
        String password = "TestPassword@1123";

        System.out.println("Before: " + inputText);

        String result = processText(inputText);

        System.out.println("After: " + result);

        System.out.println("Result: " + checkPassword(password));
    }

    public static String processText(String inputText) {
        StringBuilder result = new StringBuilder();
        boolean lastSpace = false;

        for (char c : inputText.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(c);
                lastSpace = false;
            } else if (Character.isWhitespace(c)) {
                result.append(" ");
                lastSpace = true;
            }
        }

        return result.toString();
    }

    private static boolean checkPassword(String password) {
        StringBuilder result = new StringBuilder();

        String special = "!@#$%^&*()-_+=<>?/[]{}|";

        boolean upperLatter = false;
        boolean lowerLatter = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperLatter = true;
            }

            if (Character.isLowerCase(c)) {
                lowerLatter = true;
            }

            if (Character.isDigit(c)) {
                hasNumber = true;
            }

            if (special.contains(String.valueOf(c))) {
                hasSpecial = true;
            }
        }

        if (!upperLatter || !lowerLatter || !hasNumber || !hasSpecial) {
            return false;
        }

        return true;
    }
}
