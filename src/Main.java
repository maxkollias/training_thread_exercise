import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
static int rangeFrom=1;
static int rangeToTotal=100000;
static int rangeToStep=100;
    public static void main(String[] args) {

        long start = System.nanoTime();


        Counter count =new Counter();

        int rangeTo=rangeFrom+rangeToStep;
        Thread t;

        do {
            CalculateNumber calculateNumber=new CalculateNumber(rangeFrom,rangeTo, count);
            Thread thread1 = new Thread(calculateNumber);
            thread1.start();
            t=thread1;
            rangeFrom=rangeTo;
            rangeTo+=rangeToStep;
            if (rangeFrom<rangeToTotal & rangeTo>rangeToTotal)
                rangeTo=rangeToTotal;
        } while (rangeTo<=rangeToTotal);

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        double timeInSec=(double)timeElapsed/1000000000;
        System.out.println(timeInSec);
    }


}
