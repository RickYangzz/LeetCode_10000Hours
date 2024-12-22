const rl = require("readline").createInterface({ input: process.stdin });
var iter = rl[Symbol.asyncIterator]();
const readline = async () => (await iter.next()).value;

void async function () {
    line = await readline()
    const tokens = line.split(' ');
    const last_word_length = tokens[tokens.length-1].length;
    console.log(last_word_length);
    return last_word_length;
}()
