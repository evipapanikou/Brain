import java.util.Scanner;

class Main {

   public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void press(){
    System.out.print("\n---  πατήστε ΕΝΤΕΡ για να συνεχίσετε ---\n");
    Scanner sc = new Scanner(System.in);
    String temp = sc.nextLine();
    clear();
  }
  
  public static void main(String[] args) {
    clear();

    Text t = new Text();
    
    t.sortByLength();
    press();
    
    t.vowelsAndConsonants();
    press();

    t.countWords();
    press();

    t.ConsonantsAndVowelsForAll();
    press();

    t.additional();
    
  }
}
