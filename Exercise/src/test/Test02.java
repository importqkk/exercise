package test;
import java.util.Random;

public class Test02 {
    
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*?=+_-";
    
    public static void main(String[] args) {
            String password = "";
            boolean hasLowerCase = false;
            boolean hasUpperCase = false;
            boolean hasNumber = false;
            boolean hasSpecialChar = false;
            
            while (!(hasLowerCase && hasUpperCase && hasNumber && hasSpecialChar)) {
                password = "";
                hasLowerCase = false;
                hasUpperCase = false;
                hasNumber = false;
                hasSpecialChar = false;
                
                Random random = new Random();
                int length = random.nextInt(9) + 8;
                
                for (int i = 0; i < length; i++) {
                    String charSet = "";
                    int charType = random.nextInt(4);
                    switch (charType) {
                        case 0:
                            charSet = LOWER_CASE;
                            hasLowerCase = true;
                            break;
                        case 1:
                            charSet = UPPER_CASE;
                            hasUpperCase = true;
                            break;
                        case 2:
                            charSet = NUMBERS;
                            hasNumber = true;
                            break;
                        case 3:
                            charSet = SPECIAL_CHARS;
                            hasSpecialChar = true;
                            break;
                    }
                    int charIndex = random.nextInt(charSet.length());
                    password += charSet.charAt(charIndex);
                    
                }
            
        }
        System.out.println(password);
	}
    
}

