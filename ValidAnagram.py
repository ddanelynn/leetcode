class ValidAnagram(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dict = {}
        for c in s:
            if c in dict:
                dict[c]+=1
            else:
                dict[c] = 1
        
        for c in t:
            if c not in dict:
                return False
            elif dict[c] == 0:
                return False
            else:
                dict[c]-=1
        
        for key in dict:
            if dict[key] != 0:
                return False
        
        return True