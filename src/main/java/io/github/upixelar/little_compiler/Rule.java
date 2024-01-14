package io.github.upixelar.little_compiler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Rule {
    static Pattern patternLhs, patternRhs;

    static {
        patternLhs = Pattern.compile("\\S*(?=\\s*->)");
        patternRhs = Pattern.compile("(?<=\\||->)[^->|]*(?!\\s->)");
    }

    ArrayList<RuleSet> augmentedGrammar = new ArrayList<>();


    Rule() {

    }

    Rule(String[] ruleStrings) {
        parseArray(ruleStrings);
    }


    void parseText(String ruleText) {
        parseArray(ruleText.split("\n"));
    }

    void parseArray(String[] ruleStrings) {
        for (String rule : ruleStrings) {
            augmentedGrammar.addAll(parseSingle(rule));
        }

        String lhs = augmentedGrammar.get(0).lhs;
        augmentedGrammar.add(0, new RuleSet(lhs + "'", lhs));
    }

    private ArrayList<RuleSet> parseSingle(String rule) {
        Matcher matcherLhs = patternLhs.matcher(rule);
        if (!matcherLhs.find()) {
            System.out.println("Left Hand Side Error");
            return null;
        }
        String lhs = matcherLhs.group();

        ArrayList<RuleSet> rules = new ArrayList<>();
        Matcher matcherRhs = patternRhs.matcher(rule);
        while (matcherRhs.find()) {
            String rhs = matcherRhs.group(0).trim();
            rules.add(new RuleSet(lhs, rhs));
        }

        if (rules.isEmpty()) {
            System.out.println(rule);
            System.out.println("No Right Hand Side Found");
            return null;
        }

        return rules;
    }

    void clear() {

    }
}
