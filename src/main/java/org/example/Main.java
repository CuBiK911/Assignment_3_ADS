package org.example;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int userChoice;

    do {
        userChoice = displayMainMenuAndGetChoice(scanner);
        scanner.nextLine();

        switch (userChoice) {
            case 1:
                executeAnagramCheckerTask(scanner);
                break;
            case 2:
                executeKthSmallestTask(scanner);
                break;
            case 3:
                executeMedianCalculatorTask(scanner);
                break;
            case 4:
                executeShippingOptimizerTask(scanner);
                break;
            case 5:
                System.out.println("\nbreak");
                break;
            default:
                System.out.println("\nInvalid choice");
        }
    } while (userChoice != 5);

    scanner.close();
}
    //  MERGE SORT FOR CHARACTERS


     //Performs merge sort on a character array using divide and conquer

    private static void performMergeSortOnChars(char[] charArray, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            performMergeSortOnChars(charArray, leftIndex, middleIndex);
            performMergeSortOnChars(charArray, middleIndex + 1, rightIndex);
            mergeCharSubarrays(charArray, leftIndex, middleIndex, rightIndex);
        }
    }


      //Merges two sorted character subarrays into one sorted array

    private static void mergeCharSubarrays(char[] charArray, int leftIndex, int middleIndex, int rightIndex) {
        int leftSubarraySize = middleIndex - leftIndex + 1;
        int rightSubarraySize = rightIndex - middleIndex;

        char[] leftTemporaryArray = new char[leftSubarraySize];
        char[] rightTemporaryArray = new char[rightSubarraySize];

        System.arraycopy(charArray, leftIndex, leftTemporaryArray, 0, leftSubarraySize);
        System.arraycopy(charArray, middleIndex + 1, rightTemporaryArray, 0, rightSubarraySize);

        int leftPointer = 0, rightPointer = 0, currentPointer = leftIndex;

        while (leftPointer < leftSubarraySize && rightPointer < rightSubarraySize) {
            if (leftTemporaryArray[leftPointer] <= rightTemporaryArray[rightPointer]) {
                charArray[currentPointer] = leftTemporaryArray[leftPointer];
                leftPointer++;
            } else {
                charArray[currentPointer] = rightTemporaryArray[rightPointer];
                rightPointer++;
            }
            currentPointer++;
        }

        while (leftPointer < leftSubarraySize) {
            charArray[currentPointer] = leftTemporaryArray[leftPointer];
            leftPointer++;
            currentPointer++;
        }

        while (rightPointer < rightSubarraySize) {
            charArray[currentPointer] = rightTemporaryArray[rightPointer];
            rightPointer++;
            currentPointer++;
        }
    }


     // Sorts characters in a string and returns the sorted string

    private static String sortCharactersInString(String inputString) {
        char[] characters = inputString.toLowerCase().toCharArray();
        performMergeSortOnChars(characters, 0, characters.length - 1);
        return new String(characters);
    }

    // MERGE SORT FOR INTEGERS

     // Performs merge sort on an integer array using divide and conquer

    private static void performMergeSortOnInts(int[] intArray, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            performMergeSortOnInts(intArray, leftIndex, middleIndex);
            performMergeSortOnInts(intArray, middleIndex + 1, rightIndex);
            mergeIntSubarrays(intArray, leftIndex, middleIndex, rightIndex);
        }
    }


     //Merges two sorted integer subarrays into one sorted array

    private static void mergeIntSubarrays(int[] intArray, int leftIndex, int middleIndex, int rightIndex) {
        int leftSubarraySize = middleIndex - leftIndex + 1;
        int rightSubarraySize = rightIndex - middleIndex;

        int[] leftTemporaryArray = new int[leftSubarraySize];
        int[] rightTemporaryArray = new int[rightSubarraySize];

        System.arraycopy(intArray, leftIndex, leftTemporaryArray, 0, leftSubarraySize);
        System.arraycopy(intArray, middleIndex + 1, rightTemporaryArray, 0, rightSubarraySize);

        int leftPointer = 0, rightPointer = 0, currentPointer = leftIndex;

        while (leftPointer < leftSubarraySize && rightPointer < rightSubarraySize) {
            if (leftTemporaryArray[leftPointer] <= rightTemporaryArray[rightPointer]) {
                intArray[currentPointer] = leftTemporaryArray[leftPointer];
                leftPointer++;
            } else {
                intArray[currentPointer] = rightTemporaryArray[rightPointer];
                rightPointer++;
            }
            currentPointer++;
        }

        while (leftPointer < leftSubarraySize) {
            intArray[currentPointer] = leftTemporaryArray[leftPointer];
            leftPointer++;
            currentPointer++;
        }

        while (rightPointer < rightSubarraySize) {
            intArray[currentPointer] = rightTemporaryArray[rightPointer];
            rightPointer++;
            currentPointer++;
        }
    }

    //  ANAGRAM CHECKER

      //Checks if two strings are anagrams by comparing their sorted character sequences

    private static String checkIfStringsAreAnagrams(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return "NO";
        }
        String sortedFirstString = sortCharactersInString(firstString);
        String sortedSecondString = sortCharactersInString(secondString);
        return sortedFirstString.equals(sortedSecondString) ? "YES" : "NO";
    }


      //Anagram Sort Checker with user input

    private static void executeAnagramCheckerTask(Scanner scanner) {
        System.out.println("\n Anagram Sort Checker ");
        System.out.print("Enter first string: ");
        String firstInput = scanner.nextLine().trim();
        System.out.print("Enter second string: ");
        String secondInput = scanner.nextLine().trim();
        String result = checkIfStringsAreAnagrams(firstInput, secondInput);
        System.out.println("Output: " + result);
    }

    //  K-TH SMALLEST ELEMENT


     // Finds the k-th smallest element by sorting array and accessing index k-1

    private static int findKthSmallestValue(int[] numberArray, int kPosition) {
        performMergeSortOnInts(numberArray, 0, numberArray.length - 1);
        return numberArray[kPosition - 1];
    }


      // K-th Smallest Element Finder with user input

    private static void executeKthSmallestTask(Scanner scanner) {
        System.out.println("\n K-th Smallest Element ");
        System.out.print("Enter size of array: ");
        int arraySize = scanner.nextInt();
        int[] numberArray = new int[arraySize];
        System.out.print("Enter " + arraySize + " integers: ");
        for (int currentIndex = 0; currentIndex < arraySize; currentIndex++) {
            numberArray[currentIndex] = scanner.nextInt();
        }
        System.out.print("Enter k (position of smallest element to find): ");
        int kPosition = scanner.nextInt();
        scanner.nextLine();
        int result = findKthSmallestValue(numberArray, kPosition);
        System.out.println("Output: " + result);
    }

    // MEDIAN ELEMENT


     //Calculates median by sorting array and returning middle element

    private static int calculateMedianFromSortedArray(int[] numberArray) {
        performMergeSortOnInts(numberArray, 0, numberArray.length - 1);
        int middleIndex = numberArray.length / 2;
        return numberArray[middleIndex];
    }


      // Median Element Calculator with user input

    private static void executeMedianCalculatorTask(Scanner scanner) {
        System.out.println("\n Median Element Calculator  ");
        System.out.print("Enter size of array: ");
        int arraySize = scanner.nextInt();
        int[] numberArray = new int[arraySize];
        System.out.print("Enter " + arraySize + " integers: ");
        for (int currentIndex = 0; currentIndex < arraySize; currentIndex++) {
            numberArray[currentIndex] = scanner.nextInt();
        }
        scanner.nextLine();
        int result = calculateMedianFromSortedArray(numberArray);
        System.out.println("Output: " + result);
    }

    //SHIPPING CAPACITY OPTIMIZER

    //  if packages can be shipped within allowed days using given truck capacity

    private static boolean verifyShippingFeasibility(int[] packageWeights, int allowedDays, int truckCapacity) {
        int currentDayCounter = 1;
        int currentDayTotalWeight = 0;

        for (int singlePackageWeight : packageWeights) {
            if (singlePackageWeight > truckCapacity) {
                return false;
            }
            if (currentDayTotalWeight + singlePackageWeight > truckCapacity) {
                currentDayCounter++;
                currentDayTotalWeight = singlePackageWeight;
                if (currentDayCounter > allowedDays) {
                    return false;
                }
            } else {
                currentDayTotalWeight += singlePackageWeight;
            }
        }
        return true;
    }


     // Uses binary search to determine minimum truck capacity for shipping all packages

    private static int computeMinimumShippingCapacity(int[] packageWeights, int allowedDays) {
        int minimumRequiredCapacity = 0;
        int maximumPossibleCapacity = 0;

        for (int packageWeight : packageWeights) {
            if (packageWeight > minimumRequiredCapacity) {
                minimumRequiredCapacity = packageWeight;
            }
            maximumPossibleCapacity += packageWeight;
        }

        int optimalCapacityResult = maximumPossibleCapacity;

        while (minimumRequiredCapacity <= maximumPossibleCapacity) {
            int currentTestCapacity = minimumRequiredCapacity + (maximumPossibleCapacity - minimumRequiredCapacity) / 2;

            if (verifyShippingFeasibility(packageWeights, allowedDays, currentTestCapacity)) {
                optimalCapacityResult = currentTestCapacity;
                maximumPossibleCapacity = currentTestCapacity - 1;
            } else {
                minimumRequiredCapacity = currentTestCapacity + 1;
            }
        }

        return optimalCapacityResult;
    }


    private static void executeShippingOptimizerTask(Scanner scanner) {
        System.out.println("\nOptimal Shipping Capacity");
        System.out.print("Enter number of packages: ");
        int packageCount = scanner.nextInt();
        int[] packageWeights = new int[packageCount];
        System.out.print("Enter weights of " + packageCount + " packages: ");
        for (int currentIndex = 0; currentIndex < packageCount; currentIndex++) {
            packageWeights[currentIndex] = scanner.nextInt();
        }
        System.out.print("Enter number of days to ship: ");
        int allowedDays = scanner.nextInt();
        scanner.nextLine();
        int result = computeMinimumShippingCapacity(packageWeights, allowedDays);
        System.out.println("Output: " + result);
    }




     // Displays main menu

    private static int displayMainMenuAndGetChoice(Scanner scanner) {
        System.out.println("1. Anagram Sort Checker");
        System.out.println("2. K-th Smallest Element Finder");
        System.out.println("3. Median Element Calculator");
        System.out.println("4. Optimal Shipping Capacity Optimizer");
        System.out.println("5. Exit Program");
        System.out.print("\nSelect task number (1-5): ");
        return scanner.nextInt();
    }


}
