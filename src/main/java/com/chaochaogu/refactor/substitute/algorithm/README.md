#替换你的算法
把某个算法替换为另一个更清晰的算法。
将函数本体（method body）替换为另一个算法。
```$xslt
String foundPerson(String[] people){
       for (int i = 0; i < people.length; i++) {
           if (people[i].equals ("Don")){
               return "Don";
           }
           if (people[i].equals ("John")){
               return "John";
           }
           if (people[i].equals ("Kent")){
               return "Kent";
           }
       }
       return "";
   }
```
==>
```$xslt
String foundPerson(String[] people){
       List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
       for (int i=0; i<people.length; i++)
           if (candidates.contains(people[i]))
               return people[i];
       return "";
   }
```