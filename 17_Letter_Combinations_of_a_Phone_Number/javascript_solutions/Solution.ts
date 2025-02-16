function letterCombinations(digits: string): string[] {
    if(digits.length == 0) return [];
    
    const keyboard = ["abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"];

    let result: string[]  = [""];
    for (let i = 0; i < digits.length; i++) {
        const letters: string = keyboard[digits.charCodeAt(i) - "2".charCodeAt(0)];
        const new_result: string[] = [];

        for (const letter of letters) {
            for (const combination of result) {
                new_result.push(combination + letter);
            }
        }
        result = new_result;
    }

    return result;
};