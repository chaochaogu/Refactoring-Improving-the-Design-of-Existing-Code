#搬移值域
你的程序中，某个field（值域〕被其所驻class之外的另一个class更多地用到。
在target class 建立一个new field，修改source field的所有用户，令它们改用此new field。
![搬移值域](https://img.imgdb.cn/item/601a1a783ffa7d37b3c079e6.jpg)
```$xslt
class Account...
  private AccountType _type;
  private double _interestRate;
  double interestForAmount_days (double amount, int days) {
      return _interestRate * amount * days / 365;
  }
```
==>
```$xslt
class AccountType...
  private double _interestRate;
  void setInterestRate (double arg) {
      _interestRate = arg;
  }
  double getInterestRate () {
      return _interestRate;
  }
```
==>
```$xslt
private double _interestRate;
  double interestForAmount_days (double amount, int days) {
      return _type.getInterestRate() * amount * days / 365;
  }
```
==>
```$xslt
class Account...
   private AccountType _type;
   private double _interestRate;
   double interestForAmount_days (double amount, int days) {
       return getInterestRate() * amount * days / 365;
   }
   private void setInterestRate (double arg) {
       _interestRate = arg;
   }
   private double getInterestRate () {
       return _interestRate;
   }
```
==>
```$xslt
double interestForAmountAndDays (double amount, int days) {
       return getInterestRate() * amount * days / 365;
   }
   private void setInterestRate (double arg) {
      _type.setInterestRate(arg);
   }
   private double getInterestRate () {
       return _type.getInterestRate();
   }
```