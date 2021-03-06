import java.util.*;

/**
 * Created by mark on 17/9/25.
 */
public class NFA {
    private Set<String> K;
    private Set<String> begin;
    private Set<String> end;
    private Set<String> charList;
    private List<NodeNFA> nfaNodes;

    public NFA(Set K, Set begin, Set end, Set charList, List<NodeNFA> nfaNodes) {
        this.K = K;
        this.begin = begin;
        this.end = end;
        this.charList = charList;
        this.nfaNodes = nfaNodes;
    }

    public void print() {
        System.out.println("K = " + K.toString());
        System.out.println("S = " + begin.toString());
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

        List<String> array = new ArrayList<>();

        for (String e : result) {
            array.add(e);
        }

        int i = 0;

            while (i < array.size()) {
            for (NodeNFA node : this.nfaNodes) {
                if (node.getStart().equals(array.get(i)) && node.getRec().equals("ε")) {
                    array.add(node.getNext());
                    result.add(node.getNext());
                }
            }
            i++;
        }

//        System.out.println("closure of " + elements.toString() + " is: " + result.toString());
        return result;
    }

    // 求弧转换

    public Set<String> getMove(Set<String> elements, String rec) {
        Set<String> result = new HashSet<>(); // 不包含原有的所有元素
        for (String element : elements) {
            for (NodeNFA node : this.nfaNodes) {
                if (node.getStart().equals(element) && node.getRec().equals(rec)) {
                    result.add(node.getNext());
                }
            }
        }
        return result;
    }

    public DFA transToDFA() {

        Set<String> K = new HashSet<>(); // 所有状态集
        Set<String> begins = new HashSet<>(); // 起始状态集
        Set<String> ends = new HashSet<>(); // 终止状态集
        List<NodeDFA> lines = new ArrayList<>(); // 弧集合

        List<Set<String>> queue = new ArrayList<>();

        // 创建初始的闭包
        Set<String> next = this.getClosure(this.begin);

        Integer i = 0;

        queue.add(next);

        begins.add("0");

        if (isSetEnds(next)) {
            ends.add(i.toString());
        }

        K.add(i.toString());

        // 开始循环

        while (i < queue.size()) {
            for (String rec : this.charList) {
                Set<String> t = this.getClosure(this.getMove(queue.get(i), rec));
                if (t.size() == 0) {
                    continue;
                }

                // 检查是否已经标记过

                Integer index = isSetInQueue(t, queue);

                if (index == -1) {
                    index = queue.size();
                    K.add(index.toString());
                    if (isSetEnds(t)) {
                        ends.add(index.toString());
                    }
                    queue.add(t);
                }

                // 添加边
                lines.add(new NodeDFA(i.toString(), rec, index.toString()));
            }
            i++;
        }

        return new DFA(K, begins, ends, this.charList, lines);
    }

    private Integer isSetInQueue(Set<String> set, List<Set<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (set.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSetEnds(Set<String> set) {
        for (String str : set) {
            for (String e : this.end) {
                if (e.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
