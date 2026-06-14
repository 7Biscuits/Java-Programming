package CollectionFramework;

import java.util.Scanner;
import java.util.Stack;

interface EditorCommands {
    void type(String text);

    void undo();

    void view();

    void clear();
}

class TextEditor implements EditorCommands {

    Stack<String> stack = new Stack<>();

    TextEditor(Stack<String> stk) {
        this.stack = stk;
    }

    @Override
    public void type(String text) {
        stack.add(text);
    }

    @Override
    public void undo() {
        if (!stack.isEmpty()) {
            stack.pop();
            return;
        }
        System.out.println("Nothing to undo");
    }

    @Override
    public void view() {
        for (String text : stack) {
            System.out.print(text + " ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        stack.clear();
    }
}

public class StackMain {

    static void textEditor() {
        System.out.println("Welcome to Text Editor");
        TextEditor editor = new TextEditor(new Stack<String>());
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.next();

            switch (command) {
                case "type":
                    String text = sc.next();
                    editor.type(text);
                    break;

                case "undo":
                    editor.undo();
                    break;

                case "clear":
                    editor.clear();
                    break;

                case "view":
                    editor.view();
                    break;

                case "exit":
                    System.out.println("Exiting Editor...");
                    sc.close();
                    return;

                default:
                    break;
            }
        }
    }

    static void testLIFO() {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < 11; i++) {
            stk.add(i);
            System.out.println("Added " + i + " to the stack");
        }
        System.out.println("Size of the stack: " + stk.size());
        int size = stk.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stk.pop());
        }
    }

    public static void main(String[] args) {
        textEditor();
    }
}
