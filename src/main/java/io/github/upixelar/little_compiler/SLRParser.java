package io.github.upixelar.little_compiler;

import java.util.*;

@SuppressWarnings("unused")
public class SLRParser {
    /*
    TO-DO:
        Add error check
        maybe outputting parse tree?
     */
    boolean success = false;

    ArrayList<RuleSet> rules;
    Map<Integer, Map<String, Integer>> goToTable;
    ArrayList<Map<String, String>> actionTable;
    boolean debug = false;

    Stack<Integer> states = new Stack<>();
    Stack<String> symbols = new Stack<>();
    Stack<ParseTreeNode> parseTree = new Stack<>();

    List<Lexer.Token> tokens;
    ListIterator<Lexer.Token> li;
    String lookahead;



    void parse(ArrayList<RuleSet> _rules, Map<Integer, Map<String, Integer>> _goToTable, ArrayList<Map<String, String>> _actionTable, List<Lexer.Token> _tokens, boolean _debug) {
        // clear all stacks
        reset();

        rules = _rules;
        goToTable = _goToTable;
        actionTable = _actionTable;
        debug = _debug;

        tokens = _tokens;
        li = _tokens.listIterator();

        parseTree.push(new ParseTreeNode("Root"));

        // start with first state
        states.push(0);
        // set lookahead to next symbol
        lookahead = li.next().type.name();

        // while there is a symbol in lookahead call nextAction(), if nextAction() is true(accepted) break loop
        do {
            nextAction();
        } while (!success);

        System.out.println("Parsed successfully!\n");
        parseTree.peek().printTree();
    }

    // get action and if its accept return True, else call doAction()
    void nextAction() {
        String action = getAction();

        if (action.equals("accept")) {
            success = true;
            return;
        }

        doAction();
    }

    // get current action from actionTable with lookahead and state
    String getAction() {
        return actionTable.get(states.peek()).get(lookahead);
    }

    Integer getGoTo() {
        return goToTable.get(states.peek()).get(symbols.peek());
    }

    void doAction() {
        String action = getAction();
        char act = action.charAt(0);
        Integer state = Integer.parseInt(action.substring(1));

        switch (act) {
            case 's':
                shift(state);
                break;

            case 'r':
                reduce(state);
                break;
        }
    }

    void goTo() {
        Integer state = getGoTo();

        if(debug)
            System.out.println("goto:" + state);

        states.push(state);
    }

    void shift(Integer state) {
        if(debug)
            System.out.println("shift:" + state);

        states.push(state);
        symbols.push(lookahead);
        parseTree.push(new ParseTreeNode(lookahead));
        lookahead = li.next().type.name();
    }

    void reduce(Integer rule) {
        RuleSet ruleSet = rules.get(rule);

        if(debug)
            System.out.println("reduce:" + rule + "RULE: "+ruleSet);

        ParseTreeNode node = new ParseTreeNode(ruleSet.lhs);

        for (int i = 0; i < ruleSet.rhs.length; i++) {
            symbols.pop();
            states.pop();
            node.addChild(parseTree.pop());
        }

        symbols.push(ruleSet.lhs);

        goTo();

        parseTree.push(node);
    }

    void reset(){
        states.clear();
        symbols.clear();
        parseTree.clear();
        success = false;
    }

    void printStates() {
        StringBuilder sb = new StringBuilder();
        sb.append("States: [");
        for (Integer state : states) {
            sb.append(state);
            sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    void printSymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbols: [");
        for (String symbol : symbols) {
            sb.append(symbol);
            sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    void printStacks() {
        printStates();
        printSymbols();
    }
}