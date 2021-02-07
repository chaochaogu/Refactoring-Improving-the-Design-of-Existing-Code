#移除控制标记
在一系列布尔表达式（boolean expressions）中，某个变量带有「控制标记」（control flag）的作用。
以break 语句或return 的语句取代控制标记。
```angular2html
void checkSecurity(String[] people) {
      boolean found = false;
      for (int i = 0; i < people.length; i++) {
          if (! found) {
             if (people[i].equals ("Don")){
               sendAlert();
               found = true;
             }
             if (people[i].equals ("John")){
               sendAlert();
               found = true;
             }
          }
      }
  }
```
==>
```angular2html
void checkSecurity(String[] people) {
      boolean found = false;
      for (int i = 0; i < people.length; i++) {
          if (! found) {
             if (people[i].equals ("Don")){
               sendAlert();
             break;
             }
             if (people[i].equals ("John")){
               sendAlert();
               found = true;
             }
          }
      }
  }
```
==>
```angular2html
void checkSecurity(String[] people) {
      boolean found = false;
      for (int i = 0; i < people.length; i++) {
          if (! found) {
             if (people[i].equals ("Don")){
               sendAlert();
               break;
             }
             if (people[i].equals ("John")){
               sendAlert();
               break;
             }
          }
      }
  }
```
==>
```angular2html
void checkSecurity(String[] people) {
      for (int i = 0; i < people.length; i++) {
          if (people[i].equals ("Don")){
             sendAlert();
             break;
          }
          if (people[i].equals ("John")){
             sendAlert();
             break;
          }
      }
  }
```

```angular2html
void checkSecurity(String[] people) {
      String found = "";
      for (int i = 0; i < people.length; i++) {
          if (found.equals("")) {
             if (people[i].equals ("Don")){
               sendAlert();
               found = "Don";
             }
             if (people[i].equals ("John")){
               sendAlert();
               found = "John";
             }
          }
      }
      someLaterCode(found);
  }
```
==>
```angular2html
void checkSecurity(String[] people) {
      String found = foundMiscreant(people);
      someLaterCode(found);
  }
  String foundMiscreant(String[] people){
      String found = "";
      for (int i = 0; i < people.length; i++) {
          if (found.equals("")) {
             if (people[i].equals ("Don")){
               sendAlert();
               found = "Don";
             }
             if (people[i].equals ("John")){
               sendAlert();
               found = "John";
             }
          }
      }
      return found;
  }
```
==>
```angular2html
String foundMiscreant(String[] people){
      String found = "";
      for (int i = 0; i < people.length; i++) {
          if (found.equals("")) {
             if (people[i].equals ("Don")){
               sendAlert();
              return "Don";
             }
             if (people[i].equals ("John")){
               sendAlert();
               found = "John";
             }
          }
      }
      return found;
  }
```
==>
```angular2html
String foundMiscreant(String[] people){
      for (int i = 0; i < people.length; i++) {
          if (people[i].equals ("Don")){
             sendAlert();
             return "Don";
          }
          if (people[i].equals ("John")){
             sendAlert();
             return "John";
          }
      }
      return "";
  }
```