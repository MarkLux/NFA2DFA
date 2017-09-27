import java.util.*;

/**
 * Created by mark on 17/9/25.
 */
public class NFA {
    private Set<String> begin;
    private Set<String> end;
    private Set<String> charList;
    private List<NodeNFA> nfaNodes;

    public NFA(Set begin, Set end, Set charList, List<NodeNFA> nfaNodes) {
        this.begin = begin;
        this.end = end;
        this.charList = charList;
        this.nfaNodes = nfaNodes;
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

    public Set getCharList() {
        return charList;
    }

    public void setCharList(Set charList) {
        this.charList = charList;
    }

    public List<NodeNFA> getNfaNodes() {
        return nfaNodes;
    }

    public void setNfaNodes(List<NodeNFA> nfaNodes) {
        this.nfaNodes = nfaNodes;
    }

    public void print() {
        System.out.println("K = " + begin.toString());
        System.out.println("Σ = " + charList.toString());
        System.out.println("Z = " + end.toString());
        System.out.println("lines:");
        for (Object node : nfaNodes) {
            System.out.println(node.toString());
        }
    }

    // 求ε闭包

    public Set<String> getClosure(Set<String> elements) {
        Set<String> result = new HashSet<>(elements); // 包含原有的所有元素
        for (String element : elements) {
            for (NodeNFA node:this.nfaNodes) {
                if (node.getStart().equals(element) && node.getRec().equals("ε")) {
                    result.add(node.getNext());
                }
            }
        }
        return result;
    }

    // 求弧转换

    public Set<String> getMove(Set<String> elements, String rec) {
        Set<String> result = new HashSet<>(); // 不包含原有的所有元素
        for (String element:elements) {
            for (NodeNFA node:this.nfaNodes) {
                if (node.getStart().equals(element) && node.getRec().equals(rec)) {
                    result.add(node.getNext());
                }
            }
        }
        return result;
    }

    public DFA transToDFA() {
        int i = 0;
        Map<Integer,Set<String>> marks = new HashMap<>();
        Set<Set<String>> cSet = new HashSet<>();

        // 创建第一个元素

        Set<String> element = getClosure(this.begin);

        cSet.add(element);

        // 添加并标记第一个集合

        while (!cSet.isEmpty()) {
            // 检查当
            for (String str:this.charList) {
                Set<String> t = getClosure(getMove())
            }
        }

    }
}
