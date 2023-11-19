package palindrome;

import java.util.Scanner;

public class PalindromeChecker 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter word/phrase: ");
		String wordphrase = input.nextLine();
		
		if (isPalindrome(wordphrase))
		{
			System.out.println ("\n" + wordphrase + " is a palindrome!");
		}
		else
		{
			System.out.println ("\n" + wordphrase + " is NOT a palindrome.");
		}
		
		input.close();
	}
	
	public static boolean isPalindrome(String wordphrase)
	{
		wordphrase = wordphrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		int left = 0;
		int right = wordphrase.length() - 1;
		
		while (left < right)
		{
			if (wordphrase.charAt(left) != wordphrase.charAt(right))
			{
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
}
