package AST;

import evaluator.ClassInfo;
import evaluator.Environment;
import evaluator.NestedEnv;
import evaluator.StoneObject;
import parser.StoneException;

import java.util.List;

public class Dot extends Postfix {
    public Dot(List list) {
        super(list);
    }

    public String name() {
        return ((ASTLeaf) child(0)).token().getText();
    }

    public Object eval(Environment env, Object value) {
        String member = name();
        if (value instanceof ClassInfo) {
            if ("new".equals(member)) {
                ClassInfo ci = (ClassInfo) value;
                NestedEnv e = new NestedEnv(ci.environment());
                StoneObject obj = new StoneObject(e);
                initObject(ci, env);
                e.add("this", obj);
                return obj;
            }
        }
        if (value instanceof StoneObject) {
            try {
                return ((StoneObject) value).read(member);
            } catch (StoneObject.AccessException e) {

            }
        }
        throw new StoneException("bad access: " + member, this);
    }

    private void initObject(ClassInfo ci, Environment env) {
        if (ci.superClass() != null) initObject(ci.superClass(), env);
        ci.body().eval(env);
    }

    @Override
    public String toString() {
        return "." + name();
    }
}
