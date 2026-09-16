public class Fraction {
    private int numérateur;
    private int denominateur;
    
    public Fraction(int numérateur, int denominateur){
        this.numérateur=numérateur;
        this.denominateur=numérateur;

    }
    public Fraction(int numérateur){
        this(numérateur,1);
    }
    public Fraction() {
    this(0, 1);
    }
    @Override
    public String toString() {
        return ("Je suis une fraction");
    }


}
