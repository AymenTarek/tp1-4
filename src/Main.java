public class Main {
    public static void main(String[] args) {
        System.out.println("Premier programme en java pour moi");
        Fraction f = new Fraction();
        assert f.toString().equals("Je suis une fraction.") : "toString() ne retourne pas le bon texte";
        System.out.println("Test est ok : " + f.toString());
         Fraction f1 = new Fraction(3, 4);
        assert f1.getNumérateur() == 3;
        assert f1.getDenominateur() == 4;

        Fraction f2 = new Fraction(5);
        assert f2.getNumérateur() == 5 && f2.getDenominateur() == 1;

        Fraction f3 = new Fraction();
        assert f3.getNumérateur() == 0 && f3.getDenominateur() == 1;

        assert Fraction.ZERO.getNumérateur() == 0 && Fraction.ZERO.getDenominateur() == 1;
        assert Fraction.UN.getNumérateur() == 1 && Fraction.UN.getDenominateur() == 1;

        assert Math.abs(f1.doubleValue() - 0.75) < 1e-8;

        Fraction f4 = new Fraction(1, 2);
        Fraction somme = f1.add(f4);
        assert Math.abs(somme.doubleValue() - 1.25) < 1e-8;

        Fraction f5 = new Fraction(2, 4);
        Fraction f6 = new Fraction(1, 2);
        assert f5.equals(f6);

        Fraction petite = new Fraction(1, 4);
        Fraction grande = new Fraction(3, 4);
        assert petite.compareTo(grande) < 0;

        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);
        assert Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;

        System.out.println("Tous les tests passent !");
    }

}
