#以委托取代继承
某个subclass 只使用superclass 接口中的一部分，或是根本不需要继承而来的数据。
在subclass 中新建一个值域用以保存superclass ；
调整subclass 函数，令它改而委托superclass ；然后去掉两者之间的继承关系。
![以委托取代继承](https://img.imgdb.cn/item/6020d4ad3ffa7d37b3819a77.jpg)
```angular2html
class MyStack extends Vector {
   public void push(Object element) {
       insertElementAt(element,0);
   }
   public Object pop() {
       Object result = firstElement();
       removeElementAt(0);
       return result;
   }
}
```
==>
```angular2html
private Vector _vector = this;
```
==>
```angular2html
public void push(Object element) {
      _vector.insertElementAt(element,0);
   }
```
==>
```angular2html
public Object pop() {
       Object result = _vector.firstElement();
      _vector.removeElementAt(0);
       return result;
   }
```
==>
```angular2html
class MyStack extends Vector
  private Vector _vector = new Vector();
```
==>
```angular2html
public int size() {
      return _vector.size();
  }
  public boolean isEmpty() {
      return _vector.isEmpty();
  }
```