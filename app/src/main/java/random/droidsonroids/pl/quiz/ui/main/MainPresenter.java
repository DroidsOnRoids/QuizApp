package random.droidsonroids.pl.quiz.ui.main;

import random.droidsonroids.pl.quiz.ui.Presenter;

public interface MainPresenter extends Presenter {

    void startClick();
    void nothingTextChanged(String text);
    void eventTextChanged(String text);
    void yesClick();
    void noClick();
    void checkedChanged(Boolean[] checks);
    void funnyClick();
    void notFunnyClick();
}
