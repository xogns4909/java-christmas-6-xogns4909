package christmas.controller;

import view.inputView.Input;
import view.outputView.Output;
import view.outputView.OutputView;
import view.outputView.PrintMessages;
import view.inputView.InputView;

public class EventPlannerController {

    private final InputView inputView;

    private final OutputView outputView;

    public EventPlannerController(Input input, Output output){
        this.inputView= new InputView(input);
        this.outputView = new OutputView(output);
    }

    public void run(){
        outputView.requestAnnounce(PrintMessages.WELCOME_MESSAGE.getMessage());
    }

}
