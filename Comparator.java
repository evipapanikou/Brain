public class Comparator implements java.util.Comparator<String> {

    private int referenceLength;

    public Comparator(String reference) {
        super();
        this.referenceLength = reference.length();
    }

    public int compare(String s1, String s2) {
        int dist1 = Math.abs(s1.length() - referenceLength);
        int dist2 = Math.abs(s2.length() - referenceLength);

        return dist1 - dist2;
    }
}
