/**
 * Section 4 Lecture 36 - Conceptual Aside: By Value vs By Reference
 * 
 * All primitives pass by value
 * All objects pass by reference
 */

/**
 * By value
 */

(function () {

  function func(b) {
  	b = 2;
  }

  var a = 1;
  func(a);
  console.log(a); // 1

})();

/**
 * By reference
 */

(function () {

  function func(b) {
  	b.someValue = 2;
  }

  var a = {
  	someValue: 1
  }

  func(a);
  console.log(a.someValue); // 2

})();