/**
 * Section 4 Lecture 46 - Understanding Closures
 * 
 * Even after the execution context of
 * var multiplyBy3 = multiply(3) disappears from the stack
 * factor is still in memory
 * so multiplyBy3(10) will look for factor up the scope chain
 * to its outer environment.
 *
 * This is called Closure... like an imaginary box around the 
 * multiplyBy3() execution context and the factor variable
 * residing outside the context.
 */

(function () {

  function multiply(factor) {
    return function(num) {
      return factor * num;
    }
  }

  // gets function returned
  var multiplyBy3 = multiply(3);
  var multiplyBy4 = multiply(4);

  console.log(multiplyBy3(10)); // 30
  console.log(multiplyBy4(2)); // 8

})();