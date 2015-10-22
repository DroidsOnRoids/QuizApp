package random.droidsonroids.pl.quiz.ui.finish;

public class FinishPresenterImpl implements FinishPresenter {

    private FinishView finishView = new FinishView.EmptyFinish();

    @Override
    public void setView(Object view) {
        this.finishView = (FinishView) view;
    }

    @Override
    public void clearView() {
        finishView = new FinishView.EmptyFinish();
    }

    @Override
    public void shareClick() {
        finishView.shareWin();
    }
}
