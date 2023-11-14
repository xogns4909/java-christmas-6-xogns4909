package view.outputView.outputFomatter;

import christmas.domain.gift.GiftDto;
import java.util.List;
import view.outputView.PrintMessages;

import static util.Constants.*;
import static view.outputView.PrintMessages.*;

public class GiftFormatter {

    public static String formatGiftDetails(List<GiftDto> giftDtos) {
        if (giftDtos.isEmpty()) {
            return NO_DATA.getMessage();
        }

        StringBuilder builder = new StringBuilder();
        for (GiftDto giftDto : giftDtos) {
            builder.append(giftDto.menuItem().getName())
                    .append(SPACE.getValue())
                    .append(giftDto.count())
                    .append(UNIT_PIECE.getMessage())
                    .append("\n");
        }
        return builder.toString();
    }
}