package christmas.controller;

import static christmas.controller.ControllerErrorMessages.*;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import christmas.domain.discount.DiscountDetails;
import christmas.domain.discount.DiscountService;
import christmas.domain.gift.GiftDto;
import christmas.domain.gift.GiftPolicy;
import christmas.domain.gift.StandardGiftPolicy;
import java.util.List;
import view.inputView.Input;
import view.outputView.Output;
import view.outputView.OutputView;
import view.outputView.PrintMessages;
import view.inputView.InputView;

public class EventPlannerController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DiscountService discountService = new DiscountService();
    private final GiftPolicy giftPolicy = new StandardGiftPolicy();

    public EventPlannerController(Input input, Output output) {
        this.inputView = new InputView(input);
        this.outputView = new OutputView(output);
    }

    public void run() {
        outputView.requestAnnounce(PrintMessages.WELCOME_MESSAGE.getMessage());
        ReservationDate reservationDate = requestReservationDate();
        Orders orders = requestOrderMenu();
        List<GiftDto> giftDtos = giftPolicy.applyGiftPolicy(orders);
        DiscountDetails discountDetails = discountService.calculateTotalDiscount(orders, reservationDate);
        outputView.displayEventDetails(reservationDate, orders, giftDtos, discountDetails);
    }

    private Orders requestOrderMenu() {
        outputView.requestAnnounce(PrintMessages.ORDER_INPUT_INSTRUCTION.getMessage());
        while (true) {
            try {
                return inputView.inputOrderItems();
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(INVALID_INPUT.getMessage());
            }
        }
    }

    private ReservationDate requestReservationDate() {
        outputView.requestAnnounce(PrintMessages.ASK_FOR_DATE.getMessage());
        while (true) {
            try {
                int date = inputView.inputReservationDate();
                return new ReservationDate(date);
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(INVALID_DATE.getMessage());
            }
        }
    }
}