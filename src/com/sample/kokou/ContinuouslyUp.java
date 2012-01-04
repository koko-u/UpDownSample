package com.sample.kokou;

public class ContinuouslyUp extends UpDownTask {

    public ContinuouslyUp(NumericView view) {
        super(view);
    }

    @Override
    void yield(NumericView view) {
        view.up();
    }

}
