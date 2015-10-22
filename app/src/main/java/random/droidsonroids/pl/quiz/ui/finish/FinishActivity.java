package random.droidsonroids.pl.quiz.ui.finish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import random.droidsonroids.pl.quiz.R;

public class FinishActivity extends AppCompatActivity implements FinishView{

    private FinishPresenter finishPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        ButterKnife.bind(this);

        finishPresenter = new FinishPresenterImpl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        finishPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finishPresenter.clearView();
    }

    @OnClick(R.id.button_share)
    public void shareClick() {
        finishPresenter.shareClick();
    }

    @Override
    public void shareWin() {
        Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TEXT, getString(R.string.dolphin) );
        startActivity(Intent.createChooser(intent2, ""));
    }
}
