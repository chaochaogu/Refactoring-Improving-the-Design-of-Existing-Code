#封装群集
有个函数（method）返回一个群集（collection）。
让这个函数返回该群集的一个只读映件（read-only view），并在这个class中提供「添加/移除」（add/remove）群集元素的函数。
![封装群集](https://img.imgdb.cn/item/601ba8e73ffa7d37b359ff70.jpg)
```$xslt
class Course...
   public Course (String name, boolean isAdvanced) {...};
   public boolean isAdvanced() {...};
```
==>
```$xslt
class Person...
   public Set getCourses() {
       return _courses;
   }
   public void setCourses(Set arg) {
       _courses = arg;
   }
   private Set _courses;
```
==>
```$xslt
class Person
   public void addCourse (Course arg) {
       _courses.add(arg);
   }
   public void removeCourse (Course arg) {
       _courses.remove(arg);
   }
```
==>
```$xslt
public void initializeCourses(Set arg) {
       Assert.isTrue(_courses.isEmpty());
       Iterator iter = arg.iterator();
       while (iter.hasNext()) {
           addCourse((Course) iter.next());
       }
   }
```