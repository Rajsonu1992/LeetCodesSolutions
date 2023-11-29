package temp.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCodes {



//    14. Longest Common Prefix
    /*Input: strs = ["flower","flow","flight"]
    Output: "fl"*/

    public String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return stringBuilder.toString();
            }
            stringBuilder.append(first.charAt(i));
        }
        return stringBuilder.toString();
    }

//    20. Valid Parentheses
//    Input: s = "()"
//    Output: true
    public boolean isValid(String s) {
        //Using stack, we can achieve the solutions
        // Iterate the char and push to stack if only having opening brackets
        // next iterate pop it and match with next element.
        // if same pop it and validate if stack is empty return true else keep push the stask until gets empty.
        Stack stack = new Stack();
        if (s.length() == 0) return false;
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }

            else if (stack.isEmpty()) {
                return false;
            }

            else if (stack.peek().equals('(') && s.charAt(i) == ')' || stack.peek().equals('{') && s.charAt(i) == '}' || stack.peek().equals('[') && s.charAt(i) == ']') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        //Using stack, we can achieve the solutions
        // Iterate the char and push to stack if only having opening brackets
        // next iterate pop it and match with next element.
        // if same pop it and validate if stack is empty return true else keep push the stask until gets empty.

        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

//    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//    Return k.
//    Input: nums = [1,1,2]
//    Output: 2, nums = [1,2,_]
    public int removeDuplicates(int[] nums) {

        int j = 1;
        if (nums.length < 1) return 0;

        for (int i = 1 ; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }


//    Input: nums = [3,2,2,3], val = 3
//    Output: 2, nums = [2,2,_,_]
//    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//    It does not matter what you leave beyond the returned k (hence they are underscores).
    public int removeElement(int[] nums, int val) {

        // iterate over the elements and match if an element is not equal don't make change and insert the element as it is.
        // if equal then increase i and update by j index.
        // then return the i value.

        int index = 0;

        //O(n) time complex
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }


//    Input: haystack = "sadbutsad", needle = "sad"
//    Output: 0
//    Explanation: "sad" occurs at index 0 and 6.
//    The first occurrence is at index 0, so we return 0.

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

//    Input: nums = [1,3,6], target = 5
//    Output: 2

    public int searchInsert(int[] nums, int target) {
        // divide an array in tree and use first and last pointer.
        // divide by 2 for an array and if target is less than last position then again divide by 2. repeat until the condition false.

//        O(n) - time complex.

        int low = 0;
        int high = nums.length - 1;

        while (high > low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

//    Input: s = "Hello World"
//    Output: 5
//    Explanation: The last word is "World" with length 5.

    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

//    Input: digits = [1,2,3]
//    Output: [1,2,4]
//    Explanation: The array represents the integer 123.
//    Incrementing by one gives 123 + 1 = 124.
//    Thus, the result should be [1,2,4].

    public int[] plusOne(int[] digits) {
        // if last index value is not 9 then increment by 1 and return it.
        // if last index value is 9 then change to 0 and iterate to previous element check if element is 9 else increament by 1 and return it.
        // keep iterate till increment by 1.

        for (int i = digits.length - 1; i >= 0; i++) {
            if (digits[i] < 9) {
                digits[i]++;
               return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

//
//    Input: a = "11", b = "1"
//    Output: "100"
    public String addBinary(String a, String b) {
        String res = "";
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int sum = 0;
        // convert binary to int and make addition.
        // then convert int to binary string.
//        long aa = Long.parseLong(a, 2);
//        long bb = Long.parseLong(b, 2);
//        long c = aa+bb;
//
//        if (c == 0) return "0";
//
//        String res = "";
//
//        while (c > 0) {
//            res =  c % 2 + res;
//            c = c / 2;
//        }
//
//        return res;

        // use i length for a and j length for b
        // iterate over i and j.
        // add a to c and b to c.
        // mod to c.
        // divide by 2 and init to c.
        // iterate until i,j become

        while (al >= 0 || bl >= 0 || sum == 1) {
            if (al >= 0)
                sum += a.charAt(al--) - '0';
            if (bl >= 0)
                sum += b.charAt(bl--) - '0';

            res = (sum % 2) + res;
            sum /= 2;
        }

        return res;
    }

//    Input: x = 4
//    Output: 2
//    Explanation: The square root of 4 is 2, so we return 2.
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long i = 1;
        long sq = i * i;
        while (x >= sq) {
            i++;
            sq = i * i;
        }
        return (int) (i - 1);
    }

////    Input: n = 2
////    Output: 2
////    Explanation: There are two ways to climb to the top.
////1. 1 step + 1 step
////2. 2 steps
//    public int climbStairs(int n) {
//        // case handle - if less than equal 1 then return 1.
//        // iterate and equal to no of possible incomes.
//
//        if (n <= 1) return 1;
//        int count = 0;
//        while(n == 1)
//
//        return 0;
//    }


    //["eat","tea","tan","ate","nat","bat"]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedOrder = new String(chars);

            if (!res.containsKey(sortedOrder)) {
                res.put(sortedOrder, new ArrayList<>());
            }

            res.get(sortedOrder).add(s);
        }



        return new ArrayList<>(res.values());
    }

    public boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2 ; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


//    public boolean isPalindrome(String s) {
//        s = s.replaceAll("[^a-zA-Z]", "");
//
//    }


//    2 3 7 43 1807 3263443
    public void test1() {
        int sum = 1;
        int product = 1;
        for (int i = 1; i < 10; i++) {
            product = sum * product;
            sum = product + 1;
            System.out.println(sum);
        }
    }

//    0 + 1 + 2 + 5 + 12 + 29 + 70 + 169 +....... + 407
    public void test() {
        int a = 0;
        int b = 1;
        int c;
        for (int i = 1; i < 10; i++) {
            c = (b * 2) + a;
            System.out.print(c + ",");
            a = b;
            b = c;
        }
    }


//    Input: nums1 = [1,3], nums2 = [2]
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //approch:
        //* 1. Initilize  2 pointers i and j for m and n.
        // move the pointer that corresponds to the small value forward at each step
        // Continue moving the pointers until you have proceed half of the total number of elements
        // calcuate and return the median based on the value pointed by i and j*//

        int i = 0, j = 0;
        int m1 = 0, m2 = 0;
        int m = nums1.length, n = nums2.length;

        for (int count = 0; count <= (m+n) / 2; count++) {
            m2 = m1;
            if (i != m && j != n) {
                if (nums1[i] > nums2[i]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < m) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }
        if ((n+m)%2==1) {
            return m1;
        } else {
            double dec = m1 + m2;
            return dec/2.0;
        }
    }

//
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
    public int lengthOfLongestSubstring(String s) {
        //using map, set.
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0 ; end < s.length(); end++) {
            if (!map.containsKey(s.charAt(end)) || map.get(s.charAt(end)) < start) {
                map.put(s.charAt(end), end);
                maxLen = Math.max(maxLen, end - start + 1);
            } else {
                start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), end);
            }
        }
        return maxLen;
    }

    //abcabcbb
    public int lengthOfLongestSubstringUsingArray(String s) {
        int start = 0, end;
        int maxLen = 0;
        int[] array = new int[128];
        Arrays.fill(array, -1);

        for (end = 0; end < s.length(); end++) {
            if (array[s.charAt(end)] >= start) {
                start = array[s.charAt(end)] + 1;
            }
            array[s.charAt(end)] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
    public String longestPalindrome(String s) {
        // find the number of palindrom in the string and find the max len of the string in if valid palindrom.

        return null;
    }

    public String lowerCase(String s) {
        String result = "";

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result = result + (char) (c+32);
            }
            else {
                result = result + c;
            }
        }
        return result;
    }

    public String upperCase(String s) {
        String result = "";

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result = result + (char) (c-32);
            }
            else {
                result = result + c;
            }
        }
        return result;
    }

    //[1,2,3,2,4]
    public boolean findDuplicates(int[] n) {
        HashSet set = new HashSet();
        for (int i : n) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }


    //[2,3,1,2,3], t = 7
    public int minimumSizeOfSubArray(int[] n, int target) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0 ; right < n.length; right++) {
            sum = sum + n[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - n[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        if (s.length() != t.length()) return false;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    //Input: s = "cbabaebacd", p = "abc"
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] sFre = new int[128];
        int[] pFre = new int[128];

        for (int i = 0; i < p.length(); i++) {
            pFre[p.charAt(i)]++;
            sFre[s.charAt(i)]++;
        }

        if (Arrays.equals(pFre, sFre)) {
            res.add(0);
        }

        int i = 0 , j = p.length();

        while (i < s.length()) {
            sFre[s.charAt(i++) - 'a']--;
            sFre[s.charAt(j++) - 'a']++;
            if (Arrays.equals(pFre, sFre))
                res.add(j);
        }

        return res;
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int[] pChars = new int[26]; // Array to store frequency of characters in pattern string
        int[] sChars = new int[26]; // Array to store frequency of characters in sliding window of string s

        // Populate pChars with character frequencies from pattern string p
        for (char c : p.toCharArray()) {
            pChars[c - 'a']++;
        }

        // Initialize sliding window of length equal to pattern string p
        for (int i = 0; i < p.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
        }

        // Perform sliding window approach
        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(pChars, sChars)) {
                result.add(i - p.length());
            }
            // Slide the window by removing the leftmost character and adding the rightmost character
            sChars[s.charAt(i) - 'a']++;
            sChars[s.charAt(i - p.length()) - 'a']--;
        }

        // Check for anagrams in the last window
        if (Arrays.equals(pChars, sChars)) {
            result.add(s.length() - p.length());
        }

        return result;

    }


        public boolean checkInclusion(String s1, String s2) {

        int[] s1F = new int[26];
        int[] s2F = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            s2F[s2.charAt(i) - 'a']++;
            s1F[s1.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1F, s2F)) return true;

        int i = 0 , j = s2.length();

        while (j < s1.length()) {
            s1F[s1.charAt(i++) - 'a']--;
            s1F[s1.charAt(j++) - 'a']++;
            if (Arrays.equals(s1F, s2F)) return true;
        }
        return false;
    }

    public String getPalindrome(String s, int beginIndex, int endIndex) {
        while (beginIndex >= 0 && endIndex <= s.length() - 1 && s.charAt(beginIndex) == s.charAt(endIndex)) {
            beginIndex--;
            endIndex++;
        }
        return s.substring(beginIndex + 1, endIndex);
    }


    //Go through it for better understanding

    int start = 0, end = 0;
    public String longestPalindrome1(String s) {
        if (s.length() < 2)
            return s;
        char[] c = s.toCharArray();
        longestPallindromeAt(c, 0);
        return s.substring(start, end + 1);
    }
    private void longestPallindromeAt(char[] c, int p) {
        int a = p;
        int b = p;
        int n = c.length;
        if ((p == n - 1 || (n - p) < (end - start + 1)/2))
            return;
        while (b < n - 1 && c[b] == c[b + 1])
            b++;
        p = b;
        while (a > 0 && b < n - 1 && c[a - 1] == c[b + 1])
        {
            a--;
            b++;
        }
        if ((b - a) > (end - start))
        {
            end = b;
            start = a;
        }
        longestPallindromeAt(c, p + 1);
    }


    public String reverseOnlyAlp(String s) {
        String res = "";
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        String appendString = "", appendDigit = "";
        for (int i = 0 ; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                appendString += s.charAt(i);
            } else {
                appendString += s.charAt(i);
            }
        }
        System.out.println(appendString);
        return null;
    }

//    //a=popokpo
//    //b = po
//    public int noOfRepeatWords(String a, String b) {
//        int count = 0;
//        String out = "";
//        int i = 0;
//        while (i < a.length()) {
//           int in = a.indexOf(b);
//           if (in == -1) break;
//           out = a.substring(in, b.length()+in);
//           a = a.substring(b.length(), a.length());
//           if (out.equals(a.substring(in, in + b.length()))) {
//               count++;
//           }
//           i++;
//        }
//        return count;
//    }

//
//    Input: words = ["i","love","temp.leetcode","i","love","coding"], k = 2
//    Output: ["i","love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//    public List<String> topKFrequent(String[] words, int k) {
//        String s = new String();
//        TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);
//        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
//        return map.entrySet().stream()
//                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
//                .map(Map.Entry::getKey)
//                .limit(k)
//                .collect(Collectors.toList());
//    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for(String word : words) wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            int s1Count = wordCounts.get(s1);
            int s2Count = wordCounts.get(s2);

            if(s1Count == s2Count)
                return s2.compareTo(s1);
            return s1Count - s2Count;
        });

        for(String word : wordCounts.keySet()) {
            minHeap.offer(word);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        LinkedList<String> toReturn = new LinkedList<>();
        while(!minHeap.isEmpty()) toReturn.addFirst(minHeap.poll());

        return toReturn;
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum))
                return new int[]{map.get(sum), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    static int largestProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (left < right) {
                product *= nums[left];
                left++;
            }
            max = Math.max(max, product);
        }
        return max;
    }

    public static List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        generatePermutations("", input, result);
        return result;
    }

//    private static void generatePermutations(String prefix, String remaining, List<String> result) {
//        int length = remaining.length();
//        if (length == 0) {
//            result.add(prefix);
//        } else {
//            for (int i = 0; i < length; i++) {
//                String newPrefix = prefix + remaining.charAt(i);
//                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
//                generatePermutations(newPrefix, newRemaining, result);
//            }
//        }
//    }
//

    public static void generatePermutations(String prefix, String remaining, List result) {
        if (remaining.length() == 0) {
            result.add(prefix);
        }
        else {
            for (int i = 0; i < remaining.length(); i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i+1);
                generatePermutations(newPrefix, newRemaining, result);
            }
        }
    }



//    """
//Given an array of numbers, find the second highest number in the array.
//For example, on an input of [1, 6, 5, 8, 11, 4]
//The program will return 8
//Notice you are not allowed to change the array and you can not use built in methods
//"""

    // take lowest number and find first highest/second highest number from an array.

    public static int secondHighest(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int n : nums) {
            if (first < n) {
                second = first;
                first = n;
            } else if (second < n && n != first)
                second = n;
        }
        return second;
    }


//"""
//Write a function that validates brackets " ( { < [ " in a string.
// Examples of valid strings:// * (1*4)+2*(12-19)
//* hell o (world)(5)
//Examples of invalid strings:
//* 4)hello(world)
//"""

    public static boolean validBrackets(String s) {

        Stack<Character> stack = new Stack();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else if (c == '>' && !stack.isEmpty() && stack.peek() == '<'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            if (arr[mid] > target) {
                right--;
            } else {
                left++;
            }
        }
        return -1;
     }

    public static int modifiedBinarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (arr[mid] == target) return mid;

            if (arr[left] <= arr[mid]) {
                if (target > arr[mid] || target < arr[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target < arr[mid] || target > arr[right])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }


    public static HashMap<String, Integer> sortBy(HashMap<String, Integer> ip) {
        HashMap<String, Integer> op = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new LinkedList<>(ip.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> map : list) {
            op.put(map.getKey(), map.getValue());
        }
        return op;
    }


    //{1,3,3,5,6,2}
    public static int findMissingNumber(int[] a) {
        int length = a.length;
//        int sum = length * (length + 1) / 2;
//        for (int j : a) {
//            sum -= j;
//        }
        int sum = 1;
        int i = 0;
        while (i < length) {
            if (sum <= 0) sum = 1;
            if (sum == a[i]) {
                sum++;
                i = 0;
            } else
                i++;
        }


        System.out.println(sum);
        return sum;
    }




    //{9, 6, 4, 5, 7, 0, 1}, op = 2 3 8
    public static int findMultipleMissingNumbers(int[] a) {
        Arrays.sort(a);
        List<Integer> numbers = new ArrayList<>();
        int[] temp = new int[a[a.length - 1] + 1];
        for (int i : a) {
            temp[i] = 1;
        }


        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) numbers.add(i);
        }
        System.out.println(numbers);
        return 0;
    }




    //2,7,11,15 and target = 9;
    public static int[] twoSum1(int[] numbers, int target) {


        Map<Integer, Integer> value = new HashMap<>();


        for (int i = 0; i < numbers.length; i++) {
            int sum = target - numbers[i];
            if (value.containsKey(numbers[i]))
                return new int[]{value.get(numbers[i]), i};
            value.put(sum, i);
        }
        return new int[]{0};
    }


    public static String toLowerCase(String s) {
        char[] ch = s.toCharArray();
        String result = "";


        for (char c : ch) {
            if (Character.isUpperCase(c)) {
                result += (char) (c + 32);
            } else {
                result += c;
            }
        }
        return result;
    }


    public static boolean duplicateInt(int[] numbers) {
        Set set = new HashSet();
        for (int n : numbers) {
            if (!set.add(n)) return true;
        }
        return false;
    }




    //2,3,1,2,4,3 and target = 7
    //s = 2, 5, 6, 8
    public static int minIntSubArray(int[] numbers, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < numbers.length; right++) {
            sum = sum + numbers[right];


            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum = sum - numbers[left];
                left++;
            }
            if (min == 1) break;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static List selfDividingNumber(int left, int right) {
        List<Integer> op = new ArrayList<>();
        while (left < right) {
            if (selfDividingNumber(left)) op.add(left);
            left++;
        }
        return op;
    }


    public static boolean selfDividingNumber(int num) {


        int originalNum = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || originalNum % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }


//    MicroSoft Quiz


    public static int solution1(String S) {
        if (S.isEmpty()) return 0;
        S = S.replaceAll("[^a-zA-Z.]", " ");
        String[] words = S.split("\\.");
        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(max, word.trim().replaceAll("\\s+", " ").split(" ").length);
        }
        return max;
    }


    public static int solution(String S) {
        // Implement your solution here
        ArrayList<String> a1 = new ArrayList<>();


        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                if (i != j) {
                    a1.add(S.substring(i, j));
                }
            }
        }


        TreeMap<String, Integer> a2 = new TreeMap<>();
        for (String s : a1) {
            a2.put(s, a2.getOrDefault(s, 0) + 1);
        }


        ArrayList<String> freshList = new ArrayList<>();


        for (String s : a2.keySet()) {
            if (a2.get(s) == 1) {
                freshList.add(s);
            }
        }


        TreeMap<String, Integer> dic = new TreeMap<>();
        for (String s : freshList) {
            dic.put(s, s.length());
        }


        ArrayList<Integer> newList = new ArrayList<>();
        for (String s : dic.keySet()) {
            newList.add(dic.get(s));
        }


        int ans = Integer.MAX_VALUE;


        for (int i : newList) {
            ans = Math.min(ans, i);
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }




    public static int minSizeSubArray(int[] n, int t) {


        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;


        for (int right = 0; right < n.length; right++) {
            sum += n[right];
            while (sum >= t) {
                min = Math.min(min, right - left + 1);
                sum -= n[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static List commonNumber(int[] a, int[] b, int[] c) {


        List<Integer> result = new ArrayList<>();
        int x = 0, y = 0, z = 0;
        while (x < a.length && y < b.length && z < c.length) {
            if (a[x] == b[y] && b[y] == c[z]) {
                result.add(a[x]);
                x++;
                y++;
                z++;
            } else if (a[x] < b[y]) {
                x++;
            } else if (b[y] < c[z]) {
                y++;
            } else {
                z++;
            }
        }
        return result;
    }




    public static int[] moveZero(int[] n) {
        //Approch 1
        int[] res = new int[n.length];
        int index = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0)
                res[index++] = n[i];
        }


        //Approch 2
        int indexPos = 0;
        for (int num : n) {
            if (num != 0) n[indexPos++] = num;
        }
        while (indexPos < n.length) n[indexPos++] = 0;
        return n;
    }


    public static int[] evenOddNumbers(int[] numbers) {
        int even = 0;
        for (int n : numbers) {
            if (n % 2 == 0) even++;
        }
        return new int[]{even, numbers.length - even};
    }


    public static void printFirstLetterOfEachWordIn(String s) {
        String[] ss = s.split(" ");
        for (String word : ss) {
            System.out.print(word.charAt(0) + " ");
        }
    }


    public static boolean palindrom(String s) {
        if (s.length() <= 1) return true;
        s = s.toLowerCase();
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return palindrom(s.substring(1, s.length() - 1));
    }


    public static String longestCommonPrefix0(String[] strings) {
        int min = Integer.MAX_VALUE;
        for (String s : strings) {
            min = Math.min(min, s.length());
        }
        String prefix = "";
        for (int i = 0; i < min; i++) {
            char currentChar = strings[0].charAt(i);
            for (String s : strings) {
                if (s.charAt(i) != currentChar)
                    return prefix;
            }
            prefix += currentChar;
        }
        return prefix;
    }


    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 1) return "";


        String prefix = strings[0];


        for (int i = 0; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }


    public static int countWords1(String s) {
        return new StringTokenizer(s).countTokens();
    }


    public static int countWords(String s) {
        return s.replaceAll("\\s+", " ").split(" ").length;
    }


    public static int sumOfDig(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDig(n / 10);
    }


    public static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) System.out.println(fibonacci(i));
    }


    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void printFactorial(int n) {
        System.out.println(iterateFactorial(n));
        System.out.println(recFactorial(n));
    }


    private static int recFactorial(int n) {
        if (n > 1) return n * recFactorial(n - 1);
        else return 1;
    }


    private static int iterateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    //    T=O(n); S = O(1)
    public static int[] segregate0sand1s(int[] n) {
        int index = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 0) n[index++] = n[i];
        }
        while (index < n.length) n[index++] = 1;
        return n;
    }

    public static int sumOfElement(int[] n) {
        return IntStream.of(n).sum();
    }


    public static String toUpperCaseFirstLetter(String s) {
        if (s.isEmpty()) return s;
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append((word.charAt(0) + 32)).append(word.substring(1)).append(" ");
        }
        return result.toString();
    }


    public static String repeatChar1(String s) {


        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            int count = Character.getNumericValue(s.charAt(i + 1));
            int j = 0;
            while (j < count) {
                res.append(word);
                j++;
            }
            i = i + 1;
        }
        return res.toString();
    }


    public static String repeatChar(String s) {
        StringBuilder res = new StringBuilder();
        char word = ' ', count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                word = s.charAt(i);
            }
            if (Character.isDigit(s.charAt(i + 1)))
                count += (char) Character.getNumericValue(s.charAt(i + 1));
            int j = 0;
            if (Character.isAlphabetic(s.charAt(i + 1))) {
                while (j < count) {
                    res.append(word);
                    j++;
                }
                count = 0;
            }
        }
        return res.toString();
    }


    public static char nonRepeatChar1(String s) {
        Set<Character> repeated = new HashSet<>();
        List<Character> nonRepeated = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            if (repeated.contains(s.charAt(i))) {
                continue;
            }
            if (nonRepeated.contains(s.charAt(i))) {
                nonRepeated.remove((Character) s.charAt(i));
                repeated.add(s.charAt(i));
            } else {
                nonRepeated.add(s.charAt(i));
            }
        }
        return nonRepeated.get(0);
    }


    public static char nonRepeatChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, i).indexOf(s.charAt(i)) == -1 && s.substring(i+1).indexOf(s.charAt(i)) == -1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


    //121
    public static boolean isPalindrome(int n) {
        int reversed = 0;
        int temp = n;
        while(temp!=0) {
            reversed = reversed * 10;
            reversed = reversed + temp % 10;
            temp = temp / 10;
        }
        return reversed == n;
    }

    //11001001111100111111, string = 11111 and s = 7 and 11;
    public static String findConsNumbersOf1(String s){
        int left = 0;
        int max = Integer.MIN_VALUE;
        String ss = "";
        if (s.contains("1")) {
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == '1') {
                    max = Math.max(max, right - left);
                    if (max > ss.length()) {
                        ss += s.charAt(right);
                    }
                } else {
                    left = right;
                }
            }
        } else {
            return "";
        }
        return ss + " " + s.indexOf(ss) + " " + (s.indexOf(ss) + ss.length()-1);
    }

    static List<String> genericFunction(String colors) {
        Map<java.lang.String, java.lang.Integer> res = new HashMap<>();
        for (java.lang.String color : colors.split(" ")) {
            res.put(color, res.getOrDefault(color, 0) + 1);
        }
        return res.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue().equals(1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet()
                .stream()
                .collect(Collectors.toList());
    }
}

