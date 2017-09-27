import java.util.List;
import java.util.Set;

/**
 * Created by mark on 17/9/26.
 */
public class DFA {
    private Set begin;
    private Set end;
    private Set charSet;
    private List<NodeDFA> nodeDFAs;

    public DFA(Set begin, Set end, Set charSet, List<NodeDFA> nodeDFAs) {
        this.begin = begin;
        this.end = end;
        this.charSet = charSet;
        this.nodeDFAs = nodeDFAs;
    }

    public Set getBegin() {
        return begin;
    }

    public void setBegin(Set begin) {
        this.begin = begin;
    }

    public Set getEnd() {
        return end;
    }

    public void setEnd(Set end) {
        this.end = end;
    }

    public Set getCharSet() {
        return charSet;
    }

    public void setCharSet(Set charSet) {
        this.charSet = charSet;
    }

    public List<NodeDFA> getNodeDFAs() {
        return nodeDFAs;
    }

    public void setNodeDFAs(List<NodeDFA> nodeDFAs) {
        this.nodeDFAs = nodeDFAs;
    }
}
