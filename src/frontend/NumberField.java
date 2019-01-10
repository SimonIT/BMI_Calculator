package frontend;

import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;

public class NumberField extends TextField {

    @Override
    public void replaceSelection(String replacement) {
        super.replaceSelection(replacement);
    }

    @Override
    public void replaceText(IndexRange range, String text) {
        super.replaceText(range, text);
    }

    @Override
    public void replaceText(int start, int end, String text) {
        super.replaceText(start, end, text);
    }
}
