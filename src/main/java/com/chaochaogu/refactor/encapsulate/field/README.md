#封装值域
你的class中存在一个public值域。
将它声明为private，并提供相应的访问函数（accessors）。
```$xslt
public String _name
```
==>
```$xslt
private String _name;
 public String getName() {return _name;}
 public void setName(String arg) {_name = arg;}
```