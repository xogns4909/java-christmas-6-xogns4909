package christmas.controller;

import christmas.domain.gift.StandardGiftPolicy;
import christmas.service.DiscountService;
import christmas.service.EventPlannerService;
import view.inputView.Input;
import view.outputView.Output;
import view.outputView.OutputView;
import view.inputView.InputView;

public class EventPlannerController {

    private final EventPlannerService eventPlanningService;

    public EventPlannerController(Input input, Output output) {
        InputView inputView = new InputView(input);
        OutputView outputView = new OutputView(output);
        this.eventPlanningService = new EventPlannerService(
                new DiscountService(), new StandardGiftPolicy(), inputView, outputView);
    }

    public void run() {
        eventPlanningService.executeEventPlan();
    }
}