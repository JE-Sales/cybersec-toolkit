import java.util.Scanner;

public class PasswordStrengthChecker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int score = calculatePasswordStrength(password);
        String strength = interpretScore(score);

        System.out.println("\nPassword Strength: " + strength);
        printSuggestions(password);

        sc.close();
    }

    private static int calculatePasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()_+=<>?/{}~-].*")) score++;

        return score;
    }

    public static String interpretScore(int score) {
        return switch (score) {
            case 5 -> "Very Strong";
            case 4 -> "Strong";
            case 3 -> "Moderate";
            case 2 -> "Weak";
            default -> "Very Weak";
        };
    }

    public static void printSuggestions(String password) {
        System.out.println("\nSuggestions to improve your password:");
        if (password.length() < 8) System.out.println("- Increase the length (at least 8 characters).");
        if (!password.matches(".*[A-Z].*")) System.out.println("- Add uppercase letters.");
        if (!password.matches(".*[a-z].*")) System.out.println("- Add lowercase letters.");
        if (!password.matches(".*\\d.*")) System.out.println("- Add numbers.");
        if (!password.matches(".*[!@#$%^&*()_+=<>?/{}~-].*")) System.out.println("- Add special characters.");
    }

}