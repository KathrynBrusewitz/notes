/**
 * Section 2 Lecture 16 - The Scope Chain
 * 
 * myVar in b() will look up the scope chain for its value.
 * 
 * Every execution context has a reference to its outer environment.
 * In this case, a()'s and b()'s outer environment reference is the
 * global execution context.
 */

(function () {

  function b() {
    console.log(myVar);
  }

  function a() {
    var myVar = 2;
    b();
  }

  var myVar = 1;
  a();

})(); // 1

/**
 * If b() was inside a(), b()'s outer environment reference is a()'s
 * execution context.
 */

(function () {

  function a() {
    function b() {
      console.log(myVar);
    }
    var myVar = 2;
    b();
  }

  var myVar = 1;
  a();

})(); // 2