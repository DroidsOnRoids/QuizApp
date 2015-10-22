package random.droidsonroids.pl.quiz.ui.main;

public class MainPresenterImpl implements MainPresenter {

    private final String NOTHING_ANSWER = "JON SNOW";
    private final String EVENT_ANSWER = "MOBILIZATION";
    private MainView mainView = new MainView.EmptyMainView();

    @Override
    public void setView(Object view) {
        this.mainView = (MainView) view;
    }

    @Override
    public void clearView() {
        mainView = new MainView.EmptyMainView();
    }

    @Override
    public void startClick() {
        mainView.hideStartLayout();
        mainView.showNothingLayout();
    }

    @Override
    public void nothingTextChanged(String text) {
        if(text.toUpperCase().equals(NOTHING_ANSWER)) {
            mainView.hideNothingLayout();
            mainView.showEventLayout();
        }
    }

    @Override
    public void eventTextChanged(String text) {
        if(text.toUpperCase().equals(EVENT_ANSWER)) {
            mainView.hideEventLayout();
            mainView.showImagesLayout();
        }
    }

    @Override
    public void yesClick() {
        mainView.hideImagesLayout();
        mainView.showCheckLayout();
    }

    @Override
    public void noClick() {
        //no-op
    }

    @Override
    public void checkedChanged(Boolean[] checks) {
        for(Boolean check : checks) {
            if(!check) {
                return;
            }
        }

        mainView.hideCheckLayout();
        mainView.showFunnyLayout();

    }

    @Override
    public void funnyClick() {
        mainView.hideFunnyLayout();
        mainView.showCongratulations();
        mainView.showShadowButton();
    }

    @Override
    public void notFunnyClick() {
        //no-op
    }
}
