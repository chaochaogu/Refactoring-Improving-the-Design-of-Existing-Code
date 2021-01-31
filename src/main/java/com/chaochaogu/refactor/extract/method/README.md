#提炼函数
```
void printOwing() {
      Enumeration e = _orders.elements();
      double outstanding = 0.0;
      // print banner
      System.out.println ("**************************");
      System.out.println ("***** Customer Owes ******");
      System.out.println ("**************************");
      // calculate outstanding
      while (e.hasMoreElements()) {
          Order each = (Order) e.nextElement();
          outstanding += each.getAmount();
      }
      //print details
      System.out.println ("name:" + _name);
      System.out.println ("amount" + outstanding);
  }
```
==>
```
void printOwing() {
      Enumeration e = _orders.elements();
      double outstanding = 0.0;
      printBanner();
      // calculate outstanding
      while (e.hasMoreElements()) {
          Order each = (Order) e.nextElement();
          outstanding += each.getAmount();
      }
      //print details
      System.out.println ("name:" + _name);
      System.out.println ("amount" + outstanding);
  }
  void printBanner() {
      // print banner
      System.out.println ("**************************");
      System.out.println ("***** Customer Owes ******");
      System.out.println ("**************************");
  }
```
==>
```
void printOwing() {
      Enumeration e = _orders.elements();
      double outstanding = 0.0;
      printBanner();
      // calculate outstanding
      while (e.hasMoreElements()) {
          Order each = (Order) e.nextElement();
          outstanding += each.getAmount();
      }
      printDetails(outstanding);
  }
  void printDetails (double outstanding) {
      System.out.println ("name:" + _name);
      System.out.println ("amount" + outstanding);
  }
```
==>
```
void printOwing() {
       printBanner();
       double outstanding = getOutstanding();
       printDetails(outstanding);
   }
   double getOutstanding() {
       Enumeration e = _orders.elements();
       double outstanding = 0.0;
       while (e.hasMoreElements()) {
           Order each = (Order) e.nextElement();
           outstanding += each.getAmount();
       }
       return outstanding;
   }
```


