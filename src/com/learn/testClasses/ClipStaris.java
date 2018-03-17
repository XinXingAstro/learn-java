package com.learn.testClasses;

public class ClipStaris {
    public static void main(String[] args) {
        Tree root = new Tree(0, 2);
        System.out.println(root.search(root));
    }
}
class Tree {
    public static int res;
    public static int ans;
    public static int n;
    int value;
    Tree rChild;
    Tree lChild;

    public Tree(int value, int n) {
        this.value = value;
        Tree.n = n;
    }

    public int search(Tree t) {
        res += t.value;

        if (res < n) {
            t.lChild = new Tree(1, n);
            search(t.lChild);
            res--;
            if ((n - res) >= 2) {
                t.rChild = new Tree(2, n);
                search(t.rChild);
            }
            return ans;
        } else if (res == n) {
            ans++;
            return ans;
        }

        return ans;
    }
}
