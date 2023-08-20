public class ArrayRevision {

    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largestNo(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int[] reverseArray(int arr[]) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;
    }

    public static void pairs(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subArrays(int arr[]) {
        int ts = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.println(arr[j] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
            System.out.println("Total SubArrays : " + ts);
        }

    }

    public static void maxSubarraysSum(int arr[]) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += arr[k];
                }
                System.out.println("currSum is " + currSum);
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println("MaxSum is " + maxSum);
    }

    public static void prefixSum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? arr[end] : arr[end] - arr[start - 1];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println(maxSum);
    
    }

    public static void kadanesAlgo(int arr[]) {
        int cs = 0, ms = 0;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.min(ms, cs);
        }
        System.out.println(ms);
    }

    public static int trappedRainWater(int height[]) {
        int waterLevel = 0;
        /* leftMax */
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        /* rightMax */
        int rightMax[] = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        /* calculate min among both and also stored water */
        for (int i = 0; i < height.length; i++) {
            waterLevel += (Math.min(leftMax[i], rightMax[i])) - height[i];
        }
        return waterLevel;
    }

    public static int buyAndSellStocks(int stocks[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MIN_VALUE;
        for (int i = 0; i < stocks.length; i++) {
            if (buyPrice < stocks[i]) {
                int profit = stocks[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = stocks[i];
            }
        }
        return maxProfit;
    }

    public static void printSpiral(int matrix[][]) {
        int startCol = 0, startRow = 0;
        int endCol = matrix[0].length - 1, endRow = matrix.length - 1;

        while (startCol <= endCol && startRow <= endRow) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }
            for (int i = endRow - 1; i <= startRow + 1; i--) {
                System.out.print(matrix[i][startRow] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            sum += matrix[i][i];
            if(i != matrix.length-i-1) {
                sum += matrix[i][matrix.length-i-1];
            }
        }
        System.out.println("Sum of Diagonal Element "+sum);
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length-1;
        while(row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == key) {
                return true;
            } else if(matrix[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean staircaseSearch1(int matrix[][], int key) {
        int col = 0, row = matrix.length-1;
        while(row >= 0 && col <= matrix[0].length-1) {
            if(matrix[row][col] == key) {
                return true;
            } else if(matrix[row][col] > key) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Hello");
    }
}