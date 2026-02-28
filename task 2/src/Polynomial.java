import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    private List<Term> terms;

    public Polynomial() {
        this.terms = new ArrayList<>();
    }
    public void addTerms (double  coeeficient,double  exponet) {
        Term newTerm= new Term(coeeficient,exponet);
    }

}
