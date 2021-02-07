#引入Null对象
你需要再三检查「某物是否为null value」。
将null value （无效值）替换为null object（无效物）。
```angular2html
if (customer == null) plan = BillingPlan.basic();
         else plan = customer.getPlan();
```
==>
![引入Null对象](https://img.imgdb.cn/item/601d052a3ffa7d37b3e519fd.jpg)
```angular2html
class Site...
   Customer getCustomer() {
       return _customer;
   }
   Customer _customer;
```
==>
```angular2html
class Customer...
   public String getName() {...}
   public BillingPlan getPlan() {...}
   public PaymentHistory getHistory() {...}
```
==>
```angular2html
public class PaymentHistory...
   int getWeeksDelinquentInLastYear()
```
==>
```angular2html
Customer customer = site.getCustomer();
         BillingPlan plan;
         if (customer == null) plan = BillingPlan.basic();
         else plan = customer.getPlan();
...
         String customerName;
         if (customer == null) customerName = "occupant";
         else customerName = customer.getName();
...
         int weeksDelinquent;
         if (customer == null) weeksDelinquent = 0;
         else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
```
==>
```angular2html
class NullCustomer extends Customer {
   public boolean isNull() {
       return true;
   }
 }
 class Customer...
   public boolean isNull() {
       return false;
   }
   protected Customer() {} //needed by the NullCustomer
```
==>
```angular2html
interface Nullable {
   boolean isNull();
 }
 class Customer implements Nullable
```
==>
```angular2html
class Customer...
   static Customer newNull() {
       return new NullCustomer();
   }
```
==>
```angular2html
class Site...
   Customer getCustomer() {
       return (_customer == null) ?
           Customer.newNull():
           _customer;
   }
```
==>
```angular2html
Customer customer = site.getCustomer();
       BillingPlan plan;
       if (customer.isNull()) plan = BillingPlan.basic();
       else plan = customer.getPlan();
 ...
       String customerName;
       if (customer.isNull()) customerName = "occupant";
       else customerName = customer.getName();
 ...
       int weeksDelinquent;
       if (customer.isNull()) weeksDelinquent = 0;
       else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
```
==>
```angular2html
String customerName;
       if (customer.isNull()) customerName = "occupant";
       else customerName = customer.getName();
```
==>
```angular2html
class NullCustomer...
   public String getName(){
       return "occupant";
   }
```
==>
```angular2html
String customerName = customer.getName();
```
==>
```angular2html
if (! customer.isNull())
           customer.setPlan(BillingPlan.special());
```
==>
```angular2html
customer.setPlan(BillingPlan.special());
 class NullCustomer...
   public void setPlan (BillingPlan arg) {}
```
==>
```angular2html
if (customer.isNull()) weeksDelinquent = 0;
       else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
```
==>
```angular2html
class NullPaymentHistory extends PaymentHistory...
   int getWeeksDelinquentInLastYear() {
       return 0;
   }
```
==>
```angular2html
class NullCustomer...
   public PaymentHistory getHistory() {
       return PaymentHistory.newNull();
   }
```
==>
```angular2html
int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
```