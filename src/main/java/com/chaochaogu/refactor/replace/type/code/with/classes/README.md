#以类取代型别码
class 之中有一个数值型别码（ numeric type code ），但它并不影响class 的行为。
以一个新的class 替换该数值型别码（type code）。
![以类取代型别码](https://img.imgdb.cn/item/601bafbb3ffa7d37b35d84a4.jpg)
```$xslt
class Person {
   public static final int O = 0;
   public static final int A = 1;
   public static final int B = 2;
   public static final int AB = 3;
   private int _bloodGroup;
   public Person (int bloodGroup) {
       _bloodGroup = bloodGroup;
   }
   public void setBloodGroup(int arg) {
       _bloodGroup = arg;
   }
   public int getBloodGroup() {
       return _bloodGroup;
   }
 }
```
==>
```$xslt
class BloodGroup {
   public static final BloodGroup O = new BloodGroup(0);
   public static final BloodGroup A = new BloodGroup(1);
   public static final BloodGroup B = new BloodGroup(2);
   public static final BloodGroup AB = new BloodGroup(3);
   private static final BloodGroup[] _values = {O, A, B, AB};
   private final int _code;
   private BloodGroup (int code ) {
       _code = code;
   }
   public int getCode() {
       return _code;
   }
   public static BloodGroup code(int arg) {
       return _values[arg];
   }
 }
```
==>
```$xslt
class Person {
   public static final int O = BloodGroup.O.getCode();
   public static final int A = BloodGroup.A.getCode();
   public static final int B = BloodGroup.B.getCode();
   public static final int AB = BloodGroup.AB.getCode();
   private BloodGroup _bloodGroup;
   public Person (int bloodGroup) {
       _bloodGroup = BloodGroup.code(bloodGroup);
   }
   public int getBloodGroup() {
       return _bloodGroup.getCode();
   }
   public void setBloodGroup(int arg) {
       _bloodGroup = BloodGroup.code (arg);
   }
 }
```
==>
```$xslt
class Person...
   public int getBloodGroupCode() {
       return _bloodGroup.getCode();
   }
```
==>
```$xslt
public BloodGroup getBloodGroup() {
       return _bloodGroup;
   }
```
==>
```$xslt
public Person (BloodGroup bloodGroup ) {
   _bloodGroup = bloodGroup;
 }
 public void setBloodGroup(BloodGroup arg) {
   _bloodGroup = arg;
 }
```
==>
```$xslt
Person thePerson = new Person(Person.A)
```
==>
```$xslt
Person thePerson = new Person(BloodGroup.A);
```
==>
```$xslt
thePerson.getBloodGroupCode()
```
==>
```$xslt
thePerson.getBloodGroup().getCode()
```
==>
```$xslt
thePerson.setBloodGroup(Person.AB)
```
==>
```$xslt
thePerson.setBloodGroup(BloodGroup.AB)
```
==>
```$xslt
class Person ...
   public static final int O = BloodGroup.O.getCode();
   public static final int A = BloodGroup.A.getCode();
   public static final int B = BloodGroup.B.getCode();
   public static final int AB = BloodGroup.AB.getCode();
   public Person (int bloodGroup) {
       _bloodGroup = BloodGroup.code(bloodGroup);
   }         
   public int getBloodGroup() {
       return _bloodGroup.getCode();
   }
   public void setBloodGroup(int arg) {
       _bloodGroup = BloodGroup.code (arg);
   }
```
==>
```$xslt
class BloodGroup...
  private int getCode() {
       return _code;
   }
  private static BloodGroup code(int arg) {
       return _values[arg];
   }
```