import sys

for line in sys.stdin:
    tokens = line.split(" ")
    # Fix: In Python we use len() function and array indexing with -1
    last_word_length = len(tokens[-1].strip())
    print(last_word_length)
