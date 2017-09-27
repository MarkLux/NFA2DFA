import java.util.*;

/**
 * Created by mark on 17/9/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> charSets = new HashSet<>();

        System.out.println("Build NFA:");
        System.out.println("begin nodes:");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) {
                break;
            }
            begin.add(line);
        }

        System.out.println("end nodes:");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) {
                break;
            }
            end.add(line);
        }

        System.out.println("char sets:");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) {
                break;
            }
            charSets.add(line);
        }

        System.out.print("line count:");
        int lineCount = Integer.parseInt(sc.nextLine());
        System.out.println("input lines:");

        List<NodeNFA> nodeNFAs = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            NodeNFA node = new NodeNFA();
            System.out.println("start: ");
            node.setStart(sc.nextLine());
            System.out.println("rec: ");
            node.setRec(sc.nextLine());
            System.out.println("next: ");
            node.setNext(sc.nextLine());
            nodeNFAs.add(node);
        }

        NFA nfa = new NFA(begin,end,charSets,nodeNFAs);

        nfa.print();
    }
}
