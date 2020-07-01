public class CalculateNumber implements Runnable {

private int numberFrom;
private int numberTo;
private Counter counter;

CalculateNumber(int numberFrom,int numberTo ,Counter counter){
    this.numberFrom=numberFrom;
    this.numberTo=numberTo;
    this.counter=counter;
}


    @Override
    public void run() {
    int tempCounter=0;


    for (int j=numberFrom;j<=numberTo;j++){
            for (int i = 1; i < j; i++) {
                if (j % i == 0) {
                    tempCounter++;
                }
            }
        if (tempCounter >= counter.getCounter()) {
            counter.setCounter(tempCounter);
            tempCounter = 0;
            System.out.println("maxCount = "+ counter.getCounter()+" number = "+j);

        } else {
                tempCounter = 0;
            }
        }



    }
}
