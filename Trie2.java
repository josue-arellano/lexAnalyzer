package lexAnalyzer;
import java.util.Vector;

public class Trie2 {
    private static final int ALPHA_SIZE = 52;
    int[] switchArray = new int[ALPHA_SIZE];
    Vector<Node> symbols = new Vector<>();

    private class Node {
        private char symbol;
        private int next;

        Node(char symbol) {
            this.symbol = symbol;
            next = -1;
        }

        int getNext() {
            return next;
        }

        char getSymbol() {
            return symbol;
        }

        void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        void setNext(int next) {
            this.next = next;
        }
    }

    Trie() {
        
    }
}