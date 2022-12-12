package challenge_two;

import java.util.ArrayList;

public class BooleanExpression {
    private final BooleanOperator operator;
    private final ArrayList<BooleanExpression> operands;

    public BooleanExpression(BooleanOperator operator, ArrayList<BooleanExpression> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    public boolean solve() {
//        System.out.println(this);
        return true;
    }

    @Override
    public String toString() {
        return "BooleanExpression{" +
                "operator=" + operator +
                ", operands=" + operands +
                '}';
    }
}
