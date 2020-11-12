package AST;

import evaluator.Environment;
import parser.StoneException;

import java.util.List;

public class Arguments extends Postfix {
    public Arguments(List<ASTNode> c) {
        super(c);
    }

    @Override
    public Object eval(Environment env, Object value) {

        if (!(value instanceof Function)) throw new StoneException("bad function", this);

        Function func = (Function) value;
        ParameterList params = func.parameters();

        if (size() != params.size()) throw new StoneException("bad number of arguments", this);
        Environment newEnv = func.newEnv();

        int num = 0;

        for (ASTNode a : nodes)
            params.eval(newEnv, num++, a.eval(env));

        return func.body().eval(newEnv);
    }

    public int size() {
        return numChildren();
    }
}