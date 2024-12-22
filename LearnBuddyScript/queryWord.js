// 单词列表
const wordList = ['working', 'walk', 'run', 'jump', 'swim'];

// 查询最大相似子串的词
function findMaxSimilarWord(query) {
  let maxSimilarity = 0;
  let maxSimilarWord = '';

  for (let i = 0; i < wordList.length; i++) {
    const word = wordList[i];
    const similarity = calculateSimilarity(query, word);

    if (similarity > maxSimilarity) {
      maxSimilarity = similarity;
      maxSimilarWord = word;
    }
  }

  return maxSimilarWord;
}

// 计算两个单词的最大相似子串长度
function calculateSimilarity(word1, word2) {
  const m = word1.length;
  const n = word2.length;
  const dp = [];

  for (let i = 0; i <= m; i++) {
    dp[i] = [];
    dp[i][0] = 0;
  }

  for (let j = 0; j <= n; j++) {
    dp[0][j] = 0;
  }

  let maxSimilarity = 0;

  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (word1[i - 1] === word2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
        maxSimilarity = Math.max(maxSimilarity, dp[i][j]);
      } else {
        dp[i][j] = 0;
      }
    }
  }

  return maxSimilarity;
}

// 测试
const queryWord = 'walking';
const maxSimilarWord = findMaxSimilarWord(queryWord);
console.log('Max similar word:', maxSimilarWord);
