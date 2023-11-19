import java.util.Scanner;

public class SemanticAnalysis 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Java declaration command: ");
        String javaCode = input.nextLine();

        System.out.println(analyzer(javaCode));

    }

    private static String analyzer(String line) 
    {
        String status;
        line = line.trim( );

        if (line.endsWith(";") == false)
        {
            return status = "Invalid input! Missing semicolon.";
        }

        line = line.substring(0, line.length() - 1);

        String[] lineParts = line.split("=");

        if (lineParts.length != 2)
        {
            status = "Invalid input! Line error.";
            return status;
        }

        String declaration = lineParts[0].trim( );
        String value = lineParts[1].trim( );
        
        String[] declarationParts = declaration.split(" ");

        if (declarationParts.length != 2)
        {
            status = "Invalid input! Declaration error.";
            return status;
        }

        String dataType = declarationParts[0];
        String variableName = declarationParts[1];

        if(dataType.equals("int"))
        {
            try 
            {
                Integer.parseInt(value);
                status = "Semantically correct!";
            } 
            catch (NumberFormatException e) 
            {
                status = "Semantically incorrect!";
            }
        }
        else if(dataType.equals("double"))
        {
            try 
            {
                Double.parseDouble(value);
                status = "Semantically correct!";
            } 
            catch (NumberFormatException e) 
            {
                status = "Semantically incorrect!";
            }
        }
        else if(dataType.equals("String"))
        {
            if(value.startsWith("\"") && value.endsWith("\""))
            {
                status = "Semantically correct!";
            }
            else
            {
                status = "Semantically incorrect!";
            }
        }
        else
        {
            status = "Invalid input!";
        }

        return status;
    }
}
