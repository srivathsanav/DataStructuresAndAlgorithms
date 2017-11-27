import java.util.HashMap;

/**
 * Created by avsrivathsan on 6/19/2017.
 */
public class Trie {


    class TrieNode {
        private char character;

        private HashMap<Character, TrieNode> childNodes ;

        private boolean terminates = false;

        public TrieNode() {
            childNodes = new HashMap<Character, TrieNode>();
        }

        public TrieNode(char ch) {
            this();
            this.character = ch;
        }

        public void addWord(String input) {

        }

        private void addWord(String input, int index) {
            if (index == input.length()) {
                TrieNode node = childNodes.get(character);
                if (node == null) {
                    node = new TrieNode(input.charAt(index));
                    childNodes.put(character, node);
                }
                node.terminates = true;
            } else {
                Character character = input.charAt(index);
                TrieNode node = childNodes.get(character);
                if (node == null) {
                     node = new TrieNode(input.charAt(index));
                     childNodes.put(character, node);
                }
                node.addWord(input, index+1);
            }
        }

        public TrieNode getChild(char ch) {
            return childNodes.get(ch);
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public boolean isTerminates() {
            return terminates;
        }

        public void setTerminates(boolean terminates) {
            this.terminates = terminates;
        }
    }
}
