package lexeme;

import java.util.Scanner;
import java.util.regex.*;

public class Lexeme 
{
    public static void main(String[] args) 
    {
        String[] dataTypes = {"int", "double", "char", "String"};
        String[] symbols = {"="};
        String[] delimiter = {";"};

        String identifierPattern = "[a-zA-Z_][a-zA-Z0-9_]*";
        String valuePattern = "\"[^\"]*\"|'[^']'|\\d+(\\.\\d+)?";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Source Language: ");
        String inputStatement = scanner.nextLine();

        Pattern pattern = Pattern.compile("(" + identifierPattern + "|" + valuePattern + "|.)");
        Matcher matcher = pattern.matcher(inputStatement);

        StringBuilder output = new StringBuilder("Output is: ");
        while (matcher.find()) 
        {
            String lexeme = matcher.group();
            if (isInArray(lexeme, dataTypes)) 
            {
                output.append("<data_type> ");
            } 
            else if (isInArray(lexeme, symbols)) 
            {
                output.append("<assignment_operator> ");
            } 
            else if (lexeme.matches(identifierPattern)) 
            {
                output.append("<identifier> ");
            } 
            else if (lexeme.matches(valuePattern)) 
            {
                output.append("<value> ");
            }
            else if (isInArray(lexeme, delimiter)) 
            {
                output.append("<delimiter> ");
            }
        }

        System.out.println(output.toString().trim());
    }

    private static boolean isInArray(String target, String[] array) 
    {
        for (String item : array) 
        {
            if (item.equals(target)) 
            {
                return true;
            }
        }
        return false;
    }
}
