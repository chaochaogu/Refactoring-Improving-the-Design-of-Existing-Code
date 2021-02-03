#引入外加函数
你所使用的server class需要一个额外函数，但你无法修改这个class。
在client class中建立一个函数，并以一个server class实体作为第一引数（argument）
```$xslt
Date newStart = new Date (previousEnd.getYear(),
         previousEnd.getMonth(), previousEnd.getDate() + 1);
```
==>
```$xslt
Date newStart = nextDay(previousEnd);
 private static Date nextDay(Date arg) {
 // foreign method, should be on date
     return new Date (arg.getYear(),arg.getMonth(), arg.getDate() + 1);
 }
```                    
