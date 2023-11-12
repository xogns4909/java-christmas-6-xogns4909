package christmas.domain.gift;

import christmas.domain.Orders;
import java.util.List;

public interface GiftPolicy {

    List<GiftDto> applyGiftPolicy(Orders orders);
}
