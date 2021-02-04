#将引用对象改为实值对象
你有一个reference object（引用对象），很小且不可变（immutable），而且不易管理。
将它变成一个value object（实值对象）。
![将引用对象改为实值对象](https://img.imgdb.cn/item/601b88903ffa7d37b34bb8be.jpg)
```$xslt
class Currency...
   private String _code;
   public String getCode() {
       return _code;
   }
   private Currency (String code) {
       _code = code;
   }
```
==>
```$xslt
Currency usd = Currency.get("USD");
```
==>
```$xslt
new Currency("USD").equals(new Currency("USD")) // returns false
```
==>
```$xslt
public boolean equals(Object arg) {
       if (! (arg instanceof Currency)) return false;
       Currency other = (Currency) arg;
       return (_code.equals(other._code));
   }
```
==>
```$xslt
public int hashCode() {
       return _code.hashCode();
   }
```
==>
```$xslt
new Currency("USD").equals(new Currency("USD")) // now returns true
```