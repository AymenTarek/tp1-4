public class Fraction extends Number implements Comparable<Fraction>  {
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
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    public int getNumérateur() {
        return numérateur;
    }
    public int getDenominateur(){
        return denominateur;
    }
    public double doubleValue() {
        return (double) numérateur / denominateur;
    }
    public Fraction add(Fraction autre) {
        int nouveauNum = this.numérateur * autre.denominateur + autre.numérateur * this.denominateur;
        int nouveauDenom = this.denominateur * autre.denominateur;
        return new Fraction(nouveauNum, nouveauDenom);
    }
    public boolean equals(Object obj) {
         if (!(obj instanceof Fraction)) return false;
         Fraction autre = (Fraction) obj;
        return this.numérateur * autre.denominateur == autre.numérateur * this.denominateur;
    }
    @Override
    public int compareTo(Fraction autre) {
    return Double.compare(this.doubleValue(), autre.doubleValue());
    }
    @Override
    public int intValue() {
    return (int) doubleValue();
    }

    @Override
    public long longValue() {
    return (long) doubleValue();
     }

    @Override
     public float floatValue() {
     return (float) doubleValue();
     }
    @Override
    public String toString() {
        return ("Je suis une fraction");
    }


}
