import java.util.ArrayList;
import java.util.List;

public class Polynomial {
  //Note: the exponet is also the possition of the element  e.g CnX^n
    private List<Term> terms;

    public Polynomial() {
        this.terms = new ArrayList<>();
    }
    public void addTerms (double  coeeficient,double  exponet) {

        Term newTerm= new Term(coeeficient,exponet);
        terms.add(newTerm);//ADDING A NEW TERM INTO THE LIST
        System.out.println("term added ");
    }

    public double getCoefficient(double n ) {
        for (Term term : terms) {
            if( (Double.compare(term.getExponet(), n) == 0)){
                return term.getCoefficient();
            }
        }
        return 0;
    }
    public void setCoeffiecient (double exponet ,double coefficient) {
        for(Term term : terms){
            if(Double.compare(term.getExponet(), exponet) == 0){
                term.setCoefficient(coefficient);
                return;
            }

        }
        terms.add(new Term(coefficient, exponet));

    }
    public double evaluate(int x){
        double result=0;
        for (Term term : terms) {
            result += term.getCoefficient()*(Math.pow(x, term.getExponet()));
        }
        return result;
    }
    public Polynomial addFunctions(Polynomial other) {
        Polynomial result = new Polynomial();
        for (Term term : this.terms) {
            result.setCoeffiecient(term.getExponet(), term.getCoefficient());
        }
        for (Term term : other.terms) {
            double existing = result.getCoefficient(term.getExponet());
            result.setCoeffiecient(term.getExponet(), existing + term.getCoefficient());
        }
        return result;
    }
    public Polynomial derivate ()
    {
        Polynomial result = new Polynomial();
        for (Term term : terms) {
            if (term.getExponet() == 0) continue; // constant vanishes
            double newCoeefficent = term.getCoefficient()*term.getExponet();
            double newexponet = term.getExponet()-1;

            result.setCoeffiecient(newexponet,newCoeefficent);

        }
        return result;
    }
    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";

        terms.sort((a, b) -> Double.compare(b.getExponet(), a.getExponet()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < terms.size(); i++) {
            sb.append(terms.get(i).toString());
            if (i != terms.size() - 1) sb.append(" + ");
        }
        return sb.toString();
    }



}
