package ir.ac.kntu;

import java.util.Random;

/**
 *
 * @author [Your Name]
 */
public class ArraySummerThread {
    
    private final double[] input;
    private final int start;
    private final int end;
    /**
     * store the result of summation for this section of array inside this variable. 
     * TODO: define a getter and when the work of this thread finished use that getter.
     */
    private double sum=0;
    /**
     * 
     * @param input the whole array. don't create a new or cloned array. just pass the whole array
     * @param start index of where to start of summation
     * @param end index of where to end of summation
     */
    public Run(double[] input,int start,int end){
        this.input=input;
        this.start =start;
        this.end=end;
    }
    
    //TODO: implement run method
}

