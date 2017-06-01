/**
 * Section 2 Lecture 17 - Scope, ES6, and let
 * 
 * let allows block scoping and is used to avoid problems 
 * with closures. It binds fresh value rather than keeping 
 * an old reference.
 * 
 */

(function () {

  {
    let a = 123;
  };

  console.log(typeof a); // undefined

})();

/**
 * compare with behavior of var
 */

(function () {

  {
    var a = 123;
  };

  console.log(typeof a); // number

})();

/** 
 * basically...
 * let is only visible in the for() loop 
 * var is visible to the whole function
 */

 (function () {

  (function () {
    for (let i = 0; i < 3; i++) {
      i;
    }

    if (typeof i) {
      console.log(typeof i); // undefined
    } else {
      console.log(i);
    }
  })();

  (function () {
    for (var i = 0; i < 3; i++) {
      i;
    }

    if (typeof i) {
      console.log(i); // 3
    } else {
      console.log(typeof i);
    }
  })();

})();