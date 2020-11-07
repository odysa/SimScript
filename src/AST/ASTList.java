package AST;

import evaluator.Environment;
import parser.StoneException;
import parser.Token;

import java.util.Iterator;
import java.util.List;

public class ASTList extends ASTNode {
    protected List<ASTNode> nodes;

    public ASTList(List list) {
        nodes = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTNode node : nodes) {
            builder.append(sep);
            builder.append(node.toString());
            sep = " ";
        }
        return builder.append(')').toString();
    }

    @Override
    public Object eval(Environment env) {
        throw new StoneException("cannot eval: " + toString(), this);
    }

    @Override
    public ASTNode child(int i) {
        return nodes.get(i);
    }

    @Override
    public int numChildren() {
        return nodes.size();
    }

    @Override
    public String location() {
        for (ASTNode node : nodes) {
            String s = node.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Iterator<ASTNode> children() {
        return nodes.iterator();
    }

}
