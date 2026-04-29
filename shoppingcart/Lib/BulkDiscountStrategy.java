package Lib;
/**
 * กลยุทธ์ส่วนลดแบบซื้อครบจำนวนที่กำหนด
 */
public class BulkDiscountStrategy implements DiscountStrategy {
    private final int minimumQuantity;
    private final double discountPercentage;

    public BulkDiscountStrategy(int minimumQuantity, double discountPercentage){
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }
    /**
     * คำนวณราคาสุทธิสำหรับสินค้า 1 รายการ
     * @param item รายการสินค้าในตะกร้า
     * @return ราคาสุทธิหลังจากใช้โปรโมชัน
     */

    @Override
    public double calculatePrice(CartItem item) {
        double originalPrice = item.getProduct().getprice()*item.getQuantity();
        if (item.getQuantity() >= minimumQuantity) {
            return originalPrice * (1.0 - discountPercentage);
        }
        return originalPrice;
    }
    
    
    
}
