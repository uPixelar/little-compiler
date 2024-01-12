package io.github.upixelar.little_compiler;

import java.util.*;

public class Main {

    static ArrayList<Map<String, String>> getActionTable() {
        ArrayList<Map<String, String>> actionTable = new ArrayList<>();

        // BEGIN adding states
        // I0
        actionTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9"
        ));

        // I1
        actionTable.add(Map.of(
                "Or", "s10",
                "EOF", "accept"
        ));

        // I2
        actionTable.add(Map.of(
                "Or", "r2",
                "And", "s11",
                "RParenthesis", "r2",
                "EOF", "r2"
        ));

        // I3
        actionTable.add(Map.of(
                "Or", "r4",
                "And", "r4",
                "RParenthesis", "r4",
                "EOF", "r4"
        ));

        // I4
        actionTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9"
        ));

        // I5
        actionTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9"
        ));

        // I6
        actionTable.add(Map.of(
                "Or", "r7",
                "And", "r7",
                "RParenthesis", "r7",
                "EOF", "r7"
        ));

        // I7
        actionTable.add(Map.of(
                "Or", "r8",
                "And", "r8",
                "RParenthesis", "r8",
                "EOF", "r8"
        ));

        // I8
        actionTable.add(Map.of(
                "Or", "r9",
                "And", "r9",
                "RParenthesis", "r9",
                "EOF", "r9"
        ));

        // I9
        actionTable.add(Map.of(
                "Or", "r10",
                "And", "r10",
                "RParenthesis", "r10",
                "EOF", "r10"
        ));

        // I10
        actionTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9"
        ));

        // I11
        actionTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9"
        ));

        // I12
        actionTable.add(Map.of(
                "Or", "r5",
                "And", "r5",
                "RParenthesis", "r5",
                "EOF", "r5"
        ));

        // I13
        actionTable.add(Map.of(
                "Or", "s10",
                "RParenthesis", "s16"
        ));

        // I14
        actionTable.add(Map.of(
                "Or", "r1",
                "And", "s11",
                "RParenthesis", "r1",
                "EOF", "r1"
        ));

        // I15
        actionTable.add(Map.of(
                "Or", "r3",
                "And", "r3",
                "RParenthesis", "r3",
                "EOF", "r3"
        ));

        // I16
        actionTable.add(Map.of(
                "Or", "r6",
                "And", "r6",
                "RParenthesis", "r6",
                "EOF", "r6"
        ));
        // END adding states

        return actionTable;
    }

    static Map<Integer, Map<String, Integer>> getGoToTable() {
        Map<Integer, Map<String, Integer>> goToTable = new HashMap<>();

        // BEGIN adding states
        // I0
        goToTable.put(0, Map.of(
                "E", 1,
                "T", 2,
                "F", 3,
                "V", 6
        ));

        // I1
        // I2
        // I3

        // I4
        goToTable.put(4, Map.of(
                "F", 12,
                "V", 6
        ));

        // I5
        goToTable.put(5, Map.of(
                "E", 13,
                "T", 2,
                "F", 3,
                "V", 6
        ));

        // I6
        // I7
        // I8
        // I9

        // I10
        goToTable.put(10, Map.of(
                "T", 14,
                "F", 3,
                "V", 6
        ));

        // I11
        goToTable.put(11, Map.of(
                "F", 15,
                "V", 6
        ));

        // I12
        // I13
        // I14
        // I15
        // I16

        // END adding states

        return goToTable;
    }

    @SuppressWarnings("unused")
    static ArrayList<Map<String, String>> getParseTable() {
        // TO-DO FIX
        // class java.util.ImmutableCollections$MapN cannot be cast to class java.util.HashMap

        ArrayList<Map<String, String>> parseTable = new ArrayList<>();

        // BEGIN adding states
        // I0
        parseTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9",
                "E", "g1",
                "T", "g2",
                "F", "g3",
                "V", "g6"
        ));

        // I1
        parseTable.add(Map.of(
                "Or", "s10",
                "EOF", "accept"
        ));

        // I2
        parseTable.add(Map.of(
                "Or", "r2",
                "And", "s11",
                "RParenthesis", "r2",
                "EOF", "r2"
        ));

        // I3
        parseTable.add(Map.of(
                "Or", "r4",
                "And", "r4",
                "RParenthesis", "r4",
                "EOF", "r4"
        ));

        // I4
        parseTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9",
                "F", "g12",
                "V", "g6"
        ));

        // I5
        parseTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9",
                "E", "g13",
                "T", "g2",
                "F", "g3",
                "V", "g6"
        ));

        // I6
        parseTable.add(Map.of(
                "Or", "r7",
                "And", "r7",
                "RParenthesis", "r7",
                "EOF", "r7"
        ));

        // I7
        parseTable.add(Map.of(
                "Or", "r8",
                "And", "r8",
                "RParenthesis", "r8",
                "EOF", "r8"
        ));

        // I8
        parseTable.add(Map.of(
                "Or", "r9",
                "And", "r9",
                "RParenthesis", "r9",
                "EOF", "r9"
        ));

        // I9
        parseTable.add(Map.of(
                "Or", "r10",
                "And", "r10",
                "RParenthesis", "r10",
                "EOF", "r10"
        ));

        // I10
        parseTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9",
                "T", "g14",
                "F", "g3",
                "V", "g6"
        ));

        // I11
        parseTable.add(Map.of(
                "Not", "s4",
                "LParenthesis", "s5",
                "True", "s7",
                "False", "s8",
                "Identifier", "s9",
                "F", "g15",
                "V", "g6"
        ));

        // I12
        parseTable.add(Map.of(
                "Or", "r5",
                "And", "r5",
                "RParenthesis", "r5",
                "EOF", "r5"
        ));

        // I13
        parseTable.add(Map.of(
                "Or", "s10",
                "RParenthesis", "s16"
        ));

        // I14
        parseTable.add(Map.of(
                "Or", "r1",
                "And", "s11",
                "RParenthesis", "r1",
                "EOF", "r1"
        ));

        // I15
        parseTable.add(Map.of(
                "Or", "r3",
                "And", "r3",
                "RParenthesis", "r3",
                "EOF", "r3"
        ));

        // I16
        parseTable.add(Map.of(
                "Or", "r6",
                "And", "r6",
                "RParenthesis", "r6",
                "EOF", "r6"
        ));
        // END adding states

        return parseTable;
    }

    static SLRParser.RuleSet[] getRules(){
        return new SLRParser.RuleSet[]{
                new SLRParser.RuleSet("E'", "E"),
                new SLRParser.RuleSet("E", "E OR T"),
                new SLRParser.RuleSet("E", "T"),
                new SLRParser.RuleSet("T", "T AND F"),
                new SLRParser.RuleSet("T", "F"),
                new SLRParser.RuleSet("F", "NOT F"),
                new SLRParser.RuleSet("F", "( E )"),
                new SLRParser.RuleSet("F", "V"),
                new SLRParser.RuleSet("F", "True"),
                new SLRParser.RuleSet("F", "False"),
                new SLRParser.RuleSet("V", "id")
        };
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        SLRParser parser = new SLRParser();

        String input = "(True AND False) OR id";
        List<Lexer.Token> tokens = lexer.lex(input);
        parser.parse(getRules(), getGoToTable(), getActionTable(), tokens);

    }
}