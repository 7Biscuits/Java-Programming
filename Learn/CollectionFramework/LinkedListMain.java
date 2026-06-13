package CollectionFramework;

import java.util.LinkedList;
import java.util.Scanner;

/*
Implemented a browser history navigation system using linkedlists

visit <url> -> adds an element in the linkedlist and url becomes current webpage and forward history is cleared.
back -> shifts the pointer to previous opened webpage (disabled if none exist)
forward -> shifts the pointer to previous opened webpage

*/

interface HistoryMethods {
    void visit(String url);

    void back();

    void forward();

    void clear();

    void view();
}

class BrowserHistoryNavigation implements HistoryMethods {
    protected LinkedList<String> history = new LinkedList<>();
    private String currentUrl;
    int currentIndex = -1;

    public BrowserHistoryNavigation(LinkedList<String> list) {
        history = list;
    }

    @Override
    public void visit(String url) {

        // Remove forward history
        while (history.size() > currentIndex + 1) {
            history.removeLast();
        }

        history.add(url);

        currentUrl = url;
        currentIndex = history.size() - 1;
    }

    @Override
    public void back() {
        if (history.isEmpty() || currentIndex <= 0) {
            System.out.println("No page to back to.");
            return;
        }
        currentIndex--;
        currentUrl = history.get(currentIndex);
    }

    @Override
    public void forward() {
        if (currentIndex + 1 < history.size()) {
            currentIndex++;
            currentUrl = history.get(currentIndex);
            return;
        }
        System.out.println("No page to go forward to.");
    }

    @Override
    public void clear() {
        history.clear();
    }

    @Override
    public void view() {
        for (String url : history) {
            if (url.equalsIgnoreCase(currentUrl)) {
                System.out.print("*" + url + " -> ");
                continue;
            }
            System.out.print(url + " -> ");
        }
        System.out.println();
    }

}

public class LinkedListMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Browser History Navigation System");
        BrowserHistoryNavigation browser = new BrowserHistoryNavigation(new LinkedList<String>());
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.next();

            switch (command) {
                case "visit":
                    String url = sc.next();
                    browser.visit(url);
                    break;

                case "back":
                    browser.back();
                    break;

                case "forward":
                    browser.forward();
                    break;

                case "clear":
                    browser.clear();
                    break;

                case "view":
                    browser.view();
                    break;

                case "exit":
                    System.out.println("Exiting browser...");
                    sc.close();
                    return;

                default:
                    break;
            }
        }
    }
}
