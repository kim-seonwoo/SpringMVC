package hello.core.discount;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10프로 적용 VIP")
    void vip_o() {
        Member member = new Member(1L, "d", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Not VIP")
    void vip_n() {
        Member member = new Member(1L, "d", Grade.NORMAL);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

}