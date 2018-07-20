package com.leetcode.myCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L146_LRUCache {

    class LRUCache1 {
        private Map<Integer, Integer> map;
        private Object eldestKey;

        public LRUCache1(final int capacity) {
            map = new LinkedHashMap<Integer, Integer>(capacity, .75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    boolean tooBig = size() > capacity;
                    if (tooBig) {
                        eldestKey = eldest.getKey();
                    }
                    return tooBig;
                }
            };
        }

        public int get(int key) {
            Integer ans = map.get(key);
            return ans == null ? -1 : ans;
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (eldestKey != null) {
                map.remove(eldestKey);
                eldestKey = null;
            }
        }
    }

    class LRUCache {

        private int size;
        private Map<Integer, LinkedNode> map;
        private LinkedNode head;
        private LinkedNode tail;

        public LRUCache(int size) {
            this.size = size;
            map = new HashMap<Integer, LinkedNode>(size, .75F);
        }

        public int get(int key) {
            LinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                if (map.size() > 1 && tail != node)
                    moveToTail(node);
                return tail.value;
            }
        }

        public void put(int key, int value) {
            LinkedNode node = map.get(key);
            if (node == null) {
                node = new LinkedNode(key, value);
                if (map.size() >= size) {
                    // remove head node
                    if (head != null) {
                        LinkedNode tmp = head;
                        head = head.pos;
                        if (head != null) head.pre = null;
                        if (tail == tmp) tail = null;
                        map.remove(tmp.key);
                    }
                }
                map.put(key, node);
                insertTail(node);
            } else {
                // 如果节点存在，则更新节点的value，然后将几点放到末尾
                node.value = value;
                if (tail != node)
                    moveToTail(node);

            }
        }

        public void insertTail(LinkedNode node) {
            if (tail == null) {
                tail = node;
            } else {
                tail.pos = node;
                node.pre = tail;
                tail = node;
            }
            if (head == null) {
                head = tail;
            }
        }

        public void moveToTail(LinkedNode node) {
            if (tail == null) {
                return;
            } else if (head == node && tail != node) {
                head = head.pos;
                node.pos = null;
                head.pre = null;
                insertTail(node);
            } else {
                LinkedNode preNode = node.pre;
                LinkedNode posNode = node.pos;
                preNode.pos = posNode;
                posNode.pre = preNode;
                node.pos = null;
                node.pre = null;
                insertTail(node);
            }
        }

        class LinkedNode {
            private int key;
            private int value;
            private LinkedNode pre;
            private LinkedNode pos;

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
                pre = null;
                pos = null;
            }
        }
    }

    class LRUCache2 {

        private int size;
        private Map<Integer, LinkedNode> map;
        private LinkedNode head;
        private LinkedNode tail;

        public LRUCache2(int size) {
            this.size = size;
            head = new LinkedNode(-1, -1);
            tail = new LinkedNode(-1, -1);
            head.pos = tail;
            tail.pre = head;
            map = new HashMap<Integer, LinkedNode>(size, .75F);
        }

        public int get(int key) {
            LinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            else {
                int value = node.value;
                moveToTail(node);
                return value;
            }
        }

        public void put(int key, int value) {
            LinkedNode node = map.get(key);
            if (node == null) {
                node = new LinkedNode(key, value);
                if (map.size() >= size) {
                    // remove head node
                    LinkedNode tmp = head.pos;
                    LinkedNode posNode = head.pos.pos;
                    head.pos = posNode;
                    posNode.pre = head;
                    map.remove(tmp.key);

                }
                map.put(key, node);
                insertTail(node);
            } else {
                // 如果节点存在，则更新节点的value，然后将几点放到末尾
                node.value = value;
                moveToTail(node);

            }
        }

        public void insertTail(LinkedNode node) {
            LinkedNode preNode = tail.pre;
            preNode.pos = node;
            node.pre = preNode;
            node.pos = tail;
            tail.pre = node;
        }

        public void moveToTail(LinkedNode node) {
            if (tail.pre == node) return;
            LinkedNode preNode = node.pre;
            LinkedNode posNode = node.pos;
            preNode.pos = posNode;
            posNode.pre = preNode;
            insertTail(node);
        }

        class LinkedNode {
            private int key;
            private int value;
            private LinkedNode pre;
            private LinkedNode pos;

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
                pre = null;
                pos = null;
            }
        }
    }

    public static void main(String[] args) {
        L146_LRUCache test = new L146_LRUCache();
        L146_LRUCache.LRUCache2 lruCache = test.new LRUCache2(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
