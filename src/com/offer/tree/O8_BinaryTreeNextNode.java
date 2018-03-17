package com.offer.tree;

public class O8_BinaryTreeNextNode {

    TreeLinkNode a = new TreeLinkNode(1);
    TreeLinkNode b = new TreeLinkNode(2);
    TreeLinkNode c = new TreeLinkNode(3);
    TreeLinkNode d = new TreeLinkNode(4);
    TreeLinkNode e = new TreeLinkNode(5);
    TreeLinkNode f = new TreeLinkNode(6);
    TreeLinkNode g = new TreeLinkNode(7);
    TreeLinkNode h = new TreeLinkNode(8);
    TreeLinkNode i = new TreeLinkNode(9);

    public void init() {
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        b.next = a;
        c.next = a;
        d.next = b;
        e.next = b;
        f.next = c;
        g.next = c;
        h.next = e;
        i.next = e;
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode p = pNode;
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        while (p.next != null) {
            if (p == p.next.left) {
                return p.next;
            }
            p = p.next;
        }

        return null;
    }

    public static void main(String[] args) {
        O8_BinaryTreeNextNode test = new O8_BinaryTreeNextNode();
        TreeWalk treeWalker = new TreeWalk();
        test.init();
        treeWalker.inorderWalk(test.a);
        System.out.println();
        System.out.println(test.getNext(test.f).val);

    }
}
