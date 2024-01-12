package io.github.upixelar.little_compiler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lexer {
    public enum TokenType {
        Or, // 25
        And, // abc
        Not, // +
        LParenthesis, // *
        RParenthesis,
        True,
        False,
        Identifier,
        EOF,
    }

    public static class Token {
        public TokenType type;
        public String text;
        public Integer startPos;

        public Token(TokenType type, String text, Integer startPos) {
            this.type = type;
            this.text = text;
            this.startPos = startPos;
        }

        public Token(TokenType type, Character character, Integer startPos){
            this(type, character.toString(), startPos);
        }

        @Override
        public String toString() {
            return String.format("%s : <%s> at %d", text, type, startPos);
        }
    }

    private static final Map<String, TokenType> keywords = new HashMap<>();

    static{
        keywords.put("OR", TokenType.Or);
        keywords.put("AND", TokenType.And);
        keywords.put("NOT", TokenType.Not);
        keywords.put("(", TokenType.LParenthesis);
        keywords.put(")", TokenType.RParenthesis);
        keywords.put("True", TokenType.True);
        keywords.put("False", TokenType.False);
    }

    public List<Token> lex(String input){
        List<Token> tokens = new LinkedList<>();
        int currentPos = 0;
        int inputLen = input.length();
        StringBuilder string = new StringBuilder();
        while(currentPos < inputLen){
            int tokenStartPos = currentPos;
            Character character = input.charAt(currentPos);
            if(Character.isWhitespace(character)){
                currentPos++; // ignore whitespace
            }else if(Character.isLetter(character)){
                while(currentPos<inputLen && Character.isLetterOrDigit(character)){
                    string.append(character);
                    currentPos++;
                    if(currentPos<inputLen)
                        character = input.charAt(currentPos);
                }
                String text = string.toString();
                string.setLength(0);
                TokenType keyword = keywords.get(text);
                tokens.add(new Token(keyword!=null?keyword:TokenType.Identifier, text, tokenStartPos));
            }else{
                TokenType tokenType = keywords.get(character.toString());
                if(tokenType == null){
                    try{
                        throw new LexerException("Unexpected character: " + character, currentPos);
                    }catch (LexerException ex){

                        //noinspection CallToPrintStackTrace
                        ex.printStackTrace();
                        currentPos++;
                    }
                    continue;
                }
                tokens.add(new Token(tokenType, character, currentPos));
                currentPos++;

            }
        }
        tokens.add(new Token(TokenType.EOF, "<EOF>", currentPos));
        return tokens;
    }
    public static class LexerException extends Exception {
        public LexerException(String message, int position) {
            super("Lexer error at position " + position + ": " + message);
        }
    }

}
