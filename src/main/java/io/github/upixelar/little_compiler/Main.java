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

    public static void main(String[] args) {
        String[] rules = {
                "E -> E OR T | T",
                "T -> T AND F | F",
                "F -> NOT F | ( E ) | V | True | False",
                "V -> id"
        };

        Rule rule = new Rule(rules);

        Lexer lexer = new Lexer();
        SLRParser parser = new SLRParser();

        String[] examples = {
                "id OR True AND (id AND id)",
                "True AND False OR NOT (False OR True)",
                "NOT id AND True",
                "NOT ready AND (processing OR NOT idle)"
        };

        // If you set it to true it will print every shift, reduce, goto actions
        boolean debug = false;

        for(String example:examples){
            System.out.println("Parsing \""+example+'"');
            parser.parse(rule.augmentedGrammar, getGoToTable(), getActionTable(), lexer.lex(example), debug);
        }



    }
}