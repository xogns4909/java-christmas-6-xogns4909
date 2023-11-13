package view.outputView;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

import christmas.domain.MenuItem;
import christmas.domain.OrderItem;
import christmas.domain.Orders;
import christmas.domain.ReservationDate;
import christmas.domain.badge.Badge;
import christmas.domain.discount.DiscountDetail;
import christmas.domain.discount.DiscountDetails;
import christmas.domain.gift.GiftDto;
import java.util.List;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void displayEventDetails(ReservationDate reservationDate, Orders orders,
            List<GiftDto> giftDtos, DiscountDetails discountDetails) {
        displayEventBenefitPreviewAnnounce(reservationDate.getDate());
        displayOrderDetails(orders);
        disPlayTotalOrderPrice(orders.getTotalPrice());
        disPlayGift(giftDtos);
        displayDetailsDiscount(discountDetails);
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

    private void displayEventBenefitPreviewAnnounce(int day) {
        output.print(String.format(PREVIEW_EVENT_BENEFITS.getMessage(), day));
    }

    private void displayOrderDetails(Orders orders) {
        printSectionHeader(ORDER_MENU.getMessage());
        for (OrderItem orderItem : orders.getOrderItems()) {
            displayItemWithQuantity(orderItem.getMenuItem(), orderItem.getQuantity());
        }
    }

    private void disPlayTotalOrderPrice(int price) {
        printSectionHeader(TOTAL_ORDER_PRICE.getMessage());
        String totalPrice = MoneyFormatter.formatMoney(price);
        output.print(totalPrice);
    }

    private void disPlayGift(List<GiftDto> giftDtos) {
        printSectionHeader(GIFT_MENU.getMessage());
        if (giftDtos.isEmpty()) {
            output.print(NO_DATA.getMessage());
            return;
        }
        for (GiftDto giftDto : giftDtos) {
            displayItemWithQuantity(giftDto.menuItem(), giftDto.count());
        }
    }

    private void displayDetailsDiscount(DiscountDetails discountDetails) {
        printSectionHeader(DISCOUNT_DETAILS.getMessage());

        if (areAllDiscountsZero(discountDetails)) {
            output.print(NO_DATA.getMessage());
            return;
        }

        for (DiscountDetail detail : discountDetails.getDetails()) {
            if (detail.amount() != 0) {
                output.print(formatDiscountDetail(detail));
            }
        }
    }

    private boolean areAllDiscountsZero(DiscountDetails discountDetails) {
        return discountDetails.getDetails().stream()
                .allMatch(detail -> detail.amount() == 0);
    }

    private String formatDiscountDetail(DiscountDetail detail) {
        return detail.type().getMessage()
                + COLON.getValue()
                + SPACE.getValue()
                + HYPHEN.getValue()
                + MoneyFormatter.formatMoney(detail.amount())
                + "\n";
    }

    private void disPlayTotalDiscount(DiscountDetails discountDetails) {
        printSectionHeader(DISCOUNT_AMOUNT.getMessage());
        int totalDiscount = discountDetails.getTotalDiscount();
        output.print(HYPHEN.getValue() + MoneyFormatter.formatMoney(totalDiscount));
    }

    private void displayFinalFee(Orders orders, DiscountDetails discountDetails) {
        printSectionHeader(FINAL_PAYMENT_AMOUNT.getMessage());
        int totalFee = (orders.getTotalPrice() - discountDetails.getTotalDiscount());
        output.print(MoneyFormatter.formatMoney(totalFee));
    }

    private void displayBadge(Badge badge) {
        printSectionHeader(GET_BADGE.getMessage());
        System.out.println(badge.getDisplayName());
    }

    private void displayItemWithQuantity(MenuItem menuItem, int quantity) {
        String itemAndQuantity = menuItem.getName()
                + SPACE.getValue()
                + quantity
                + UNIT_PIECE.getMessage()
                + "\n";
        output.print(itemAndQuantity);
    }

    private void printSectionHeader(String header) {
        output.print(SECTION_START.getValue() + header + SECTION_END.getValue());
    }
}
