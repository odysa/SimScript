package AST;

import evaluator.Environment;
import parser.Token;

public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token token) {
        super(token);
    }

    public int value() {
        return token.getNumber();
    }

    @Override
    public Object eval(Environment e) {
        return value();
    }

}
