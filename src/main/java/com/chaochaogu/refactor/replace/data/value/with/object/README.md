#以对象取代数据值
你有一笔数据项（data item），需要额外的数据和行为。
将这笔数据项变成一个对象。
![以对象取代数据值](https://img.imgdb.cn/item/601b81853ffa7d37b34900e3.jpg)
```$xslt
class Order...
   public Order (String customer) {
       _customer = customer;
   }
   public String getCustomer() {
       return _customer;
   }
   public void setCustomer(String arg) {
       _customer = arg;
   }
   private String _customer;
```
==>
```$xslt
private static int numberOfOrdersFor(Collection orders, String customer) {
       int result = 0;
       Iterator iter = orders.iterator();
       while (iter.hasNext()) {
           Order each = (Order) iter.next();
           if (each.getCustomerName().equals(customer)) result++;
       }
       return result;
   }
```
==>
```$xslt
class Customer {
   public Customer (String name) {
       _name = name;
   }
   public String getName() {
       return _name;
   }
   private final String _name;
  }
```
==>
```$xslt
class Order...
   public Order (String customer) {
       _customer = new Customer(customer);
   }
   public String getCustomer() {
       return _customer.getName();
   }
   private Customer _customer;
   public void setCustomer(String arg) {
       _customer = new Customer(customer);
   }
```
==>
```$xslt
public String getCustomerName() {
       return _customer.getName();
   }
```
==>
```$xslt
public Order (String customerName) {
       _customer = new Customer(customerName);
   }
   public void setCustomer(String customerName) {
       _customer = new Customer(customerName);
   }
```