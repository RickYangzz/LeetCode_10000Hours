
```
case 1 : some ith and jth character matches in both string
case 2 : it doesn't matches

so we have two casses , lets us analyze them one by one 
case 1 : if some ith and jth character matches then we can reduce the ASCII sum if we include both ith and jth character in sequence, so we dont add their's ASCII values 
case 2 : ith and jth character doesn't matches , so we have 2 option for these
	option 1 : skip ith character assuming jth character might be useful later on , so we add ASCII of ith and recurr for rest 
	option 2 : skip jth character assuming ith matches somewhere late in string , same as option 1 for other string
```

```
if string_a[ ith ] EQUALS string_b [jth] // skip these as these will definately help in making string same , and help in reducing sum of ASCII
 sum = get_sum_for( string_a ith+1 , string_b jth+1)
 
if string_a[ ith ] NOT EQUALS string_b [jth] // then all minimum of all the three options 
option 1 : sum = ASCII of string_a[ith] + get_sum_for( string_a ith+1, string_b jth)  // assuming jth to be useful
option 2 : sum = ASCII of string_b[jth] + get_sum_for( string_a ith, string_b jth +1) // assuming ith to be useful

ans = min of ( option 1 , option 2 )
```

https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/solutions/642422/for-those-who-have-no-clue-step-by-step