package io.github.upixelar.little_compiler;

import java.util.ArrayList;
import java.util.List;

public class ParseTreeNode {
    String symbol;
    List<ParseTreeNode> children = new ArrayList<>();

    ParseTreeNode(String _symbol){
        symbol = _symbol;
    }

    void addChild(ParseTreeNode child){
        children.add(child);
    }

    void printTree() {
        System.out.println("Parse Tree:");
        printTree(this, 0);
    }

    void printTree(ParseTreeNode node, int depth) {
        String sb = "| ".repeat(Math.max(0, depth)) +
                node.symbol;
        System.out.println(sb);
        for (ParseTreeNode child : node.children) {
            printTree(child, depth + 1);
        }
    }
}
