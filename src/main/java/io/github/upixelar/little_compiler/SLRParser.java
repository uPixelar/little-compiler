package io.github.upixelar.little_compiler;

import java.util.*;

public class SLRParser {
    /*
    TO-DO:
        Add error check
        maybe outputting parse tree?
     */
    static class RuleSet {
        String lhs;
        String[] rhs;

        RuleSet(String _lhs, String _rhsString) {
            lhs = _lhs;
            rhs = _rhsString.split(" ");
        }

        @SuppressWarnings("unused")
        String rhsString() {
            return String.join(" ", rhs);
        }
    }

    RuleSet[] rules;
    Map<Integer, Map<String, Integer>> goToTable;
    ArrayList<Map<String, String>> actionTable;

    Stack<Integer> states = new Stack<>();
    Stack<String> symbols = new Stack<>();

    List<Lexer.Token> tokens;
    ListIterator<Lexer.Token> li;
    String lookahead;

    void parse(RuleSet[] _rules, Map<Integer, Map<String, Integer>> _goToTable, ArrayList<Map<String, String>> _actionTable, List<Lexer.Token> _tokens) {
        rules = _rules;
        goToTable = _goToTable;
        actionTable = _actionTable;


        tokens = _tokens;
        li = _tokens.listIterator();

        states.push(0);
        lookahead = li.next().type.name();

        do {
            if (nextAction())
                break;
        } while (lookahead != null);
    }

    boolean nextAction() {
        String action = getAction();

        if (action.equals("accept")) {
            accept();
            return true;
        }

        doAction();
        return false;
    }

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

        System.out.println("goto:" + state);
        states.push(state);
    }

    void shift(Integer state) {
        System.out.println("shift:" + state);
        states.push(state);
        symbols.push(lookahead);
        lookahead = li.next().type.name();
    }

    void reduce(Integer rule) {
        System.out.println("reduce:" + rule);
        RuleSet ruleSet = rules[rule];

        for (int i = 0; i < ruleSet.rhs.length; i++) {
            symbols.pop();
            states.pop();
        }

        symbols.push(ruleSet.lhs);

        goTo();
    }

    void accept() {
        lookahead = null;
        System.out.println("Parse completed");
    }
}