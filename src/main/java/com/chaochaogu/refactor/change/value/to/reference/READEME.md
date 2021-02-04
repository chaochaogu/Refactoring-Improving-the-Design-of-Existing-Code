#将实值对象改为引用对象
你有一个class，衍生出许多相等实体（equal instances），你希望将它们替换为单一对象。
将这个value object （实值对象）变成一个reference object (引用对象）。
![将实值对象改为引用对象](https://img.imgdb.cn/item/601b876b3ffa7d37b34b5591.jpg)
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
   public Order (String customerName) {
       _customer = new Customer(customerName);
   }
   public void setCustomer(String customerName) {
       _customer = new Customer(customerName);
   }
   public String getCustomerName() {
       return _customer.getName();
   }
   private Customer _customer;
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
   public static Customer create (String name) {
       return new Customer(name);
   }
```
==>
```$xslt
class Order {
 public Order (String customer) {
     _customer = Customer.create(customer);
 }
```
==>
```$xslt
class Customer {
   private Customer (String name) {
      _name = name;
   }
```
==>
```$xslt
class Customer...
   static void loadCustomers() {
       new Customer ("Lemon Car Hire").store();
       new Customer ("Associated Coffee Machines").store();
       new Customer ("Bilston Gasworks").store();
   }
   private void store() {
       _instances.put(this.getName(), this);
   }
```
==>
```$xslt
public static Customer create (String name) {
       return (Customer) _instances.get(name);
   }
```
==>
```$xslt
class Customer...
   public static Customer getNamed (String name) {
       return (Customer) _instances.get(name);
   }
```