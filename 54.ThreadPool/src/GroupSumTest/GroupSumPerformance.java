package GroupSumTest;

import groupSum.GroupSum;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class GroupSumPerformance {
    GroupSum groupSum;

    public GroupSumPerformance(GroupSum groupSum) {
        this.groupSum = groupSum;
    }

    public void runTest(){
        Instant start = Instant.now();
        long sum = groupSum.computeSum();
        displayResult(start, sum);
    }

    private void displayResult(Instant start, long sum) {
        System.out.printf("Test: %s. Sum %d was computed in %d", groupSum.getClass().getSimpleName(), sum, ChronoUnit.MILLIS.between(start, Instant.now()));
    }
}
