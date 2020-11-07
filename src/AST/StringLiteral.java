package AST;

import evaluator.Environment;
import parser.Token;

public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token token) { super(token); }
    public String value() { return token().getText(); }
    @Override
    public Object eval(Environment e) {
        return value();
    }

}