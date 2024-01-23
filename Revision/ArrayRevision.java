public class ArrayRevision {

    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
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

    public static int largestNo(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
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

    public static void pairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subArrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i + 1; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxSubarraysSum(int arr[]) {
        int maxSum = 0, currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            // currSum = 0;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += arr[i];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println(maxSum);
    }

    public static void prefixSum(int arr[]) {
        int maxSum = 0, currSum = 0;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;

                currSum = start == 0 ? currSum = arr[end] : arr[end] - arr[start - 1];
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

    public static void trappedRainWater(int height[]) {
        int maxWater = 0;
        /* leftMax */
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        /* rightMax */
        int rightMax[] = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        /* getting min and calculating storedWater */
        for (int i = 0; i < height.length; i++) {
            maxWater += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        System.out.println("MaxWater : " + maxWater);
    }

    public static void buyAndSellStocks(int arr[]) {
        int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > buyPrice) {
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = arr[i];
            }
        }
        System.out.println("BuyPrice : " + buyPrice);
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.println("Sum of Diagonal Elements " + sum);
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int col = matrix[0].length - 1, row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == key)
                return true;
            else if (matrix[row][col] > key) {
                col--;
            } else
                row++;
        }
        return false;
    }

    public static boolean staircaseSearch1(int matrix[][], int key) {
        int row = matrix.length - 1, col = 0;
        while (row <= 0 && col >= matrix[0].length - 1) {
            if (matrix[row][col] == key)
                return true;
            else if (matrix[row][col] > key)
                row--;
            else
                col++;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}