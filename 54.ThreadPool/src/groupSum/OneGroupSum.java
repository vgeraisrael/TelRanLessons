package groupSum;

import java.util.Arrays;

public class OneGroupSum implements Runnable{
    int[] group;
    long sum;

    public OneGroupSum(int[] group) {
        this.group = group;
    }

    public long getSum() {
        return sum;
    }

    public void run() {
        sum = Arrays.stream(group).asLongStream().sum();
    }
}
