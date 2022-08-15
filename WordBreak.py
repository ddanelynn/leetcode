
def wordBreak(s, wordDict):
    """
    :type s: str
    :type wordDict: List[str]
    :rtype: bool
    """
    
    dp = []
    for i in range(len(s) + 1):
        dp.append(False)

    dp[len(s)] = True
    
    for i in reversed(range(len(s))):
        for word in wordDict:
            if i + len(word) <= len(s) and s[i : i + len(word)] == word:
                dp[i] = dp[i + len(word)]
            if dp[i]:
                break
    # print(dp)
    return dp[0]

def main():
    wordBreak("catcatcatcatcatcatcatcatcatcatccc", ["cat","catcatcatccc"])

if __name__ == "__main__":
        main()