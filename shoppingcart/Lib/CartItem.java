package Lib;

public class CartItem {
    private final Product product;
    private int quantity;
    // Rep Invariant (RI)
    // - product is not null.
    // - quantity >0.
    //
    //Abtraction Function (AF)
    // = AF (product, quantity) = An item in a shopping cart.
    // with the specified quantity
    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if (product == null) {
            throw new   RuntimeException("Ri violated : product cannot used.");
        }
        if (quantity < 0) {
            throw new   RuntimeException("Ri violated : quantity cannot used.");
        }
    }

    public CartItem(Product product,int quantity){
        this.product = product ;
        this.quantity = quantity ;
        checkRep();
    }

    /**
     * @return อ็อปเจก Product
     */
    public Product getProduct(){ return product;}
    public int getQuantity(){ return quantity;}

    /**
     * เพิ่มจำนวนสินค้าในรายการนี้
     * @param amount จำนวนที่ต้องการเพิ่ม (ต้องเป็นค่าบวก)
     */
    public void increaseQuantity(int amount){
        if (amount > 0) {
            this.quantity += amount;
        }
        checkRep();
    }
}
