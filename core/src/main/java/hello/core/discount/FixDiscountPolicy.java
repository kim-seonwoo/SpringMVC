package hello.core.discount;

import hello.core.member.*;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discoubtFixedAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        switch (member.getGrade()) {
            case VIP -> {
                return discoubtFixedAmount;
            }
            case NORMAL -> {
                return 0;
            }
        }
        return 0;
    }
}
