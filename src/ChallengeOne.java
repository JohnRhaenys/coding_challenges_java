import java.util.Arrays;

public class ChallengeOne
{
    /**
     * Given an array of N integers, construct a product array of the
     * same size such that the ith element of the product array is equal
     * to the product of all the elements of the original array,
     * except for the ith element
     *
     * TEST CASES:
     * array of positive numbers
     * array of negative numbers
     * array of positive and negative numbers
     * array with 1 zero
     * array with multiple zeroes
     * array with 1 zero, 1 negative and one positive number
     * empty array
     */
    public static void main(String[] args) {
        int[] result = ChallengeOne.first(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{-1, -2, -3, -4});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{-1, -2, 3, 4});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{-2, -1, 0, 3});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{-2, 0, 0, 3});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{-2, 0, 3});
        System.out.println(Arrays.toString(result));

        result = ChallengeOne.first(new int[]{});
        System.out.println(Arrays.toString(result));
    }

    public static int[] first(int[] originalArray)
    {
        int product = getArrayProduct(originalArray);

        int[] newArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++)
        {
            int item = originalArray[i];
            if (item == 0) {
                int ignoredIndexProduct = getArrayProduct(originalArray, i);
                newArray[i] = ignoredIndexProduct;
            }
            else {
                newArray[i] = product / item;
            }
        }
        return newArray;
    }

    public static int getArrayProduct(int[] array)
    {
        if (array.length == 0) {
            return 0;
        }

        int product = 1;
        for(int i = 0; i < array.length; i++)
        {
            product = product * array[i];
        }
        return product;
    }

    public static int getArrayProduct(int[] array, int ignoreIndex)
    {
        if (array.length == 0) {
            return 0;
        }

        if (ignoreIndex >= array.length) {
            return 0;
        }

        int product = 1;
        for(int i = 0; i < array.length; i++)
        {
            if (i != ignoreIndex) {
                product = product * array[i];
            }
        }
        return product;
    }
}
