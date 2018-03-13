/**
 * Section 4 Lecture 47 - Understanding Closures Part 2
 * 
 * When var fns = buildFunctions() finishes executing,
 * buildFunctions() disappears from the stack while the
 * variable i=3 stays in memory in the outer environment.
 * 
 * fns[0]() calls console.log(i), which will look for i 
 * outside its execution context.
 */

(function () {

  function buildFunctions() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
      arr.push(
        function() {
          console.log(i);
        }
      );
    }

    return arr;

  }

  var fns = buildFunctions();

  fns[0](); // 3
  fns[1](); // 3
  fns[2](); // 3

})();

/**
 * Workaround if the above is not what's intended...
 * Use 'let' to keep variable i inside the loop's scope
 */

 (function () {

  function buildFunctions() {
    var arr = [];

    for (let i = 0; i < 3; i++) {
      arr.push(
        function() {
          console.log(i);
        }
      );
    }

    return arr;

  }

  var fns = buildFunctions();

  fns[0](); // 0
  fns[1](); // 1
  fns[2](); // 2

})();

/**
 * Another workaround if ES6's 'let' is not available...
 */

 (function () {

  function buildFunctions() {
    var arr = [];

    for (var i = 0; i < 3; i++) {
      arr.push(
        (function(j) {
          return function() {
            console.log(j);
          }
        })(i)
      );
    }

    return arr;

  }

  var fns = buildFunctions();

  fns[0](); // 0
  fns[1](); // 1
  fns[2](); // 2

})();