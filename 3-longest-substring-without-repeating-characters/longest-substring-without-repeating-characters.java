class Solution {
    public int lengthOfLongestSubstring(String s) {

//Bibhav Mani Rai
      // Edge case validation
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        
        // The Hashtable concept: mapping Characters to their latest Index
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the map contains the character, it means we MIGHT have a duplicate inside our window
            if (charIndexMap.containsKey(currentChar)) {
                
                // LEAD LEVEL TRICK: We use Math.max to guarantee the 'left' pointer 
                // ONLY moves forward. It prevents the window from expanding backwards 
                // if we find a duplicate that is already outside our current window.
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the map with the character's most recent index
            charIndexMap.put(currentChar, right);

            // Calculate the current window size and update the maximum
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}