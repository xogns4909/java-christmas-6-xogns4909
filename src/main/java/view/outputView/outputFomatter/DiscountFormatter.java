package view.outputView.outputFomatter;


import christmas.domain.discount.DiscountDetails;
import christmas.domain.discount.DiscountDetail;
import view.outputView.PrintMessages;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

public class DiscountFormatter {

    public static String formatDiscountDetails(DiscountDetails discountDetails) {
        StringBuilder builder = new StringBuilder();

        for (DiscountDetail detail : discountDetails.getDetails()) {
            if (detail.amount() != 0) {
                builder.append(detail.type().getMessage())
                        .append(COLON.getValue())
                        .append(SPACE.getValue())
                        .append(HYPHEN.getValue())
                        .append(MoneyFormatter.formatMoney(detail.amount()))
                        .append("\n");
            }
        }

        if (builder.length() == 0) {
            builder.append(NO_DATA.getMessage());
        }

        return builder.toString();
    }
}