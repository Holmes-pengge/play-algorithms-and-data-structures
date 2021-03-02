/// Leetcode 804. Unique Morse Code Words
/// https://leetcode.com/problems/unique-morse-code-words/description/
///
/// 课程中在这里暂时没有介绍这个问题
/// 该代码主要用于使用Leetcode上的问题测试我们的BST类
public class Solution {

    private class BST<E extends Comparable<E>> {

        private class Node {
            public E e;
            public Node left, right;

            public Node(E e) {
                this.e = e;
                left = null;
                right = null;
            }
        }

        private Node root;
        private int size;

        public BST(){
            root = null;
            size = 0;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void add(E e){

            if(root == null){
                root = new Node(e);
                size ++;
                return;
            }

            Node p = root;
            while(p != null){

                if(e.compareTo(p.e) < 0){
                    if(p.left == null){
                        p.left = new Node(e);
                        size ++;
                        return;
                    }
                    p = p.left;
                }
                else if(e.compareTo(p.e) > 0){
                    if(p.right == null){
                        p.right = new Node(e);
                        size ++;
                        return;
                    }
                    p = p.right;
                }
                else return;
            }
        }
    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BST<String> bst = new BST<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            bst.add(res.toString());
        }

        return bst.size();
    }
}
