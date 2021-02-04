#将双向关联改为单向
两个类之间有双向关联，但其中一个class如今不再需要另一个class的特性。
去除不必要的关联（association）。
![将双向关联改为单向](https://img.imgdb.cn/item/601ba3733ffa7d37b35709e6.jpg)
```$xslt
class Order...
   Customer getCustomer() {
       return _customer;
   }
   void setCustomer (Customer arg) {
       if (_customer != null) _customer.friendOrders().remove(this);
       _customer = arg;
       if (_customer != null) _customer.friendOrders().add(this);
   }
   private Customer _customer;        //译注：这是Order-to-Customer link也是本例的移除对象
 class Customer...
   void addOrder(Order arg) {
       arg.setCustomer(this);
   }
   private Set _orders = new HashSet();
       //译注：以上是Customer-to-Order link
   Set friendOrders() {
       /** should only be used by Order */
       return _orders;
   }
```
==>
```$xslt
class Order...
       double getDiscountedPrice() {
       return getGrossPrice() * (1 - _customer.getDiscount());
   }
```
==>
```$xslt
class Order...
   double getDiscountedPrice(Customer customer) {
       return getGrossPrice() * (1 - customer.getDiscount());
   }
```
==>
```$xslt
class Customer...
   double getPriceFor(Order order) {
       Assert.isTrue(_orders.contains(order)); // see Introduce Assertion (267)
       return order.getDiscountedPrice();
```
==>
```$xslt
class Customer...
   double getPriceFor(Order order) {
       Assert.isTrue(_orders.contains(order));
       return order.getDiscountedPrice(this);
   }
```
==>
```$xslt
Customer getCustomer() {
       Iterator iter = Customer.getInstances().iterator();
       while (iter.hasNext()) {
           Customer each = (Customer)iter.next();
           if (each.containsOrder(this)) return each;
       }
       return null;
   }
```