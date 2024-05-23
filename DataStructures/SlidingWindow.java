import java.util.Arrays;
import java.util.HashMap;

public class SlidingWindow {

    public static int maximumPoints(int arr[], int k) {
        /*
         * arr = [6, 2, 3, 4, 2, 1, 7, 1]
         * k = 4
         */

        int lSum = 0, maxSum = 0, rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += arr[i];
        }
        maxSum = lSum;

        int rightIndex = arr.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];
            rSum += arr[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum, (lSum + rSum));
        }

        return maxSum;
    }

    public static int subString(String str) {
        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int n = str.length();

        int r = 0, l = 0;
        int max = 0;
        while (r < n) {

            if (hash[str.charAt(r) - '0'] != -1) {
                if (hash[str.charAt(r) - '0'] >= l) {
                    l = hash[str.charAt(r) - '0'] + 1;
                }
            }

            int len = r - l + 1;
            max = Math.max(max, len);
            hash[str.charAt(r) - '0'] = r++;
        }
        return max;
    }

    public static int maxContinous1(int arr[], int k) {
        /*
         * 
         * Brute force approach
         */
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int zeroes = 0;
            innerLoop: for (int j = i; j < arr.length; j++) {

                if (arr[j] == 0) {
                    zeroes++;
                }

                if (zeroes <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break innerLoop;
                }
            }
        }
        return maxLength;
    }

    public static int maxContinous1Part2(int arr[], int k) {
        int lp = 0, rp = 0, maxLength = 0, zeroes = 0;

        while (rp < arr.length) {

            if (arr[rp] == 0)
                zeroes++;

            while (zeroes > k) {
                if (arr[lp] == 0)
                    zeroes--;
                lp++;
            }
            if (zeroes <= k)
                maxLength = Math.max(maxLength, rp - lp + 1);
            rp++;
        }
        return maxLength;
    }

    public static int maxContinous1Part3(int arr[], int k) {

        int rp = 0, lp = 0, maxLength = Integer.MIN_VALUE, zeroes = 0;

        while (rp < arr.length) {

            if (arr[rp] == 0) {
                zeroes++;
            }

            if (zeroes >= k) {

                if (arr[lp] == 0) {
                    zeroes--;
                }

                lp++;
            }

            rp++;

            maxLength = Math.max(maxLength, rp - lp + 1);
        }
        return maxLength;
    }

    public static int fruitsInBasket(int arr[], int fruits) {

        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;

        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            if (map.size() > fruits) {

                while (map.size() > fruits) {
                    /*
                     * Ye jo maine likha hai wo sikhne ki jarurat hai tumhe O(N+N) : O(3)
                     */
                    if (map.get(arr[left]) == 1) {
                        map.remove(arr[left]);
                    } else {
                        map.put(arr[left], map.get(arr[left]) - 1);
                    }
                    left++;
                }

            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;

        }

        return maxLength;
    }

    public static int fruitsInBasketPartII(int arr[], int fruits) {

        /* Code nahi chal raha hai */

        int maxLength = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            if (map.size() > fruits) {
                if (map.get(arr[left]) == 1)
                    map.remove(map.get(arr[left]));
                else
                    map.put(arr[left], map.get(arr[left]) - 1);

                left++;
            } else {
                maxLength = Math.min(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static int kDistinctCharacters(String str, int k) {
        int left = 0, right = 0, maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (right < str.length()) { // O(N+N) -> O(3)
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() > k) {

                while (map.size() > k) {

                    if (map.get(str.charAt(left)) == 1) {
                        map.remove(str.charAt(left));
                    } else {
                        map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                    }

                    left++;
                }
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }

    public static int kDistinctCharactersPartII(String str, int k) {
        int left = 0, right = 0, maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            char ch = str.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() > k) {
                if (map.get(str.charAt(left)) == 1)
                    map.remove(str.charAt(left));
                else
                    map.put(str.charAt(left), map.get(str.charAt(left)) - 1);

                left++;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static int subStringWithAllCharacters(String str) {
        /*
         * substring -> any consecutive portion of string
         * bbacba
         */
        int count = 0, lastSeen[] = { -1, -1, -1 };

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            lastSeen[ch - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count = count + 1 + (Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
            }
        }
        return count;
    }

    public static int longestRepeatingCharacter(String str, int k) {
        /*
         * very Important
         * AAABBCCD
         */

        int left = 0, right = 0, hashArray[] = new int[26];
        int maxLength = 0, maxF = 0;

        while (right < str.length()) {

            hashArray[str.charAt(right) - 'A']++;
            maxF = Math.max(maxF, hashArray[str.charAt(right) - 'A']);

            /*
             * currentLength - maxFrequency <= k ye condition hai
             * meaning -> only you can change k number of elements
             */

            while (right - left + 1 - maxF > k) {
                hashArray[str.charAt(left) - 'A']--;

                for (int i = 0; i < 26; i++) {
                    maxF = Math.max(maxF, hashArray[i]);
                }

                left++;
            }

            if (right - left + 1 - maxF <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static int longestRepeatingCharacterPartII(String str, int k) {

        int left = 0, right = 0, maxLength = 0, maxF = 0;
        int hashArray[] = new int[26];

        while (right < str.length()) {

            hashArray[str.charAt(right) - 'A']++;
            maxF = Math.max(maxF, hashArray[str.charAt(right) - 'A']);

            /*
             * ab yaha pe khela hoga
             */

            if (right - left + 1 - maxF > k) {
                hashArray[str.charAt(left) - 'A']--;
                for (int i = 0; i < 26; i++) {
                    maxF = Math.max(maxF, hashArray[i]);
                }
            }

            if (right - left + 1 - maxF <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;
    }

    public static int binarySubArraySum(int arr[], int goal) {
        int left = 0, right = 0, tempSum = 0, count = 0;

        if (goal < 0) {
            return 0;
        }

        while (right < arr.length) {
            tempSum += arr[right];

            while (tempSum > goal) {
                tempSum -= arr[left];
                left++;
            }

            count = count + (right - left + 1);
            right++;
        }
        return count;
    }

    public static int niceSubArrays(int arr[]) {
        /*
         * it is similar to previous one
         */
        int nums[] = { 1, 1, 2, 1, 1 };
        int k = 3;
        /*
         * number of subarrays where number of odd numbers are equal to k
         * binary wale sawaal ki tarah hi hai
         */
        return 1;
    }

    public static int subArraysWithK(int num[], int k) {
        /*
         * functions(num, k) - functions(num, k-1) is the answer
         * O(N+N) -> O(N)
          */
        int left = 0, right = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < num.length) {
            map.put(num[right], map.getOrDefault(num[right], 0) + 1);

            while (map.size() > k) {
                if (map.get(num[left]) == 1) {
                    map.remove(num[left]);
                } else {
                    map.put(num[left], map.get(num[left]) - 1);
                }
                left++;
            }
            count = count + (right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 0, 0, 1, 1, 0 };
        System.out.println(binarySubArraySum(arr, 2) - binarySubArraySum(arr, 1));
    }
}