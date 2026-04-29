Shopping Cart System (Strategy Pattern Practice)
โปรเจกต์จำลองระบบตะกร้าสินค้า (E-commerce Cart) ที่เน้นการออกแบบโครงสร้างซอฟต์แวร์ให้ยืดหยุ่นและรองรับการขยายตัวในอนาคต โดยใช้แนวคิดจากวิชา Software Engineering
Key Features & Design Patterns
1. Strategy Pattern (Discount Logic)
หัวใจสำคัญของโปรเจกต์นี้คือการใช้ Strategy Pattern ในการจัดการส่วนลดสินค้า ซึ่งช่วยให้ระบบสามารถเพิ่มโปรโมชันใหม่ๆ ได้โดยไม่ต้องแก้ไขโค้ดเดิม (Open-Closed Principle)
-  DiscountStrategy (Interface): กำหนดมาตรฐานการคำนวณราคา  
-  BogoDiscountStrategy: ตรรกะส่วนลดแบบซื้อ 1 แถม 1  
-  BulkDiscountStrategy: ตรรกะส่วนลดเมื่อซื้อสินค้าครบตามจำนวนที่กำหนด  
-  DefaultPricingStrategy: การคิดราคาปกติสำหรับสินค้าที่ไม่มีโปรโมชัน
2. Defensive Programming & Data Integrity
เน้นความถูกต้องของข้อมูลผ่านกระบวนการตรวจสอบที่เข้มงวด:
-  Rep Invariant (RI): ใช้เมธอด checkRep() ในคลาสหลักอย่าง Product และ CartItem เพื่อตรวจสอบว่าข้อมูล (เช่น ราคา, จำนวน) มีค่าที่ถูกต้องเสมอและไม่เป็นค่าลบ
-  Encapsulation: ปกป้องข้อมูลภายในคลาสและใช้ final เพื่อป้องกันการแก้ไขข้อมูลโดยไม่ตั้งใจ  
3. Comprehensive Testing
มีการเขียนระบบทดสอบอัตโนมัติ (Manual Automated Test) ใน App.java เพื่อตรวจสอบความถูกต้องของระบบในหลายกรณี:
-  การเพิ่ม/ลบ สินค้าในตะกร้า  
-  การใช้ส่วนลดหลายรูปแบบซ้อนกัน  
-  การจัดการกับ Input ที่ผิดพลาด (Edge Cases)  
Technology Stack
-  Language: Java
-  Design Concept: OOP, Strategy Design Pattern, Defensive Programming
Project Structure
-  Product.java: ข้อมูลพื้นฐานของสินค้า  
-  PricingService.java: ตัวจัดการการเลือกโปรโมชันให้ตรงกับสินค้าแต่ละชนิด  
-  App.java: Main Entry Point และ Test Suite
