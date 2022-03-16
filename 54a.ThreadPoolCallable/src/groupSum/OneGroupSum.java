package groupSum;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class OneGroupSum implements Callable<Long> {
    int[] group;

    public OneGroupSum(int[] group) {
        this.group = group;
    }

    public Long call() {
        return Arrays.stream(group).asLongStream().sum();
    }
}
