package view.outputView;

import christmas.domain.gift.GiftDtos;
import christmas.domain.model.Orders;
import christmas.domain.model.ReservationDate;
import christmas.domain.model.Badge;
import christmas.domain.discount.DiscountDetails;
import view.outputView.outputFomatter.*;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void displayEventDetails(ReservationDate reservationDate, Orders orders
            , GiftDtos giftDtos, DiscountDetails discountDetails) {
        printEventHeader(reservationDate);
        displayOrderDetails(orders);
        displayDiscountDetails(discountDetails, giftDtos, orders.getTotalPrice());
    }

    public void requestAnnounce(String announce) {
        output.print(announce);
    }

    public void displayErrorMessage(String message) {
        output.print(ERROR.getMessage() + message);
    }

    private void printEventHeader(ReservationDate reservationDate) {
        String eventHeader = String.format(PREVIEW_EVENT_BENEFITS.getMessage(),
                reservationDate.getDate());
        printSectionHeader(eventHeader);
    }


    private void displayOrderDetails(Orders orders) {
        int totalOrderPrice = orders.getTotalPrice();
        displayOrdersSection(orders);
        disPlayTotalOrderPrice(totalOrderPrice);
    }

    private void displayDiscountDetails(DiscountDetails discountDetails,
            GiftDtos giftDtos, int totalOrderPrice) {
        int totalBenefit = calculateTotalBenefit(discountDetails, giftDtos);
        int finalFee = totalOrderPrice - totalBenefit;
        displayDiscountsSection(discountDetails);
        displayGiftsSection(giftDtos);
        disPlayTotalDiscount(totalBenefit);
        displayFinalFee(finalFee);
        displayBadge(Badge.getBadgeForAmount(totalBenefit));
    }

    private int calculateTotalBenefit(DiscountDetails discountDetails, GiftDtos giftDtos) {
        return discountDetails.getTotalDiscount() + giftDtos.getTotalGiftValue();
    }

    private void displayOrdersSection(Orders orders) {
        printSectionHeader(ORDER_MENU.getMessage());
        output.print(OrderFormatter.formatOrderDetails(orders));
    }

    private void disPlayTotalOrderPrice(int price) {
        printSectionHeader(TOTAL_ORDER_PRICE.getMessage());
        output.print(MoneyFormatter.formatMoney(price));
    }

    private void displayGiftsSection(GiftDtos giftDtos) {
        printSectionHeader(GIFT_MENU.getMessage());
        output.print(GiftFormatter.formatGiftDetails(giftDtos.gifts()));
    }

    private void displayDiscountsSection(DiscountDetails discountDetails) {
        printSectionHeader(DISCOUNT_DETAILS.getMessage());
        output.print(DiscountFormatter.formatDiscountDetails(discountDetails));
    }

    private void disPlayTotalDiscount(int totalBenefit) {
        printSectionHeader(DISCOUNT_AMOUNT.getMessage());
        output.print(MoneyFormatter.formatMoney(totalBenefit));
    }


    private void displayFinalFee(int totalFee) {
        printSectionHeader(FINAL_PAYMENT_AMOUNT.getMessage());
        output.print(MoneyFormatter.formatMoney(totalFee));
    }

    private void displayBadge(Badge badge) {
        printSectionHeader(GET_BADGE.getMessage());
        output.print(badge.getDisplayName());
    }

    private void printSectionHeader(String header) {
        output.print(SECTION_START.getValue() + header + SECTION_END.getValue());
    }

}