package Lib;

public final class Product {
        private final String productID;
        private final String productNAME;
        private final double price;
        // Rep Invariant (RI)
        // - productID and productNAME are not be null or blank.
        // = price >= 0 
        //
        // Abstraction Function (AF)
        // - AF(productI, productNAME, price) = A product with gi

        /*
         *  ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
         */
        private void checkRep(){
                if (productID == null || productID.isBlank()) {
                        throw new RuntimeException("Ri violated : productID cannot used.");
                }
                if (productNAME == null || productNAME.isBlank()) {
                        throw new RuntimeException("Ri violated : productNAME cannot used.");
                }
                if (price < 0 ) {
                        throw new RuntimeException("Ri violated : price cannot used.");
                }
        }

        public Product(String productID,String productNAME,double price){
                this.productID = productID ;
                this.productNAME =  productNAME ;
                this.price = price ;
                checkRep(); // ตรวจสอบความถูกต้องทุกครั้งที่สร้าง
        }
        public String getproductID(){
                return productID;
        }
        public String getproductNAME(){
                return productNAME;
        }
        public double getprice(){
                return price;
        }
        /** 
         * เปรียบเทียบ Product สองชิ้นโดยใช้ productID
         * @param obj อ็อปเจกที่ต้องการเปรียบเที่ยบ
         * @return true หาก productID เหมือนกัน
         */
        @Override
        public boolean equals(Object obj){
                if(this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                return false;        
        }

}
