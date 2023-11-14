package christmas.service;


import static christmas.PlannerErrorMessages.*;

import christmas.domain.discount.DiscountDetails;
import christmas.domain.gift.GiftDto;
import christmas.domain.gift.GiftPolicy;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import java.util.List;
import view.inputView.InputView;
import view.outputView.OutputView;
import view.outputView.PrintMessages;

public class EventPlannerService {


    private final DiscountService discountService;
    private final GiftPolicy giftPolicy;
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlannerService(DiscountService discountService, GiftPolicy giftPolicy,
            InputView inputView, OutputView outputView) {
        this.discountService = discountService;
        this.giftPolicy = giftPolicy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void executeEventPlan() {
        outputView.requestAnnounce(PrintMessages.WELCOME_MESSAGE.getMessage());
        ReservationDate reservationDate = requestReservationDate();
        Orders orders = requestOrderMenu();
        List<GiftDto> giftDtos = giftPolicy.applyGiftPolicy(orders);
        DiscountDetails discountDetails = discountService.calculateTotalDiscount(orders,
                reservationDate);
        outputView.displayEventDetails(reservationDate, orders, giftDtos, discountDetails);
    }

    private Orders requestOrderMenu() {
        outputView.requestAnnounce(PrintMessages.ORDER_INPUT_INSTRUCTION.getMessage());
        while (true) {
            try {
                return inputView.inputOrderItems();
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(INVALID_MENU_INPUT.getMessage());
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
                outputView.displayErrorMessage(INVALID_DATE_INPUT.getMessage());
            }
        }
    }
}



