package random.droidsonroids.pl.quiz.ui.main;

public interface MainView {

    void hideStartLayout();
    void showNothingLayout();
    void hideNothingLayout();
    void showEventLayout();
    void hideEventLayout();
    void showImagesLayout();
    void hideImagesLayout();
    void showCheckLayout();
    void hideCheckLayout();
    void showCongratulations();
    void showShadowButton();
    void showFunnyLayout();
    void hideFunnyLayout();

    class EmptyMainView implements MainView {

        @Override
        public void hideStartLayout() {

        }

        @Override
        public void showNothingLayout() {

        }

        @Override
        public void hideNothingLayout() {

        }

        @Override
        public void showEventLayout() {

        }

        @Override
        public void hideEventLayout() {

        }

        @Override
        public void showImagesLayout() {

        }

        @Override
        public void hideImagesLayout() {

        }

        @Override
        public void showCheckLayout() {

        }

        @Override
        public void hideCheckLayout() {

        }

        @Override
        public void showCongratulations() {

        }

        @Override
        public void showShadowButton() {

        }

        @Override
        public void showFunnyLayout() {

        }

        @Override
        public void hideFunnyLayout() {

        }
    }
}
