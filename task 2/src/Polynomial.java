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
            if(term.getExponet() == n){
                return term.getCoefficient();
            }
        }
        return 0;
    }
    public void setCoeffiecient (double exponet ,double coefficient) {
        for(Term term : terms){
            if(term.getExponet() == exponet){
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
    public Polynomial  addFunctions (Polynomial other) {
       Polynomial result = new Polynomial();

       //add terms in a to result
        for (Term term : this.terms) {
            result.addTerms(term.getCoefficient(), term.getExponet());
        }
        //check the terms in the other list if they have same xponet that add and make new term
        for(Term term : other.terms){
            double existingCoeffiecient= result.getCoefficient(term.getExponet());
            double newCoeffient= existingCoeffiecient+term.getCoefficient();

            result.setCoeffiecient(term.getExponet(),newCoeffient);
        }
        return result;
    }
    public Polynomial derivate ()
    {
        Polynomial result = new Polynomial();
        for (Term term : terms) {
            double newCoeefficent = term.getCoefficient()*term.getExponet();
            double newexponet = (int) term.getExponet()-1;

            result.addTerms(newCoeefficent,newexponet);
        }
        return result;
    }


}
