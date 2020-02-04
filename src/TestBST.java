import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 测试类
public class TestBST {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            bst.put(key, i);
        }

        StdOut.println("========keys()========");
        for (String s: bst.keys()) {
            StdOut.println(s + " " + bst.get(s));
        }

        StdOut.println("\n========print()========");
        bst.print();

        StdOut.println("\n========size()========");
        StdOut.println(bst.size());

        StdOut.println("\n========min()========");
        StdOut.println(bst.min());

        StdOut.println("\n========max()========");
        StdOut.println(bst.max());

        StdOut.println("\n========height0()========");
        StdOut.println(bst.height0());

        StdOut.println("\n========height1()========");
        StdOut.println(bst.height1());

        StdOut.println("\n========size()========");
        StdOut.println(bst.select(2));

        StdOut.println("\n========deleteMin()========");
        bst.deleteMin();
        bst.print();

        StdOut.println("\n========deleteMax()========");
        bst.deleteMax();
        bst.print();

        StdOut.println("\n========size()========");
        StdOut.println(bst.size());

        StdOut.println("\n========size()========");
        StdOut.println(bst.select(2));

        StdOut.println("\n========rank()========");
        StdOut.println(bst.rank("it"));
    }
}
