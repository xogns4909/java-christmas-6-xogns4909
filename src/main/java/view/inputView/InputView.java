package view.inputView;

import util.convertor.StringToIntegerConvertor;
import view.outputView.Output;

public class InputView {

    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public int inputReservationDate(){
        String date = input.input();
        return StringToIntegerConvertor.convert(date);
    }
}