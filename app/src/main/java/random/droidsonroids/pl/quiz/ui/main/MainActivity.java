package random.droidsonroids.pl.quiz.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import random.droidsonroids.pl.quiz.ui.finish.FinishActivity;
import random.droidsonroids.pl.quiz.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.layout_start) LinearLayout startLayout;
    @Bind(R.id.layout_images) LinearLayout eventLayout;
    @Bind(R.id.layout_check) LinearLayout checkLayout;
    @Bind(R.id.layout_funny) LinearLayout funnyLayout;
    @Bind(R.id.layout_same_pictures) LinearLayout imagesLayout;
    @Bind(R.id.layout_edit_nothing) TextInputLayout nothingLayout;

    @Bind(R.id.edit_nothing) EditText nothingEditText;
    @Bind(R.id.edit_event) EditText eventEditText;
    @Bind({R.id.checkbox_harry, R.id.checkbox_hulk, R.id.checkbox_plowing, R.id.checkbox_dove})
    List<CheckBox> checkBoxes;
    @Bind(R.id.text_end) TextView endText;
    @Bind(R.id.button_shadow) Button shadowButton;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.clearView();
    }

    @OnClick(R.id.button_start)
    public void startClick() {
        mainPresenter.startClick();
    }

    @OnClick(R.id.button_yes)
    public void yesClick() {
        mainPresenter.yesClick();
    }

    @OnClick(R.id.button_no)
    public void noClick() {
        mainPresenter.noClick();
    }

    @OnTextChanged(R.id.edit_nothing)
    public void nothingTextChanged() {
        mainPresenter.nothingTextChanged(nothingEditText.getText().toString());
    }

    @OnTextChanged(R.id.edit_event)
    public void eventTextChanged() {
        mainPresenter.eventTextChanged(eventEditText.getText().toString());
    }

    @OnCheckedChanged(R.id.checkbox_harry)
    public void harryCheckedChange(CompoundButton buttonView, boolean isChecked) {
        checkChanged();
    }

    @OnCheckedChanged(R.id.checkbox_hulk)
    public void hulkCheckedChange(CompoundButton buttonView, boolean isChecked) {
        checkChanged();
    }

    @OnCheckedChanged(R.id.checkbox_plowing)
    public void plowingCheckedChange(CompoundButton buttonView, boolean isChecked) {
        checkChanged();
    }

    @OnCheckedChanged(R.id.checkbox_dove)
    public void doveCheckedChange(CompoundButton buttonView, boolean isChecked) {
        checkChanged();
    }

    private void checkChanged() {
        mainPresenter.checkedChanged(new Boolean[]{
                checkBoxes.get(0).isChecked(),
                checkBoxes.get(1).isChecked(),
                checkBoxes.get(2).isChecked(),
                checkBoxes.get(3).isChecked()});
    }

    @OnClick(R.id.button_funny)
    public void funnyClick() {
        mainPresenter.funnyClick();
    }

    @OnClick(R.id.button_not_funny)
    public void notFunnyClick() {
        mainPresenter.notFunnyClick();
    }

    @OnClick(R.id.button_shadow)
    public void shadowClick() {
        startActivity(new Intent(MainActivity.this, FinishActivity.class));
    }

    @Override
    public void hideStartLayout() {
        startLayout.setVisibility(View.GONE);
    }

    @Override
    public void showNothingLayout() {
        nothingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNothingLayout() {
        nothingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showEventLayout() {
        eventLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEventLayout() {
        eventLayout.setVisibility(View.GONE);
    }

    @Override
    public void showImagesLayout() {
        imagesLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImagesLayout() {
        imagesLayout.setVisibility(View.GONE);
    }

    @Override
    public void showCheckLayout() {
        checkLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCheckLayout() {
        checkLayout.setVisibility(View.GONE);
    }

    @Override
    public void showFunnyLayout() {
        funnyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFunnyLayout() {
        funnyLayout.setVisibility(View.GONE);
    }

    @Override
    public void showCongratulations() {
        endText.setVisibility(View.VISIBLE);
    }

    @Override
    public void showShadowButton() {
        shadowButton.setVisibility(View.VISIBLE);
    }
}
