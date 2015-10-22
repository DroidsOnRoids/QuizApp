package random.droidsonroids.pl.quiz.ui.finish;

public interface FinishView {

    void shareWin();

    class EmptyFinish implements FinishView {

        @Override
        public void shareWin() {

        }
    }
}
