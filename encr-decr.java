import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose encryption method:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenère Cipher");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("Enter the text:");
        String text = input.nextLine();

        System.out.println("Choose an action:");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");
        int action = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.println("Enter the shift key:");
            int shift = input.nextInt();
            input.nextLine();

            if (action == 1) {
                String encryptedText = caesarEncrypt(text, shift);
                System.out.println("Encrypted Text: " + encryptedText);
            } else if (action == 2) {
                String decryptedText = caesarDecrypt(text, shift);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Invalid action.");
            }
        } else if (choice == 2) {
            System.out.println("Enter the key (word):");
            String key = input.nextLine();

            if (action == 1) {
                String encryptedText = vigenereEncrypt(text, key);
                System.out.println("Encrypted Text: " + encryptedText);
            } else if (action == 2) {
                String decryptedText = vigenereDecrypt(text, key);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Invalid action.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        input.close();
    }

    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String vigenereEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((c - base + shift) % 26 + base));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String vigenereDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((c - base - shift + 26) % 26 + base));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
