package challenge_two;

import java.util.ArrayList;

public class BooleanExpression {
    private BooleanOperator operator;
    private ArrayList<?> operands;

    public BooleanExpression() {
        this.operator = null;
        this.operands = new ArrayList<>();
    }

    public BooleanExpression(BooleanOperator operator, ArrayList<?> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    public boolean solve() {
//        System.out.println(this);
        return true;
    }

    public BooleanOperator getOperator() {
        return operator;
    }

    public ArrayList<?> getOperands() {
        return operands;
    }

    public void setOperator(BooleanOperator operator) {
        this.operator = operator;
    }

    public void setOperands(ArrayList<BooleanExpression> operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        return "BooleanExpression{" +
                "operator=" + operator +
                ", operands=" + operands +
                '}';
    }
}
