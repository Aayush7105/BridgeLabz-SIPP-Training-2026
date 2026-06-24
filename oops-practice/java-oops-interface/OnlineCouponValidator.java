interface CouponValidator {

    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() == 8;
    }
}

class ShoppingCart implements CouponValidator {

    private final String[] validCoupons = {"SAVE2026", "JAVA2026", "SHOP5000"};

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        for (String coupon : validCoupons) {
            if (coupon.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

public class OnlineCouponValidator {

    public static void main(String[] args) {
        String[] couponCodes = {"SAVE2026", "BAD20", "JAVA2026", "WELCOME10", "SHOP5000"};
        ShoppingCart cart = new ShoppingCart();

        for (String couponCode : couponCodes) {
            if (cart.validateCoupon(couponCode)) {
                System.out.println(couponCode + " is valid.");
            } else {
                System.out.println(couponCode + " is invalid.");
            }
        }
    }
}
