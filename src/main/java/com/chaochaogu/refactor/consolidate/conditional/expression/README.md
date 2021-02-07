#合并条件式
你有一系列条件测试，都得到相同结果。
将这些测试合并为一个条件式，并将这个条件式提炼成为一个独立函数。
```angular2html
double disabilityAmount() {
      if (_seniority < 2) return 0;
      if (_monthsDisabled > 12) return 0;
      if (_isPartTime) return 0;
      // compute the disability amount
```
==>
```angular2html
double disabilityAmount() {
      if (isNotEligableForDisability()) return 0;
      // compute the disability amount
```