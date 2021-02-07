#引入断言
某一段代码需要对程序状态（state）做出某种假设。
以assertion（断言）明确表现这种假设。
注意，不要滥用assertions 。
请不要使用它来检查你「认为应该为真」的条件，请只使用它来检查「一定必须为真」的条件。
```angular2html
double getExpenseLimit() {
      // should have either expense limit or a primary project
      return (_expenseLimit != NULL_EXPENSE) ?
          _expenseLimit:
          _primaryProject.getMemberExpenseLimit();
  }
```
==>
```angular2html
double getExpenseLimit() {
      Assert.isTrue (_expenseLimit != NULL_EXPENSE || _primaryProject != null);
      return (_expenseLimit != NULL_EXPENSE) ?
          _expenseLimit:
          _primaryProject.getMemberExpenseLimit();
  }
```