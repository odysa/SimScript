package AST;

import parser.Token;

public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token token) {
        super(token);
    }

    public int value() {
        return token.getNumber();
    }
}
