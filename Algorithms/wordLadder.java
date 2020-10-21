class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        Set<String> wordSet = new HashSet<>(wordList);      // for constant time retreval
        if (!wordSet.contains(endWord))     //call it a day if end word is not in wordList (condition 1)
            return 0;
        
        //time to implement some BFT to find the shortest transformation quickly
        
        Queue<String> q = new LinkedList<>();       //implement a queue as a LL
        q.offer(beginWord);     //insert begin word into queue
        int res = 0;     //initate some counter to No. of transfromations done on the word /(track level)
        
        
        while(!q.isEmpty()) {
            for(int k = q.size(); k > 0; --k) { //allow to get each word in the level
                String word = q.poll();
                if (word.equals(endWord))   //if true then we've gotten to finall destination
                    return res + 1;
                for (int i = 0; i < word.length(); ++i) {
                    char[] newWord = word.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord[i] = ch;
                        String s = new String(newWord);
                        if(wordSet.contains(s) && !s.equals(word)) {
                            q.offer(s);
                            wordSet.remove(s);
                        }
                    }
                }
            }
            ++res;
            
        }
        return 0;
    }
    
    
    /*
        Big O(l*n) where l is word.length & n == No. of words
    */
        
}
