package hello.core.discount;

import hello.core.member.*;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
