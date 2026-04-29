package Lib;

import java.util.ArrayList;

// คลาสสำหรับจัดการโปรโมชันและคำนวณราคา

public class PricingService {
    private record StrategyRule(String sku, DiscountStrategy strategy){}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaulStrategy = new DefaultPricingStrategy();

    /**
     * ลงทะเบียนกลยุทธ์ส่วนลดสำหรับสินค้า SKU ที่กำหนด
     * หากมีโปรโมชันสำหรับ SKU นี้อยู่แล้ว จะถูกแทนที่ด้วยอันใหม่
     * @param sku รหัสสินค้าที่ต้องการผูกกับโปรโมชัน
     * @param strategy กลยุทธ์ส่วนลดที่ต้องการใช้
     */

     public void addStrategy(String sku, DiscountStrategy strategy){
        StrategyRule ruleToRemove = null;
        for (StrategyRule rule : strategies) {
            if (rule.sku.equals(sku)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) {
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
     }

    /**
     * คำนวณราคาสุทธิของสินค้า 1 รายการโดยใช้กลยุทธ์สที่เหมาะสม
     * @param item รายการสินค้าที่ต้องการคำนวณราคา
     * @return ราคาสุทธิหลังหักส่วนลด 
     */

    public double calculatePrice(CartItem item) {
        String sku = item.getProduct().getproductID();
        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                return rule.strategy.calculatePrice(item);
            }
        }
        return defaulStrategy.calculatePrice(item);
    }
}