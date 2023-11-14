package christmas.domain.gift;

import christmas.domain.model.Orders;
import java.util.List;

public interface GiftPolicy {

    List<GiftDto> applyGiftPolicy(Orders orders);
}
