#引入本地扩展
你所使用的server class需要一些额外函数，但你无法修改这个class。
建立一个新class，使它包含这些额外函数。
让这个扩展品成为source class的subclass （子类〕或wrapper（外覆类）。
![引入本地扩展](https://img.imgdb.cn/item/601a50e03ffa7d37b3dc3255.jpg)
```$xslt
Class mfDate extends Date {
   public nextDay()...
   public dayOfYear()...
```
==>
```$xslt
class mfDate {
   private Date _original;
```
==>
```$xslt
class MfDateSub extends Date
```
==>
```$xslt
public MfDateSub (String dateString) {
          super (dateString);
    };
```
==>
```$xslt
public MfDateSub (Date arg) {
      super (arg.getTime());
  }
```
==>
```$xslt
client class...
    private static Date nextDay(Date arg) {
    // foreign method, should be on date
        return new Date (arg.getYear(),arg.getMonth(), arg.getDate() + 1);
    }
```
==>
```$xslt
class MfDate...
    Date nextDay() {
        return new Date (getYear(),getMonth(), getDate() + 1);
  }
```