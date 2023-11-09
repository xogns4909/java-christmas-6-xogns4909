package christmas;

import christmas.controller.EventPlannerController;
import view.inputView.ConsoleInput;
import view.outputView.ConsoleOutput;
import view.inputView.Input;
import view.outputView.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        EventPlannerController eventPlannerController = new EventPlannerController(input, output);
        eventPlannerController.run();

    }
}
