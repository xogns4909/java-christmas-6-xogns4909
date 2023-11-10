package christmas.controller;

import christmas.domain.ReservationDate;
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
        requestReservationDate();
    }
    public ReservationDate requestReservationDate(){
        outputView.requestAnnounce(PrintMessages.ASK_FOR_DATE.getMessage());
        while (true) {
            try {
                int date = inputView.inputReservationDate();
                return new ReservationDate(date);
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

}
