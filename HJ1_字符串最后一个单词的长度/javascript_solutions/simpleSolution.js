const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin
});
rl.on('line', (line) => {
    const tokens = line.split(' ');
    console.log(tokens[tokens.length - 1].length)
})