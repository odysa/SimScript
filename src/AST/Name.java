package AST;

import parser.Token;

public class Name extends ASTLeaf {

    public Name(Token token) {
        super(token);
    }

    public String name() {
        return token.getText();
    }
}
