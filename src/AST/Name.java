package AST;

import evaluator.Environment;
import parser.StoneException;
import parser.Token;

public class Name extends ASTLeaf {

    public Name(Token token) {
        super(token);
    }

    public String name() {
        return token.getText();
    }
    @Override
    public Object eval(Environment env) {
        Object value = env.get(name());
        if (value == null) {
            throw new StoneException("undefined name:" + name(), this);
        }
        return value;
    }
}
