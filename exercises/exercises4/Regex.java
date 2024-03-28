package exercises.exercises4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        // Regular expressions
        String[] regexPatterns = {
                "\\b[a-zA-Z]+\\s[a-zA-Z]+\\b", // First name, last name
                "\\d{3}-\\d{2}-\\d{4}", // Social Security Number (###-##-####)
                "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b", // Email
                "\\b(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/(19|20)\\d{2}\\b", // Date (MM/DD/YYYY)
                "\\b(https?://|www\\.)\\S+\\b", // URL
        };

        // Sample subject strings
        String[] subjectStrings = {
                "My name is Rachel Lai",
                "Rachel's SSN is 123-45-6789.",
                "My email is therachellai@gmail.com",
                "Today's date is 03/28/2024.",
                "Visit my website at https://www.therachellai.com",
        };

        for (String pattern : regexPatterns) {
            System.out.println("Testing pattern: " + pattern);
            Pattern p = Pattern.compile(pattern);
            for (String subject : subjectStrings) {
                Matcher m = p.matcher(subject);
                if (m.find()) {
                    System.out.println("Match found in: " + subject);
                } else {
                    System.out.println("No match found in: " + subject);
                }
            }
            System.out.println();
        }
    }
}
