package com.example.casestudy1;

class Calculator {
    private String history, current;
    private double operand1, operand2, memory;
    private Operator operator;
    private boolean firstFlag, flag;

    private enum Operator {NONE, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, PERCENTAGE}

    Calculator() {
        operand1 = 0;
        operand2 = 0;
        memory = 0;
        operator = Operator.NONE;
        history = "";
        current = "0";
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
        if (firstFlag) {
            if (flag) {
                int temp = (int) operand1;
                String temp1 = temp + "." + (int) num;
                operand1 = Double.parseDouble(temp1);
                current = String.valueOf(operand1);
                flag = false;
            } else {
                double temp = operand1;
                String temp1 = temp + "" + (int) num;
                operand1 = Double.parseDouble(temp1);
                current = String.valueOf(operand1);
            }
        } else {
            operand1 = operand1 * 10 + num;
            current = String.valueOf((int) operand1);
        }
    }

    void additionClicked() {
        firstFlag = false;

        // Checking if user changed operator choice
        if (operand1 == 0) {
            operator = Operator.ADDITION;
            history = history.substring(0, history.length() - 1) + "+";
        } else {
            // Checking if Operator is NONE
            if (operator == Operator.NONE) {
                // Checking if Operator is called after equalTo
                if (operand1 == 0) {
                    operand1 = Double.parseDouble(current);
                    operand2 = operand1;
                    operator = Operator.ADDITION;
                    operand1 = 0;
                    history = operand2 + "+";
                    current = String.valueOf(operand1);
                } else {
                    operand2 = operand1;
                    operator = Operator.ADDITION;
                    operand1 = 0;
                    history += operand2 + "+";
                    current = String.valueOf(operand1);
                }
            } else {
                equalClicked();
                history += "+";
                current = String.valueOf(operand1);
                operator = Operator.ADDITION;
            }
        }
    }

    void subtractionClicked() {
        firstFlag = false;
        if (operand1 == 0) {
            operator = Operator.SUBTRACTION;
            history = history.substring(0, history.length() - 1) + "-";
        } else {
            if (operator == Operator.NONE) {
                if (operand1 == 0) {
                    operand1 = Double.parseDouble(current);
                    operand2 = operand1;
                    operator = Operator.SUBTRACTION;
                    operand1 = 0;
                    history = operand2 + "-";
                    current = String.valueOf(operand1);
                } else {
                    operand2 = operand1;
                    operator = Operator.SUBTRACTION;
                    operand1 = 0;
                    history += operand2 + "-";
                    current = String.valueOf(operand1);
                }
            } else {
                equalClicked();
                history += "-";
                current = String.valueOf(operand1);
                operator = Operator.SUBTRACTION;
            }
        }
    }

    void multiplicationClicked() {
        firstFlag = false;
        if (operand1 == 0) {
            operator = Operator.MULTIPLICATION;
            history = history.substring(0, history.length() - 1) + "*";
        } else {
            if (operator == Operator.NONE) {
                if (operand1 == 0) {
                    operand1 = Double.parseDouble(current);
                    operand2 = operand1;
                    operator = Operator.MULTIPLICATION;
                    operand1 = 0;
                    history = operand2 + "*";
                    current = String.valueOf(operand1);
                } else {
                    operand2 = operand1;
                    operator = Operator.MULTIPLICATION;
                    operand1 = 0;
                    history += operand2 + "*";
                    current = String.valueOf(operand1);
                }
            } else {
                equalClicked();
                history += "*";
                current = String.valueOf(operand1);
                operator = Operator.MULTIPLICATION;
            }
        }
    }

    void divisionClicked() {
        firstFlag = false;
        if (operand1 == 0) {
            operator = Operator.DIVISION;
            history = history.substring(0, history.length() - 1) + "/";
        } else {
            if (operator == Operator.NONE) {
                if (operand1 == 0) {
                    operand1 = Double.parseDouble(current);
                    operand2 = operand1;
                    operator = Operator.DIVISION;
                    operand1 = 0;
                    history = operand2 + "/";
                    current = String.valueOf(operand1);
                } else {
                    operand2 = operand1;
                    operator = Operator.DIVISION;
                    operand1 = 0;
                    history += operand2 + "/";
                    current = String.valueOf(operand1);
                }
            } else {
                equalClicked();
                history += "/";
                current = String.valueOf(operand1);
                operator = Operator.DIVISION;
            }
        }
    }

    void percentageClicked() {
        firstFlag = false;
        if (operand1 == 0) {
            operator = Operator.PERCENTAGE;
            history = history.substring(0, history.length() - 1) + "%";
        } else {
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
        firstFlag = false;
    }

    void memoryAdd() {
        equalClicked();
        if (operand1 != 0) {
            memory += operand1;
        } else {
            memory += operand2;
            operand1 = 0;
            operand2 = 0;
            history = "";
            current = operand2 + "";
            operator = Operator.NONE;
        }
    }

    void memorySubtract() {
        equalClicked();
        if (operand1 != 0) {
            memory -= operand1;
        }
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
        firstFlag = true;
        flag = true;
    }

    void plusMinusClicked() {
        if (operand1 == 0) {
            operand1 = Double.parseDouble(current);
            operand1 = operand1 * -1;
            current = String.valueOf(operand1);
        } else {
            operand1 = operand1 * -1;
            current = String.valueOf(operand1);
        }
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
        if (operand1 != 0) {
            operand2 = (operand2 / 100 * operand1);
        } else {
            operand2 /= 100;
        }
        operand1 = 0;
        current = operand2 + "";
        operator = Operator.NONE;
    }
}
