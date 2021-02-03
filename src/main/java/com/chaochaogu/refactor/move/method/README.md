#搬移函数
你的程序中，有个函数与其所驻class之外的另一个class进行更多交流：调用后者，或被后者调用。
在该函数最常引用（指涉）的class中建立一个有着类似行为的新函数。
将旧函数变成一个单纯的委托函数（delegating method），或是将旧函数完全移除。
![搬移函数](https://img.imgdb.cn/item/601a19e43ffa7d37b3c03624.jpg)
```$xslt
class Account...
  double overdraftCharge() {                //译注：透支金计费，它和其他class的关系似乎比较密切。
      if (_type.isPremium()) {
          double result = 10;
          if (_daysOverdrawn > 7) result += (_daysOverdrawn - 7) * 0.85;
          return result;
      }
      else return _daysOverdrawn * 1.75;
  }
  double bankCharge() {
      double result = 4.5;
      if (_daysOverdrawn > 0) result += overdraftCharge();
      return result;
  }
  private AccountType _type;
  private int _daysOverdrawn;
```
==>
```$xslt
class AccountType...
  double overdraftCharge(int daysOverdrawn) {
      if (isPremium()) {
          double result = 10;
          if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
          return result;
      }
      else return daysOverdrawn * 1.75;
  }
```
==>
```$xslt
class Account...
  double overdraftCharge() {
      return _type.overdraftCharge(_daysOverdrawn);
  }
```
==>
```$xslt
class Account...
  double bankCharge() {
      double result = 4.5;
      if (_daysOverdrawn > 0) result += _type.overdraftCharge(_daysOverdrawn);
      return result;
  }
```
==>
```$xslt
class AccountType...
  double overdraftCharge(Account account) {
      if (isPremium()) {
          double result = 10;
          if (account.getDaysOverdrawn() > 7)
             result += (account.getDaysOverdrawn() - 7) * 0.85;
          return result;
      }
      else return account.getDaysOverdrawn() * 1.75;
  }
```


