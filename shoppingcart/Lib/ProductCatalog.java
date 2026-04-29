package Lib;
import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();
    // Rep Invariant (RI) : product list cannot be null, and no duplicate products.
    // Abstraction Function (AF) : A catalog of all available products.
    private void checkRep(){
        if (products== null ) {
            throw new RuntimeException("Ri violated : products cannot used.");
        }
        // Check for duplicate products
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).equals(products.get(j))) {
                    throw new RuntimeException("Ri violated : product cannot used.");
                }
            }
        }
    }
    public ProductCatalog(){
        checkRep();
    }
    /**
     *  เพิ่มสินค้าเข้า catalog
     * @param product สินค้าที่ต้องการเพิ่ม 
     */
    public void addProduct(Product product){
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
        checkRep();
    }

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productID รหัสสินค้าที่ต้องการค้นหา
     * @return อ็ออปเจก Product หากพบ, null หากไม่พบ
     */

     public Product findByID(String productID){
        for(Product p : products){
            if (p.getproductID().equals(productID)) {
                return p;
            }
        } return null;
     }
    
}
