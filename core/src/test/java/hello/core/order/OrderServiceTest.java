package hello.core.order;

import hello.core.member.*;
import hello.core.singleton.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(null);
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "kim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
