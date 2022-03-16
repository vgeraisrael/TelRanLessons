package groupSum;

public abstract class GroupSum {
    protected int[][] numbers;

    public GroupSum(int[][] numbers) {
        this.numbers = numbers;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }

    public abstract long computeSum();
}
