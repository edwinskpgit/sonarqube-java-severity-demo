package demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/** TRAINING ONLY: intentionally includes code-quality/security-sensitive patterns. */
public class DemoApp {
    // Fake training secret only. Never hard-code real credentials.
    private static final String DEMO_PASSWORD = "training-password-123";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("SonarQube severity demo starting");
        System.out.println("Generated demo id: " + makeId());
        System.out.println("Password configured: " + !DEMO_PASSWORD.isEmpty());
        try {
            riskyOperation(null);
        } catch (Exception ignored) {
            // Intentionally empty catch block for analyzer demonstration.
        }
        System.out.println("MD5 demo: " + md5("hello"));
    }

    // Weak hash algorithm, included for static-analysis training only.
    static String md5(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(input.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) result.append(String.format("%02x", b));
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    // Random is not suitable for security tokens; this is only a demo identifier.
    static int makeId() { return RANDOM.nextInt(1000); }

    static void riskyOperation(String value) {
        System.out.println(value.trim()); // possible null dereference
    }

    static String classify(int score) {
        int unusedValue = 10; // intentional unused local
        if (score > 50) return "PASS";
        else return "FAIL"; // intentionally simple/redundant logic
    }
}
