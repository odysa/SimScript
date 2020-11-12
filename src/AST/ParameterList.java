package AST;

import evaluator.Environment;

import java.util.List;

public class ParameterList extends ASTList {

    public ParameterList(List list) {
        super(list);
    }

    public String name(int i) {
        return ((ASTLeaf) child(i)).token().getText();
    }
    public void eval(Environment env, int index, Object value) {
       env.add(name(index), value);
    }
    public int size() {
        return numChildren();
    }
}
