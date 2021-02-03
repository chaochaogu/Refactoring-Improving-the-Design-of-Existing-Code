#将类内联化
你的某个class没有做太多事情（没有承担足够责任）。
将class的所有特性搬移到另一个class中，然后移除原class。
![将类内联化](https://img.imgdb.cn/item/601a4a3d3ffa7d37b3d8c72a.jpg)
```$xslt
class Person...
   public String getName() {
       return _name;
   }
   public String getTelephoneNumber(){
       return _officeTelephone.getTelephoneNumber();
   }
   TelephoneNumber getOfficeTelephone() {
       return _officeTelephone;
   }
   private String _name;
   private TelephoneNumber _officeTelephone = new TelephoneNumber();
 class TelephoneNumber...
   public String getTelephoneNumber() {
       return ("(" + _areaCode + ") " + _number);
   }
   String getAreaCode() {
       return _areaCode;
   }
   void setAreaCode(String arg) {
       _areaCode = arg;
   }
   String getNumber() {
       return _number;
   }
   void setNumber(String arg) {
       _number = arg;
   }
   private String _number;
   private String _areaCode;
```
==>
```$xslt
class Person...
   String getAreaCode() {
       return _officeTelephone.getAreaCode();        //译注：请注意其变化
   }
   void setAreaCode(String arg) {
       _officeTelephone.setAreaCode(arg);                //译注：请注意其变化
   }
   String getNumber() {
       return _officeTelephone.getNumber();        //译注：请注意其变化
   }
   void setNumber(String arg) {
       _officeTelephone.setNumber(arg);                //译注：请注意其变化
   }
```
==>
```$xslt
Person martin = new Person();
       martin.getOfficeTelephone().setAreaCode ("781");
```
==>
```$xslt
Person martin = new Person();
       martin.setAreaCode ("781");
```