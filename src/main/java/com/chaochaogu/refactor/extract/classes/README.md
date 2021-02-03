#提炼类
某个class做了应该由两个classes做的事。
建立一个新class，将相关的值域和函数从旧class搬移到新class。
![提炼类](https://img.imgdb.cn/item/601a470b3ffa7d37b3d70cf1.jpg)
```$xslt
class Person...
   public String getName() {
       return _name;
   }
   public String getTelephoneNumber() {
       return ("(" + _officeAreaCode + ") " + _officeNumber);
   }
   String getOfficeAreaCode() {
       return _officeAreaCode;
   }
   void setOfficeAreaCode(String arg) {
       _officeAreaCode = arg;
   }
   String getOfficeNumber() {
       return _officeNumber;
   }
   void setOfficeNumber(String arg) {
       _officeNumber = arg;
   }
   private String _name;
   private String _officeAreaCode;
   private String _officeNumber;
```
==>
```$xslt
class TelephoneNumber {
 }
```
==>
```$xslt
class Person
   private TelephoneNumber _officeTelephone = new TelephoneNumber();
```
==>
```$xslt
class TelephoneNumber {
   String getAreaCode() {
       return _areaCode;
   }
   void setAreaCode(String arg) {
       _areaCode = arg;
   }
   private String _areaCode;
 }
 class Person...
   public String getTelephoneNumber() {
       return ("(" + getOfficeAreaCode() + ") " + _officeNumber);
   }
   String getOfficeAreaCode() {
       return _officeTelephone.getAreaCode();
   }
   void setOfficeAreaCode(String arg) {
       _officeTelephone.setAreaCode(arg);
   }
```
==>
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