package com.offer.tree;

/**
 * 序列化和反序列化二叉树
 *
 * 序列化算法：
 * 前序遍历二叉树，遍历到null节点存为"#"，然后在每个字符之间插入","
 *
 * 反序列化算法：
 * 将原字符串按照","分割为一个字符串数组，按照前序遍历顺序，如果读到数字字符
 * 则新建节点，如果读到"#"则返回null
 */
public class O37_SerializeTree {
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        serializeCore(root, str);
        return str.toString();
    }

    public void serializeCore(TreeNode pNode, StringBuilder str) {
        if (pNode == null) {
            str.append("#,");
            return;
        } else {
            str.append(pNode.val);
            str.append(',');
            serializeCore(pNode.left, str);
            serializeCore(pNode.right, str);
        }
    }

    public TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");

        return deserializeCore(strs);
    }

    public int index = -1;
    public TreeNode deserializeCore(String[] strs) {
        index++;
        if (!strs[index].equals("#")) {
            TreeNode pNode = new TreeNode(Integer.parseInt(strs[index]));
            pNode.left = deserializeCore(strs);
            pNode.right = deserializeCore(strs);
            return pNode;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        a3.right = a6;
        O37_SerializeTree test = new O37_SerializeTree();
        String str = test.Serialize(a1);
        System.out.println(str);
        TreeNode temp = test.Deserialize(str);
    }
}
