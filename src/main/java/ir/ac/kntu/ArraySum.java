package ir.ac.kntu;

import java.util.Random;

/**
 *
 * @author [Your Name]
 */
public class ArraySum {

    /**
     * Sequentially compute the sum of the values for a given array.
     *
     * @param input Input array
     * @return The sum of the array input
     */
    public static double seqArraySum(final double[] input) {
        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

        return sum;
    }
    private static int getNCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Computes the size of each chunk, given the number of chunks to create
     * across a given number of elements.
     *
     * @param nChunks The number of chunks to create
     * @param nElements The number of elements to chunk across
     * @return The default chunk size
     */
    private static int getChunkSize(final int nChunks, final int nElements) {
        // Integer ceil
        return (nElements + nChunks - 1) / nChunks;
    }

    /**
     * Computes the inclusive element index that the provided chunk starts at,
     * given there are a certain number of chunks.
     *
     * @param chunk The chunk to compute the start of
     * @param nChunks The number of chunks created
     * @param nElements The number of elements to chunk across
     * @return The inclusive index that this chunk starts at in the set of
     * nElements
     */
    private static int getChunkStartInclusive(final int chunk,
            final int nChunks, final int nElements) {
        final int chunkSize = getChunkSize(nChunks, nElements);
        return chunk * chunkSize;
    }

    /**
     * Computes the exclusive element index that the provided chunk ends at,
     * given there are a certain number of chunks.
     *
     * @param chunk The chunk to compute the end of
     * @param nChunks The number of chunks created
     * @param nElements The number of elements to chunk across
     * @return The exclusive end index for this chunk
     */
    private static int getChunkEndExclusive(final int chunk, final int nChunks,
            final int nElements) {
        final int chunkSize = getChunkSize(nChunks, nElements);
        final int end = (chunk + 1) * chunkSize;
        if (end > nElements) {
            return nElements;
        } else {
            return end;
        }
    }

    /**
     * TODO: Modify this method to compute the same sum as seqArraySum, but use
     * Threads. You may assume that the length of the input array is evenly
     * divisible by 2. and don not think about overflow. TODO: Try to find the optimal numberOfThreads
     *
     * @param input Input array
     * @return The sum of the array input
     */
    public static double parArraySum(final double[] input, int numberOfThreads) {
        assert input.length % 2 == 0;
        //NOTE: Dont use Executors.newCachedThreadPool() or any other executor service
        

        //create your threads (store them in an array) : new ArraySummerThread(array,computedStartPostion,computedEndPosition)

        //start your threads

        //join the threads

        //collect and combine the results


        return seqArraySum(input);

    }

    /**
     * Create a double[] of length N to use as input for the tests.
     *
     * @param N Size of the array to create
     * @return Initialized double array of length N
     */
    private double[] createArray(final int N) {
        final double[] input = new double[N];
        final Random rand = new Random(314);

        for (int i = 0; i < N; i++) {
            input[i] = rand.nextInt(100);
            // Don't allow zero values in the input array to prevent divide-by-zero
            if (input[i] == 0.0) {
                i--;
            }
        }

        return input;
    }
}

