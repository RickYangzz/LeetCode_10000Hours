class Solution:
    def trans(self , s: str, n: int) -> str:
        stack = []
        word = ""
        for i in range(len(s)):
            letter = s[i]
            if letter == " ":
                if word:
                    stack.append(word)
                    word=""
                stack.append(letter)
            else:
                word += self.convertCase(letter)
            
        if len(word):
            stack.append(word)

        result = ""
        while len(stack):
            result += stack.pop()
        
        return result

    # 将大写转化为小写，将小写转化为大写
    def convertCase(self, letter: str):
        if letter.isupper():
            return letter.lower()
        elif letter.islower():
            return letter.upper()
        else:
            return letter
