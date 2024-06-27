function findSubstringIndices(str, substring) {
  if (!substring.includes('_')) {
    const start = String(str).indexOf(substring);

    const result = [];
    for (let index = 0; index < substring.length; index++) {
      result.push(index + start);
    }

    return result;
  }

  const indices = [];
  const m = str.length;
  const n = substring.length;
  const dp = [];

  for (let i = 0; i <= m; i++) {
    dp[i] = [];
    for (let j = 0; j <= n; j++) {
      dp[i][j] = false;
    }
  }

  dp[0][0] = true;

  for (let i = 1; i <= n; i++) {
    if (substring[i - 1] === '_') {
      dp[0][i] = dp[0][i - 1];
    }
  }

  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (substring[j - 1] === str[i - 1]) {
        dp[i][j] = dp[i - 1][j - 1];
      } else if (substring[j - 1] === '_') {
        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
      }
    }
  }

  let i = m,
    j = n;
  while (i > 0 && j > 0) {
    if (substring[j - 1] === str[i - 1]) {
      indices.unshift(i - 1);
      i--;
      j--;
    } else if (substring[j - 1] === '_') {
      while (i > 0 && dp[i][j - 1]) {
        indices.unshift(i - 1);
        i--;
      }
      j--;
    } else {
      i--;
    }
  }

  return indices;
}

// 测试
const inputString = 'like';
const inputSubstring = 'i_e';
const indices = findSubstringIndices(inputString, inputSubstring);
console.log(indices); // 输出: [1, 3]

const inputString2 = 'creer';
const inputSubstring2 = 'eer';
const indices2 = findSubstringIndices(inputString2, inputSubstring2);
console.log(indices2); // 输出: [2, 3, 4]

const inputString3 = 'auguest';
const inputSubstring3 = 'au';
const indices3 = findSubstringIndices(inputString3, inputSubstring3);
console.log(indices3); // 输出: [0, 1]

// https://leetcode.cn/problems/wildcard-matching/description/
