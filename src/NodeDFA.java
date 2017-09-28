/**
 * Created by mark on 17/9/26.
 */
public class NodeDFA {
    private String start;
    private String rec;
    private String next;

    public NodeDFA(String start, String rec, String next) {
        this.start = start;
        this.rec = rec;
        this.next = next;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return start + " =" + rec + "=> " + next;
    }
}
