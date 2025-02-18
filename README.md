Project Report: Text Encryption and Decryption in Java
________________________________________
1. Project Overview This project implements a Java-based text encryption and decryption tool using two classical cryptographic algorithms: Caesar Cipher and Vigenère Cipher. The program allows users to enter a plaintext message and select an encryption or decryption method, specifying a shift key (for Caesar) or a keyword (for Vigenère). 
2. Design Choices 
The program was designed to be simple and user-friendly, featuring:
•	A command-line interface for user interaction.
•	Encryption and Decryption Methods:
o	The program provides separate methods for encryption (caesarEncrypt, vigenereEncrypt) and decryption (caesarDecrypt, vigenereDecrypt).
o	Each method ensures that uppercase and lowercase characters are handled while maintaining non-alphabetic symbols.
o	The use of helper methods improves readability and maintainability.
•	If-Else Conditions in Main Code
o	Used to determine the encryption or decryption method (Caesar or Vigenère).
o	Further checks ensure whether the operation is encryption or decryption.
o	Ensures valid inputs and handles errors by displaying messages such as:
o	System.out.println("Invalid action.");

3. Algorithms & Data Structures
Caesar Cipher:
•	Uses a fixed shift value to substitute each letter with another letter in the alphabet.
•	Implemented using a loop that shifts characters within the alphabet range.
Vigenère Cipher:
•	Uses a keyword to shift letters, where each letter in the key determines the shift for corresponding letters in the plaintext.
•	Implemented using a looping mechanism that iterates through both text and key in a cyclic manner.

4. Code Breakdown: 
•	public static String encrypt(String text, int shift) { 
          StringBuilder result = new StringBuilder(); //
o	Use StringBuilder for efficient string manipulation 
o	Creates a StringBuilder to store the encrypted result (better performance than String concatenation).

   Caesar Cipher Processing:

•	for (char c : text.toCharArray()) {}
o	Converts the string into an array of characters and iterates through each character.:
•	if (Character.isLetter(c)) {}
o	Checks if the current character c is a letter (ignores spaces, numbers, and punctuation:
•	if (Character.isLetter(c)) {}
o	Checks if the current character c is a letter (ignores spaces, numbers, and punctuation:
•	char base = Character.isUpperCase(c) ? 'A' : 'a';
o	Determines the base ASCII value: o If c is an uppercase letter (A-Z), set base = 'A' (ASCII 65). o If c is a lowercase letter (a-z), set base = 'a' (ASCII 97):
•	result.append((char) ((c - base + shift) % 26 + base)); 
o	(c - base) shifts the letter to index 0-25 (A=0, B=1, ..., Z=25).
o	+ shift applies the shift value. 
o	 % 26 ensures the letter wraps around (so 'z' → 'a' instead of exceeding 'z'). 
o	+ base converts it back to the original ASCII range. 
o	 append() adds the encrypted character to the result.
•	result.append(c);
o	Skips non-alphabetic characters while preserving them.
•	return result.toString(); 
o	 Converts StringBuilder back to a regular String and returns the encrypted text.
•	For decryption we use the same code:  ((char) ((c - base - shift) % 26 + base)); but subtract shift 

  Vigenère Cipher Processing:

•	key = key.toLowerCase();
•	The key is always converted to lowercase (key.toLowerCase()), so shift values always range from 0 to 25. 
•	int shift = key.charAt(keyIndex % key.length()) - 'a'; 
o	is used in the Vigenère cipher to determine the shift value for each letter in the text based on the corresponding letter in the key.
•	 key.charAt(keyIndex % key.length())
o	This selects a character from the key. 
o	Since keyIndex increments for each letter in the text, this ensures we cycle through the key. 
o	% key.length() ensures that if the text is longer than the key, the key repeats cyclically. 
•	- 'a' (Extracting the Shift Value) 
o	This converts the character (a letter from the key) into a numerical shift value: In Java, characters have ASCII values
o	Uses keyIndex to track position in the key while iterating through the text. 
•	Encrypts using (c - base + shift) % 26 + base and decrypts using (c - base - shift + 26) % 26 + base. 
•	The reason we add 26 in the decryption formula:
((c - base – shift+26) % 26 + base)); 
is to ensure the result remains non-negative before applying the modulus operation (% 26).
•	result.append(c);
o	Skips non-alphabetic characters while preserving them.



