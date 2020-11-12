package AST;

import evaluator.Environment;
import parser.StoneException;

import java.util.List;

public class Arguments extends Postfix {
    public Arguments(List<ASTNode> c) {
        super(c);
    }

    private Object funcEval(Environment env, Object value) {
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

    @Override
    public Object eval(Environment callerEnv, Object value) {
        if (!(value instanceof NativeFunction))
            return funcEval(callerEnv, value);

        NativeFunction func = (NativeFunction) value;
        int nparams = func.numOfParameters();
        if (size() != nparams)
            throw new StoneException("bad number of arguments", this);
        Object[] args = new Object[nparams];
        int num = 0;
        for (ASTNode a : this) {
            ASTNode ae =  a;
            args[num++] = ae.eval(callerEnv);
        }
        return func.invoke(args, this);
    }

    public int size() {
        return numChildren();
    }
}