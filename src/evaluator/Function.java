package evaluator;

import AST.BlockStmnt;
import AST.ParameterList;
import evaluator.Environment;
import evaluator.NestedEnv;

public class Function {
    protected ParameterList parameterList;
    protected BlockStmnt body;
    protected Environment env;

    public Function(ParameterList parameterList, BlockStmnt body, Environment env) {
        this.parameterList = parameterList;
        this.body = body;
        this.env = env;
    }

    public ParameterList parameters() {
        return parameterList;
    }

    public BlockStmnt body() {
        return body;
    }

    public Environment newEnv() {
        return new NestedEnv(env);
    }

    @Override
    public String toString() {
        return "<fun:" + hashCode() + ">";
    }
}
