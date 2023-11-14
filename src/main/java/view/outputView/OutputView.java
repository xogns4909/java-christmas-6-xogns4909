package view.outputView;

import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import christmas.domain.badge.Badge;
import christmas.domain.discount.DiscountDetails;
import christmas.domain.gift.GiftDto;
import java.util.List;
import view.outputView.outputFomatter.DiscountFormatter;
import view.outputView.outputFomatter.GiftFormatter;
import view.outputView.outputFomatter.MoneyFormatter;
import view.outputView.outputFomatter.OrderFormatter;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void displayEventDetails(ReservationDate reservationDate, Orders orders,
            List<GiftDto> giftDtos, DiscountDetails discountDetails) {
        printSectionHeader(
                String.format(PREVIEW_EVENT_BENEFITS.getMessage(), reservationDate.getDate()));
        displayOrdersSection(orders);
        disPlayTotalOrderPrice(orders.getTotalPrice());
        displayDiscountsSection(discountDetails);
        displayGiftsSection(giftDtos);
        disPlayTotalDiscount(discountDetails);
        displayFinalFee(orders, discountDetails);
        displayBadge(Badge.getBadgeForAmount(
                orders.getTotalPrice() - discountDetails.getTotalDiscount()));
    }

    public void requestAnnounce(String announce) {
        output.print(announce);
    }

    public void displayErrorMessage(String message) {
        output.print(ERROR.getMessage() + message);
    }

    private void displayOrdersSection(Orders orders) {
        printSectionHeader(ORDER_MENU.getMessage());
        output.print(OrderFormatter.formatOrderDetails(orders));
    }

    private void disPlayTotalOrderPrice(int price) {
        printSectionHeader(TOTAL_ORDER_PRICE.getMessage());
        output.print(MoneyFormatter.formatMoney(price));
    }

    private void displayGiftsSection(List<GiftDto> giftDtos) {
        printSectionHeader(GIFT_MENU.getMessage());
        output.print(GiftFormatter.formatGiftDetails(giftDtos));
    }

    private void displayDiscountsSection(DiscountDetails discountDetails) {
        printSectionHeader(DISCOUNT_DETAILS.getMessage());
        output.print(DiscountFormatter.formatDiscountDetails(discountDetails));
    }

    private void disPlayTotalDiscount(DiscountDetails discountDetails) {
        printSectionHeader(DISCOUNT_AMOUNT.getMessage());
        output.print(MoneyFormatter.formatMoney(discountDetails.getTotalDiscount()));
    }

    private void displayFinalFee(Orders orders, DiscountDetails discountDetails) {
        printSectionHeader(FINAL_PAYMENT_AMOUNT.getMessage());
        int totalFee = (orders.getTotalPrice() - discountDetails.getTotalDiscount());
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