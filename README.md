# Compléments de programmation - TD 1

## Remarques préliminaires
* Avez vous lu sur persee, l'annonce "La notation et l'IA" ?
* Les commandes `git` sont à taper en ligne de commande dans un *shell bash*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp)).
À chaque étape, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`).

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?

    Si on coche une ou plusieurs cases « Initialize this repository with », on aura un commit initial avec les fichiers correspondant aux cases cochées. Si on ne coche aucune case, on n’aura pas de commit initial.
   
    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`) (cf. [Personnalisation de Git](https://git-scm.com/book/fr/v2/Personnalisation-de-Git-Configuration-de-Git));
    ```bash
    $ git config --global user.name "Aymen Beddar"
    $ git config --global user.email "bdrtarik@gmail.com"

    ```
1. Initialisez le dépôt `git` local pour le projet (cf. [Démarrer un dépôt Git](https://git-scm.com/book/fr/v2/Les-bases-de-Git-D%C3%A9marrer-un-d%C3%A9p%C3%B4t-Git));
    ```bash
    git init 
    ```
1. Dans votre IDE, créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet (cf. [Méthode `main`](https://docs.oracle.com/javase/specs/jls/se19/html/jls-12.html#jls-12.1.4));
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements (cf. [Enregistrer des modifications dans le dépôt](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Enregistrer-des-modifications-dans-le-d%C3%A9p%C3%B4t));
    ```bash
    $ git add src/Fraction.java src/Main.java
    $ git commit -m "Création des classes Fraction et Main"

    ```
1. Ajoutez la méthode `toString` à la classe `Fraction` (cf. [`Object.toString`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#toString())) qui retournera la chaîne `"Je suis une fraction."` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
    /Fraction f = new Fraction();
    assert f.toString().equals("Je suis une fraction.") : "toString() ne retourne pas le bon texte";
     System.out.println("Test est ok : " + f.toString());
    ```
1. Publiez vos modifications sur le dépôt distant (cf. [Travailler avec des dépôts distants](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Travailler-avec-des-d%C3%A9p%C3%B4ts-distants));
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    git push -u origin master
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    Markdown
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (cf. [`.gitignore` pour Java](https://github.com/github/gitignore/blob/main/Java.gitignore));
    ```bash
    *.class
     target/
     bin/
     out/
*   .jar
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    # git rm -r --cached .vscode
    ```
    Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    # Copier ici les modifications de `.gitignore`
     .vscode/
     .idea/
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    > Pour me connecter au serveur en toute sécurité sans taper de mot de passe à chaque fois, j'ai créé une paire de clés SSH (une clé privée que je garde secrète, et une clé publique que j'ai envoyée au serveur). Une fois que le prof a validé ma clé publique de son côté, le serveur a pu me reconnaître automatiquement grâce à ma clé privée à chaque connexion.

## Partie II (à faire durant le TD) : compléter la classe `Fraction`
Dans cet partie, vous compléterez les classes `Fraction` et `Main`.
Un exemple d'interface pour une telle classe est donné par la classe [`Fraction`](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](http://commons.apache.org/math/).

Vous respecterez les consignes ci-dessous :
* chaque méthode de `Fraction` sera testée dans `Main` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp));
* à la fin de chaque question, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`) puis validez les changements.

1. Ajoutez les attributs représentants le numérateur et le dénominateur (nombres entiers).
    ```Java
    private  int numérateur;
    private  int denominateur;

    ```
1. Ajoutez les constructeurs (cf. [Constructor Declarations](https://docs.oracle.com/javase/specs/jls/se19/html/jls-8.html#jls-8.8)) suivants :
    * initialisation avec un numérateur et un dénominateur,
    * initialisation avec juste le numérateur (dénominateur égal à _1_),
    * initialisation sans argument (numérateur égal _0_ et dénominateur égal à _1_),
    ```Java
    public Fraction(int numérateur, int denominateur){
        this.numérateur=numérateur;
        this.denominateur=numérateur;

    }
    public Fraction(int numérateur){
        this(numérateur,1);
    }
    public Fraction() {
    this(0, 1);
    }    ```
1. Ajoutez les fractions constantes ZERO (0, 1) et UN (1, 1) (cf. [Constants in Java](https://www.baeldung.com/java-constants-good-practices)),
    ```Java
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    ```
1. Ajoutez une méthode de consultation du numérateur et du dénominateur (par convention, en Java, une méthode retournant la valeur de l'attribut `anAttribute` est nommée `getAnAttribute`),
    ```Java
     public int getNumérateur() {
        return numérateur;
    }
    public int getDenominateur(){
        return denominateur;
    }   
    ```
1. Ajoutez une méthode de consultation de la valeur sous la forme d'un nombre en virgule flottante (méthode `doubleValue()`) (cf. [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html)),
   ```Java
    public double doubleValue() {
        return (double) numerateur / denominateur;
    }
    ```
1. Ajoutez une méthode permettant l'addition de deux fractions (la méthode `add` prend en paramètre *une* fraction et *retourne* la somme de la fraction courante et du paramètre),
   ```Java
    public Fraction add(Fraction autre) {
        int nouveauNum = this.numérateur * autre.denominateur + autre.numérateur * this.denominateur;
        int nouveauDenom = this.denominateur * autre.denominateur;
        return new Fraction(nouveauNum, nouveauDenom);
    }   
    ```
1. Ajoutez le test d'égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) (cf. [`java.lang.Object.equals`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))),
   ```Java
    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Fraction)) return false;
         Fraction autre = (Fraction) obj;
        return this.numerateur * autre.denominateur == autre.numerateur * this.denominateur;
    }// 
    ```
1. Ajoutez la comparaison de fractions selon l'ordre naturel (cf. [`java.lang.Comparable`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Comparable.html)).
   ```Java
    public class Fraction implements Comparable<Fraction>  #tout en haut
    @Override
    public int compareTo(Fraction autre) {
    return Double.compare(this.doubleValue(), autre.doubleValue());
    }
    ```
1. Faites hériter votre classe `Fraction` de la classe [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html) et complétez les méthodes
   ```Java
    // Vérifiez avec le code ci-dessous
    Number aNumber = java.math.BigDecimal.ONE;
    Number anotherNumber = new Fraction(1, 2);
    assert java.lang.Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;
    ```

## Partie III (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    J'utilise Windows 10/11, avec Git Bash comme shell de commandes.
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
    git commit --help
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        ls -lhS
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        wc -l Main.java
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        grep "uneVariable" Main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        grep -r --include="*.java" "uneVariable" .
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        find . -type f -name "README.md"
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        diff fichier1.txt fichier2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        > permet de se connecter à distance à un serveur de façon sécurisée 
    * `screen`/`tmux`
        > permettent de garder une session terminal active à distance et de gérer plusieurs fenêtres dans une seule connexion
    * `curl`/[HTTPie](https://httpie.org/)
        >  permettent d'envoyer des requêtes HTTP en ligne de commande, utile pour tester une API.
    * [jq](https://stedolan.github.io/jq/)
        > permet de traiter et afficher des données JSON en ligne de commande

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    >  J'utilise Visual Studio Code avec l'extension "Extension Pack for Java".

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    > L'encodage UTF-8 se vérifie en bas à droite de la fenêtre VS Code.
1. Comment choisir le JDK à utiliser dans un projet ?
    > Répondre ici
1. Comment préciser la version Java des sources dans un projet ?
    > La version Java des sources se précise dans le pom.xml (Maven) ou les paramètres Java de VS Code
1. Comment ajouter une bibliothèque externe dans un projet ?
    > Une bibliothèque externe s'ajoute via le pom.xml ou le classpath du projet
1. Comment reformater un fichier source Java ?
    > Shift+Alt+F
1. Comment trouver la déclaration d'une variable ou méthode ?
    >  clic droit > Go to Definition, ou F12
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    > taper le mot-clé puis Tab/Entrée.
1. Comment renommer une classe dans l'ensemble du projet ?
    > F2 sur le nom de la classe
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > ajouter dans le champ "args" du launch.json
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > point d'arrêt + F5, variables visibles dans le panneau Debug.
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développeépondre iciment Java ?
    > Ce qui m'aide le plus : la complétion automatique du code, le débogueur intégré pour voir les variables pendant l'exécution, et les erreurs signalées directement pendant que j'écris.