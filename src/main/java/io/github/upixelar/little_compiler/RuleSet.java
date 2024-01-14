package io.github.upixelar.little_compiler;

public class RuleSet {
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

    @Override
    public String toString() {
        return String.format("%s -> %s", lhs, rhsString());
    }
}