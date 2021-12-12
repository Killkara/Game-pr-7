import java.util.Stack;

public class Game {
    Stack<Integer> first, second;

    public Game(String first, String second) {
        this.first = new Stack<>();
        this.second = new Stack<>();
        for (int i = 4; i >= 0; i--) {
            this.first.push(Integer.parseInt(first.substring(i, i + 1)));
            this.second.push(Integer.parseInt(second.substring(i, i + 1)));
        }
    }

    public static void pushBack(Stack<Integer> s, Integer item) {
        Stack<Integer> ns = new Stack<>();
        while (!s.isEmpty())
            ns.push(s.pop());
        s.push(item);
        while (!ns.isEmpty())
            s.push(ns.pop());
    }

    public String play() {
        int count = 0;
        while (!first.isEmpty() && !second.isEmpty() && count <= 106) {
            if (first.peek() > second.peek()
                    && second.peek() != 0) {
                pushBack(first, first.pop());
                pushBack(first, second.pop());
            } else {
                pushBack(second, first.pop());
                pushBack(second, second.pop());
            }
            count++;
        }
        String res = "";
        if (first.isEmpty()) res += "second ";
        else res += "first ";
        res += count;
        if (count >= 106) res += " botva";
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Game("13579", "24680").play());
        System.out.println(new Game("12345", "67890").play());
        System.out.println(new Game("13029", "42685").play());
    }
}