import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class TrieNode {
    Map<Character, TrieNode> children;
    int value;
    char letter;
    public TrieNode(char ch) {
        children = new HashMap<Character, TrieNode>();
        value = 0;
        letter = ch;
    }
}
public class FindNameWithTrie {
    static TrieNode _dictionary = new TrieNode('*');
    public static void add(String name) {
        TrieNode head = _dictionary;
        for(int i=0; i<name.length(); i++) {
            if(!(head.children.containsKey(name.charAt(i)))) {
                head.children.put(name.charAt(i), new TrieNode(name.charAt(i)));
            }
            head.children.get(name.charAt(i)).value += 1;
            head = head.children.get(name.charAt(i));
        }
        head.children.put(name.charAt(name.length()-1), new TrieNode('*'));
    }
    public static int find(String name) {
        TrieNode head = _dictionary;
        int count = 0;
        for(int i=0; i<name.length(); i++) {
            if(!head.children.containsKey(name.charAt(i))) {
                return 0;
            } 
            count = head.children.get(name.charAt(i)).value;
            head = head.children.get(name.charAt(i));
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                add(contact);
            } else if(op.equals("find")) {
                System.out.print(find(contact)+"\n");
            }
        }
    }
}
