package parser;

public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        Token t;
        for (;(t = l.read()) != Token.EOF; ) {
            System.out.println("=>" + t.getText());
        }
    }
}
