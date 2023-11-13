package christmas.domain.discount;

import java.util.ArrayList;
import java.util.List;

public record DiscountDetails(List<DiscountDetail> details) {

    public DiscountDetails(List<DiscountDetail> details) {
        this.details = new ArrayList<>(details);
    }

    public int getTotalDiscount() {
        return (int)details.stream()
                .mapToLong(DiscountDetail::amount)
                .sum();
    }

    public List<DiscountDetail> getDetails() {
        return details;
    }
}