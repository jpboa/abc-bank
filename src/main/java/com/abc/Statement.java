package com.abc;

class Statement {
    private String text = "";
    private double total = 0.0;
    
    public Statement(String text, double total) {
        this.setText(text);
        this.setTotal(total);
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}