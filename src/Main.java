import java.util.*;

/**
 * Created by mark on 17/9/26.
 */
public class Main {

    /**
     * 从键盘输入
     */

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Set<String> begin = new HashSet<>();
//        Set<String> end = new HashSet<>();
//        Set<String> charSets = new HashSet<>();
//
//        System.out.println("Build NFA:");
//        System.out.println("begin nodes:");
//        while (true) {
//            String line = sc.nextLine();
//            if (line.equals("")) {
//                break;
//            }
//            begin.add(line);
//        }
//
//        System.out.println("end nodes:");
//        while (true) {
//            String line = sc.nextLine();
//            if (line.equals("")) {
//                break;
//            }
//            end.add(line);
//        }
//
//        System.out.println("char sets:");
//        while (true) {
//            String line = sc.nextLine();
//            if (line.equals("")) {
//                break;
//            }
//            charSets.add(line);
//        }
//
//        System.out.print("line count:");
//        int lineCount = Integer.parseInt(sc.nextLine());
//        System.out.println("input lines:");
//
//        List<NodeNFA> nodeNFAs = new ArrayList<>();
//        for (int i = 0; i < lineCount; i++) {
//            NodeNFA node = new NodeNFA();
//            System.out.println("start: ");
//            node.setStart(sc.nextLine());
//            System.out.println("rec: ");
//            node.setRec(sc.nextLine());
//            System.out.println("next: ");
//            node.setNext(sc.nextLine());
//            nodeNFAs.add(node);
//        }
//
//        NFA nfa = new NFA(begin,end,charSets,nodeNFAs);
//    }

    /**
     * 书上的示范例子
     * @param args
     */

    public static void main(String args[]) {
        Set<String> K = new HashSet<>();
        Set<String> begin = new HashSet<>();
        Set<String> ends = new HashSet<>();
        Set<String> charList = new HashSet<>();
        List<NodeNFA> nodeNFAS = new ArrayList<>();


        for (int i = 0; i <= 10; i++) {
            K.add(String.valueOf(i));
        }

//        for (int i=0;i<=9;i++) {
//            begin.add(String.valueOf(i));
//        }
        begin.add("0");
        ends.add("10");

        charList.add("a");
        charList.add("b");

        NodeNFA n = new NodeNFA("0","ε","1");
        nodeNFAS.add(n);

        n = new NodeNFA("1","ε","2");
        nodeNFAS.add(n);

        n = new NodeNFA("1","ε","4");
        nodeNFAS.add(n);

        n = new NodeNFA("2","a","3");
        nodeNFAS.add(n);

        n = new NodeNFA("4","b","5");
        nodeNFAS.add(n);

        n = new NodeNFA("3","ε","6");
        nodeNFAS.add(n);

        n = new NodeNFA("5","ε","6");
        nodeNFAS.add(n);

        n = new NodeNFA("6","ε","1");
        nodeNFAS.add(n);

        n = new NodeNFA("0","ε","7");
        nodeNFAS.add(n);

        n = new NodeNFA("6","ε","7");
        nodeNFAS.add(n);

        n = new NodeNFA("7","a","8");
        nodeNFAS.add(n);

        n = new NodeNFA("8","b","9");
        nodeNFAS.add(n);

        n = new NodeNFA("9","b","10");
        nodeNFAS.add(n);

        NFA nfa = new NFA(K,begin,ends,charList,nodeNFAS);

        System.out.println("NFA: ");

        nfa.print();

        DFA dfa = nfa.transToDFA();

        dfa.print();

    }
}
