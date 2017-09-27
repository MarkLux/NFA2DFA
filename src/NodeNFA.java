/**
 * Created by mark on 17/9/25.
 */
public class NodeNFA {
    private String start;
    private String rec;
    private String next;

    NodeNFA(String s,String r,String n) {
        this.start = s;
        this.rec = r;
        this.next = n;
    }

    NodeNFA() {

    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getStart() {
        return start;
    }

    public String getRec() {
        return rec;
    }

    public String getNext() {
        return next;
    }

    @Override
    public String toString() {
        return start + " =" + rec + "=> " + next;
    }
}
