package com.example.casestudy1;

class Calculator {
    private String history, current;
    private double operand1, operand2, memory;
    private Operator operator;
    private boolean flag, firstFlag;

    private enum Operator {NONE, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, PERCENTAGE}

    Calculator() {
        operand1 = 0;
        operand2 = 0;
        memory = 0;
        operator = Operator.NONE;
        history = "";
        current = "0";
        flag = false;
        firstFlag = false;
    }

    String getHistory() {
        return history;
    }

    String getCurrent() {
        return current;
    }

    double getMemory() {
        return memory;
    }

    void operandClicked(double num) {
        if (flag) {
            int temp = (int) operand1;
            String temp1 = temp + "." + (int) num;
            operand1 = Double.parseDouble(temp1);
            current = String.valueOf(operand1);
            flag = false;
        } else {
            operand1 = operand1 * 10 + num;
            current = String.valueOf((int) operand1);
        }
    }

    void additionClicked() {
        if (operator == Operator.NONE) {
            operand2 = operand1;
            operator = Operator.ADDITION;
            operand1 = 0;
            history += operand2 + "+";
            current = String.valueOf(operand1);
        } else {
            equalClicked();
            history += "+";
            current = String.valueOf(operand1);
            operator = Operator.ADDITION;
        }
    }

    void subtractionClicked() {
        if (operator == Operator.NONE) {
            operand2 = operand1;
            operator = Operator.SUBTRACTION;
            operand1 = 0;
            history += operand2 + "-";
            current = String.valueOf(operand1);
        } else {
            equalClicked();
            history += "-";
            current = String.valueOf(operand1);
            operator = Operator.SUBTRACTION;
        }
    }

    void multiplicationClicked() {
        if (operator == Operator.NONE) {
            operand2 = operand1;
            operator = Operator.MULTIPLICATION;
            operand1 = 0;
            history += operand2 + "*";
            current = String.valueOf(operand1);
        } else {
            equalClicked();
            history += "-";
            current = String.valueOf(operand1);
            operator = Operator.MULTIPLICATION;
        }
    }

    void divisionClicked() {
        if (operator == Operator.NONE) {
            operand2 = operand1;
            operator = Operator.DIVISION;
            operand1 = 0;
            history += operand2 + "/";
            current = String.valueOf(operand1);
        } else {
            equalClicked();
            history += "/";
            current = String.valueOf(operand1);
            operator = Operator.DIVISION;
        }
    }

    void percentageClicked() {
        if (operator == Operator.NONE) {
            operand2 = operand1;
            operator = Operator.PERCENTAGE;
            operand1 = 0;
            history += operand2 + "%";
            current = String.valueOf(operand1);
        } else {
            equalClicked();
            history += "%";
            current = String.valueOf(operand1);
            operator = Operator.PERCENTAGE;
        }
    }

    void equalClicked() {
        switch (operator) {
            case NONE:
                break;
            case ADDITION:
                addition();
                break;
            case SUBTRACTION:
                subtraction();
                break;
            case MULTIPLICATION:
                multiplication();
                break;
            case DIVISION:
                division();
                break;
            case PERCENTAGE:
                percentage();
                break;
        }
    }

    void clearAll() {
        operand1 = 0;
        operand2 = 0;
        memory = 0;
        operator = Operator.NONE;
        history = "";
        current = "0";
        flag = false;
    }

    void memoryAdd() {
        equalClicked();
        memory += operand2;
        operand1 = 0;
        operand2 = 0;
        history = "";
        current = operand2 + "";
        operator = Operator.NONE;
    }

    void memorySubtract() {
        equalClicked();
        memory -= operand2;
        operand1 = 0;
        operand2 = 0;
        history = "";
        current = operand2 + "";
        operator = Operator.NONE;
    }

    void memoryRecall() {
        current = memory + "";
    }

    void memoryClear() {
        clearAll();
    }

    void dotClicked() {
        flag = true;
        firstFlag = true;
    }

    private void addition() {
        history += operand1;
        operand2 += operand1;
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }

    private void subtraction() {
        history += operand1;
        operand2 -= operand1;
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }

    private void multiplication() {
        history += operand1;
        operand2 *= operand1;
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }

    private void division() {
        history += operand1;
        operand2 /= operand1;
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }

    private void percentage() {
        operand2 /= 100;
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }
}
