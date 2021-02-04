#将单向关联改为双向
两个classes都需要使用对方特性，但其间只有一条单向连接（one-way link）。
添加一个反向指针，并使修改函数（modifiers）能够同时更新两条连接。
（译注：这里的指针等同于句柄（handle），修改函数（modifier）指的是改变双方关系者）
```$xslt
class Order...
   Customer getCustomer() {
       return _customer;
   }
   void setCustomer (Customer arg) {
       _customer = arg;
   }
   Customer _customer;
```
==>
```$xslt
class Customer  {
   private Set _orders = new HashSet();
```
==>
```$xslt
class Customer...
   Set friendOrders() {
   /** should only be used by Order when modifying the association */
       return _orders;
   }
```
==>
```$xslt
class Order...
   void setCustomer (Customer arg) ...
       if (_customer != null) _customer.friendOrders().remove(this);
       _customer = arg;
       if (_customer != null) _customer.friendOrders().add(this);
   }
```
==>
```$xslt
class Customer...
   void addOrder(Order arg) {
       arg.setCustomer(this);
   }
```
==>
```$xslt
class Order... //controlling methods
   void addCustomer (Customer arg) {
       arg.friendOrders().add(this);
       _customers.add(arg);
   }
   void removeCustomer (Customer arg) {
       arg.friendOrders().remove(this);
       _customers.remove(arg);
   }
class Customer...
   void addOrder(Order arg) {
       arg.addCustomer(this);
   }
   void removeOrder(Order arg) {
       arg.removeCustomer(this);
   }

```