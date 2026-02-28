public class Term {
    private double coefficient;
    private double exponet;

    public Term(double coefficient, double exponet) {
        this.coefficient = coefficient;
        this.exponet = exponet;
    }
    public double getCoefficient() {return coefficient;}
    public double getExponet() {return exponet;}
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public void setExponet(double exponet) {
        this.exponet = exponet;
    }

    @Override
    public String toString() {
        if(exponet ==0){
            return String.valueOf(coefficient);
        }
        if(exponet ==1){
            return coefficient +"X";
        }
        return coefficient +"X^"+ (int)exponet;
    }
}
