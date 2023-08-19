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
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
            }
        }
        return maxNum;
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.println("(" + arr[i] + "," + ")");
            }
        }
    }

    public static void subArrays(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
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
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                int end = j;
                for (int k = start; k <= end; k++) {
                    currSum += arr[k];
                }
                System.out.println(currSum);
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println(maxSum);
    }

    public static void prefixSum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
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
        int ms = 0, cs = 0;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Max is " + ms);
    }

    public static void trappedRainWater(int arr[]) {
        int totalWater = 0;
        /* leftMax */
        int leftMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        /* rightMax */
        int rightMax[] = new int[arr.length];
        rightMax[rightMax.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        /* min among both and calculation */
        for (int i = 0; i < arr.length; i++) {
            totalWater += (Math.min(leftMax[i], rightMax[i])) - arr[i];
        }
        System.out.println(totalWater);
    }

    public static void buyAndSellStocks(int arr[]) {
        int buyPrice = 0, maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (buyPrice < arr[i]) {
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = arr[i];
            }
        }
        System.out.println(maxProfit);
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
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.println("Sum is " + sum);
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length-1;
        while(row <= matrix.length-1 && col >=0) {
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
        int row = matrix.length-1, col = 0;
        while(col <= matrix[0].length-1 && row >= 0) {
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

    }
}