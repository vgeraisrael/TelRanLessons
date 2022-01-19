public enum WeightUnit {
    GR(1), KG(1000), TN(1_000_000), LBS(453.592);

    double grammAmount;

    WeightUnit(double grammAmount) {
        this.grammAmount = grammAmount;
    }

    public double convert(WeightUnit other){
        return grammAmount/other.grammAmount;
    }

    public double getGramm(){
        return this.grammAmount;
    }

    public static double convert(WeightUnit first, WeightUnit second){
        return first.grammAmount/second.grammAmount;
    }

    public static double convert(double amount, WeightUnit first, WeightUnit second){
        return first.grammAmount / second.grammAmount * amount;
    }
}
