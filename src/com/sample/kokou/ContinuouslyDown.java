package com.sample.kokou;

public class ContinuouslyDown extends UpDownTask {

    public ContinuouslyDown(NumericView view) {
        super(view);
    }

    @Override
    void yield(NumericView view) {
        view.down();
    }

}
