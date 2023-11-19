sentence = input("Enter sentence: ")
letter = input("Enter letter: ")
letter = letter.lower()
count = 0
for char in sentence:
char = char.lower()
if char == letter:
count += 1
print(f"The letter '{letter}' occurred {count} time/s.")
