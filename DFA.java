package dfa;
import java.util.*;

public class DFA 
{
	public static void main (String[] args)
	{
		System.out.print("Input string (1's and 0's only): ");
		String state = "q0";
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		for(int x = 0; x < input.length(); x++)
		{
			if (state.equals("q0") && input.charAt(x) == '0')
			{
				state = "q1";
			}
			else if (state.equals("q0") && input.charAt(x) == '1')
			{
				state = "q0";
			}
			else if (state.equals("q1") && input.charAt(x) == '0')
			{
				state = "q1";
			}
			else if (state.equals("q1") && input.charAt(x) == '1')
			{
				state = "q2";
			}
			else if (state.equals("q2") && input.charAt(x) == '0')
			{
				state = "q1";
			}
			else if (state.equals("q2") && input.charAt(x) == '1')
			{
				state = "q0";
			}
			else
			{
				System.out.println("Invalid input. Restart the automaton.");
				state = "no";
				break;
			}
		}
		
		if (state == "q2" && state != "no")
		{
			System.out.println ("Accepted!");
		}
		else if (state == "no")
		{
		}
		else
		{
			System.out.println ("Not accepted...");
		}
			
	}
}
