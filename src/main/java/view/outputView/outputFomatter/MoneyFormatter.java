package view.outputView.outputFomatter;

import static view.outputView.PrintMessages.*;

import java.text.NumberFormat;

public class MoneyFormatter {

    public static String formatMoney(int amount) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(amount) + KRW_CURRENCY_UNIT.getMessage();
    }
}