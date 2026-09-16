public class Main {
    public static void main(String[] args) {
        System.out.println("Premier programme en java pour moi");
        Fraction f = new Fraction();
        assert f.toString().equals("Je suis une fraction.") : "toString() ne retourne pas le bon texte";
        System.out.println("Test est ok : " + f.toString());
    }
}
