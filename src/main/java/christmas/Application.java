package christmas;

import christmas.controller.EventPlannerController;
import view.inputView.ConsoleInput;
import view.outputView.ConsoleOutput;
import view.inputView.Input;
import view.outputView.Output;

public class Application {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        EventPlannerController eventPlannerController = new EventPlannerController(input, output);
        eventPlannerController.run();

    }
}
