import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

class Text {
  private ArrayList<String> arr;

  private int size;

  Text() {
    arr = new ArrayList<>();
    arr.add("Το 75% περίπου του εγκεφάλου μας αποτελείται από νερό.");
    arr.add("Ο ανθρώπινος εγκέφαλος έχει τη δυνατότητα να αποθηκεύσει χίλια terabyte πληροφοριών.");
    arr.add("Ο ανθρώπινος εγκέφαλος έχει περίπου 100 δισεκατομμύρια νευρώνες.");
    arr.add(
        "Τα τεχνητά νευρωνικά δίκτυα μιμούνται το κεντρικό νευρικό σύστημα. Ωστόσο τα δίκτυα αυτά χρειάζονται 40 λεπτά για να επεξεργαστούν αυτό που ο ανθρώπινος εγκέφαλος επεξεργάζεται σε ένα δευτερόλεπτο.");
    arr.add(
        "Υπάρχουν περίπου 160.000 χλμ. αιμοφόρων αγγείων στον ανθρώπινο εγκέφαλο. Το μήκος τους επαρκεί για να κάνει το γύρο της Γης τέσσερις φορές.");
    arr.add(
        "ΦΑΙΆ ΟΥΣΊΑ: Έτσι ονομάζονται οι νευρώνες που είναι υπεύθυνοι για την ομιλία, την μνήμη και τον έλεγχο των μυών.");
    arr.add("Όταν αναπαύεται, ο ανθρώπινος εγκέφαλος παράγει αρκετή ενέργεια για να ανάψει μια λάμπα 25 watt.");
    arr.add(
        "Οι επιστήμονες έχουν καταλήξει στο συμπέρασμα ότι ο εγκέφαλος φτάνει στην πλήρη ωριμότητά του στα 25 μας χρόνια.");
    arr.add("Η χαμηλότερη ταχύτητα με την οποία επεξεργάζεται ο εγκέφαλός μας την πληροφορία είναι 418 χλμ./ώρα.");
    arr.add(
        "Ο εγκέφαλος του ανθρώπου δεν χάνει ποτέ την ικανότητά του να μαθαίνει και να αλλάζει. Αυτό οφείλεται στην ελαστικότητά του και στο γεγονός ότι δημιουργεί συνεχώς νέες συνάψεις.");

    size = arr.size();
  }

  public void sortByLength() {
    Comparator myComparator = new Comparator(arr.get(0));

    java.util.Collections.sort(arr, myComparator);

    for (int i = 0; i < size; i++) {
      System.out.println("\n(" + arr.get(i).length()
          + ") " + arr.get(i));
    }
  }

  public void vowelsAndConsonants() {
    String vowels = "αάεέηήιίοόυύωώ";
    String consonants = "βγδζθκλμνξπρστφχψς";
    int countV, countC, countR;

    for (int i = 0; i < size; i++) {
      countV = 0;
      countC = 0;
      countR = 0;
      String s = arr.get(i);

      for (int j = 0; j < s.length(); j++) {

        char ch = Character.toLowerCase(s.charAt(j));
        if (vowels.indexOf(ch) != -1) {
          // System.out.println("φωνήεν: " + ch);
          countV++;
        } else if (consonants.indexOf(ch) != -1) {
          // System.out.println("συμφωνο: " + ch);
          countC++;
        } else {
          // System.out.println("άλλο: " + ch);
          countR++;
        }

      }
      System.out.println(
          "\nΗ πρόταση : '" + s + "' έχει "
              + ((countV <= countC) ? countV + " φωνήεντα, " + countC + " συμφωνα και "
                  : countC + " σύμφωνα, " + countV + " φωνήεντα και ")
              + countR + " σύμβολα.\n");

    }

  }

  private int findOccurences(String paragraph, String word) {
    String[] words = paragraph.replaceAll("\\p{Punct}", "").split(" ");
    int wordCount = 0;

    for (int i = 0; i < words.length; i++) {
      if (words[i].toLowerCase().equals(word.toLowerCase())) {
        wordCount++;
      }
    }

    return wordCount - 1;
  }

  private String[] removeDuplicates(String[] words) {
    LinkedHashSet<String> set = new LinkedHashSet<>();
    String[] results;

    for (int i = 0; i < words.length; i++)
      set.add(words[i].toLowerCase());

    results = new String[set.size()];
    set.toArray(results);

    return results;

  }

  public void countWords() {
    int result = 0;

    for (int i = 0; i < size; i++) {

      String[] words = arr.get(i).replaceAll("\\p{Punct}", "").split(" ");

      words = removeDuplicates(words);
      System.out.println("Η παράγραφος:\n" + arr.get(i) + "\nέχει " + words.length + " διαφορετικές λέξεις.\n");

      for (int j = 0; j < words.length; j++) {
        result = findOccurences(arr.get(i), words[j]);
        if (result > 0) {
          System.out.println(words[j] + ": " + (result + 1));
        }

      }

      System.out.println();
    }

  }

  public void ConsonantsAndVowelsForAll() {
    String vowels = "αάεέηήιίοόυύωώ";
    String consonants = "βγδζθκλμνξπρστφχψς";
    String punct = ",.;?!:-[]{}()";
    int countV = 0, countC = 0, countP = 0;

    for (int i = 0; i < size; i++) {

      String s = arr.get(i);

      for (int j = 0; j < s.length(); j++) {

        char ch = Character.toLowerCase(s.charAt(j));
        if (vowels.indexOf(ch) != -1) {
          // System.out.println("φωνήεν: " + ch);
          countV++;
        } else if (consonants.indexOf(ch) != -1) {
          // System.out.println("συμφωνο: " + ch);
          countC++;
        } else if (punct.indexOf(ch) != -1) {
          // System.out.println("σημεία στίξης: " + ch);
          countP++;
        }

      }

    }
    System.out.println(
        "\nΤο σύνολο των φωνηέντων είναι: " + countV + ", το σύνολο των συμφώνων: " + countC
            + " και το σύνολο των σημείων στίξης είναι: " + countP);
  }

  public void description() {
    String txt;

    txt = "\nΟ εγκέφαλος αποτελεί το σπουδαιότερο και μεγαλύτερο τμήμα του κεντρικού νευρικού συστήματος. Βρίσκεται εντός του εγκεφαλικού κρανίου και περιβάλλεται από τρεις προστατευτικούς υμένες, τις μήνιγγες. Αποτελείται από δύο ημισφαίρια τα οποία χωρίζονται μεταξύ τους από την επιμήκη σχισμή. Από την κάτω επιφάνεια του εγκεφάλου εκφύονται οι εγκεφαλικές συζυγίες ή νεύρα και ξεκινά ο νωτιαίος μυελός.";

    System.out.println(txt);

    txt = "\nΑπό το 1945 οι επιστήμονες γνωρίζουν, ότι ο εγκέφαλος είναι περίπου 73% νερό. Η καλή ενυδάτωση του εγκεφάλου είναι απαραίτητη. Αφυδάτωση της τάξης μόλις του 2% μπορεί να επηρεάσει την ικανότητα του ατόμου να εκτελεί καθήκοντα που αφορούν την μνήμη και τις κινητικές δεξιότητες. Η χοληστερόλη είναι ένας τύπος λίπους που συχνά θεωρείται κακός για την υγεία του ατόμου. Είναι αλήθεια ότι η κατανάλωση υπερβολικής χοληστερόλης είναι κακή για την καρδιά. Ωστόσο, πολλοί άνθρωποι δεν γνωρίζουν ότι η χοληστερόλη παίζει σημαντικό ρόλο στον εγκέφαλο ενός ατόμου.";

    System.out.println(txt);

    System.out.println(
        "\nΠαρακαλώ δώστε μια λέξη με πάνω από τρία γράμματα για να βρούμε τις παραγράφους που την περιέχουν ή έναν αριθμό από το 3 εως το 15 για να βρούμε τις παραγράφους που περιέχουν λέξεις ίσες ή μεγαλύτερες από τον αριθμό αυτό.\n ");
  }

  public boolean defence(String temp){
    String greekAB = "αάβγδεέζηήθιίκλμνξοόπρστυύφχψωώ";
    String englishAB = "abcdefghijklmnopqrstuvwxyz";
    char ch; boolean result = false;
    
      if (temp.length() < 4){
        result = true;
        System.out.println("Παρακαλώ, φροντίστε η λέξη που εισάγετε να έχει περισσότερα από 3 γράμματα.");
      }
    else{
       for(int i = 0;i < temp.length();i++){
        for(int j =0; j < greekAB.length(); j++){
          ch = temp.charAt(i);
          if(englishAB.indexOf(ch) != -1){
             System.out.println("Παρακαλώ, φροντίστε η λέξη που εισάγετε να είναι στην ελληνική γλώσσα.");
            result = true;
            break;
          }
        }
         if(result){
           break;
         }
      }
    }
    return result; 
  }

  public boolean checkWord(String temp){
    boolean result = false;
    String s;
    
    for (int i = 0; i < size; i++) {
      s = arr.get(i);
      for (int j = 0; j < s.length(); j++) {
        if (s.contains(temp)) {
          System.out.println("Η λέξη '" + temp + "' που πληκτρολογήσατε βρίσκεται στην παράγραφο: " + s + "\n\n");
          result = true;
          break;
        }
      }
    }
    return result;     
  }

  public String checkLength(String par, int number){
    
    ArrayList<String> wordsFound = new ArrayList<String>();
    
    String[] words = par.replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", "").split(" "); 

    boolean found = false; 
    
    for(String w : words){
      if(w.length() > 3){
        if(w.length() == number){
          wordsFound.add(w);
          found = true;
        }
      }
    }

    for(String w : wordsFound){
      par = par.replace(w, "__" + w + "__");
    }

    return (found)? par : "";
  }
  
  public boolean checkNo(String temp){
    boolean result = false;
    String par, prep;

    if(temp.matches("[0-9]+")){
      int number = Integer.parseInt(temp);
      if(number < 4 || number > 15){
        System.out.println("\nΠαρακαλώ δώστε αριθμό στο διάστημα [3 - 15]");
      }
      else{
        for(int i = 0; i < size; i++){
          par = arr.get(i);
          prep = checkLength(par, number);
          System.out.print((prep.length() > 1)? prep + "\n\n" : "");
          result = true;
        }
      }    
    }
     return result;
  }

  public void doLine(int times){
    for(int i = 0; i < times; i++){
      System.out.print("-");
    }
    System.out.println();
  }

  public void additional() {

    Scanner sc = new Scanner(System.in);
    String temp, greekPunct = ".,;:!()-";
    boolean repeat = false;
    String message = "\nΠαρακαλώ δώστε μια λέξη ή έναν αριθμό ή τη λέξη 'βοήθεια' για περισσότερες πληροφορίες. Εναλλακτικά δώστε σημείο στίξης για τον τερματισμό του προγράμματος\n", message2 = "\n**Για την έξοδο θα πρέπει να δώσετε κάποιο σημείο στίξης**";
    
    
    do {
      
      System.out.println(message);
      temp = sc.nextLine().toLowerCase();
      repeat = !greekPunct.contains(temp); 

      if (repeat){
      
        if(checkNo(temp)){
          doLine(17);
        }
        else if(defence(temp)){
          doLine(17);
        }
        else if (temp.equals("βοήθεια")) {
          description();
          doLine(17);
        }
        else if(checkWord(temp)){
          doLine(17);
        }
        
      }

      if (temp.length() == 0){
        System.out.println(message2);
        repeat = true;
      }

    } while (repeat);
      
    System.out.println("Ευχαριστούμε, το πρόγραμμα τερματίστηκε.");
    sc.close();

    

  }
}
