package com.example.casestudy1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_history, tv_output, tv_memory;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tv_history = findViewById(R.id.tv_history);
        tv_output = findViewById(R.id.tv_output);
        tv_memory = findViewById(R.id.tv_memory);
        calculator = new Calculator();
    }

    public void operandClicked(View view) {
        Button btn = (Button) view;
        double number = Double.parseDouble(((Button) view).getText().toString());
        calculator.operandClicked(number);
        updateUI();
    }

    public void additionClicked(View view) {
        calculator.additionClicked();
        updateUI();
    }

    public void subtractionClicked(View view) {
        calculator.subtractionClicked();
        updateUI();
    }

    public void percentageClicked(View view) {
        calculator.percentageClicked();
        updateUI();
    }

    public void multiplicationClicked(View view) {
        calculator.multiplicationClicked();
        updateUI();
    }

    public void divisionClicked(View view) {
        calculator.divisionClicked();
        updateUI();
    }

    public void equalClicked(View view) {
        calculator.equalClicked();
        updateUI();
    }

    public void dotClicked(View view) {
        calculator.dotClicked();
        updateUI();
    }

    public void memoryAddClicked(View view) {
        calculator.memoryAdd();
        updateUI();
    }

    public void memorySubtractClicked(View view) {
        calculator.memorySubtract();
        updateUI();
    }

    public void memoryRecallClicked(View view) {
        calculator.memoryRecall();
        updateUI();
    }

    public void memoryClearClicked(View view) {
        calculator.memoryClear();
        updateUI();
    }

    private void updateUI() {
        tv_history.setText(calculator.getHistory());
        tv_output.setText(calculator.getCurrent());
        tv_memory.setText("Memory : " + calculator.getMemory());
    }

    public void clearAllClicked(View view) {
        calculator.clearAll();
        updateUI();
    }
}
