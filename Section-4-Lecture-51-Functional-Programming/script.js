/**
 * Section 4 Lecture 51 - Functional Programming
 */

/** 
 * In a classical language, we might write this...
 */

(function () {

  var arr1 = [1, 2, 3];

  console.log(arr1);

  var arr2 = [];

  for (var i = 0; i < arr1.length; i++) {
    arr2.push(arr1[i] * 2);
  }

  console.log(arr2);
  
})();

/** 
 * In functional programming, we can use mapping...
 * This allows for reusing the map to do entirely different work
 * against the array just by passing the function (the work we
 * we want done on each item).
 */

(function () {

  function mapForEach(arr, fn) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
      newArr.push(
        fn(arr[i])
      )
    };
    return newArr;
  }

  var arr1 = [1, 2, 3];
  console.log(arr1);

  var arr2 = mapForEach(arr1, function(item) {
    return item * 2; // work to do on each item in array
  });
  console.log(arr2);

  var arr3 = mapForEach(arr1, function(item) {
    return item > 2; // work to do on each item in array
  });
  console.log(arr3);
  
})();

/** 
 * In functional programming, we can use mapping...
 * This allows for reusing the map to do entirely different work
 * against the array just by passing the function (the work we
 * we want done on each item).
 */

(function () {

  function mapForEach(arr, fn) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
      newArr.push(
        fn(arr[i])
      )
    };
    return newArr;
  }

  var arr1 = [1, 2, 3];
  console.log(arr1);

  var arr2 = mapForEach(arr1, function(item) {
    return item * 2; // work to do on each item in array
  });
  console.log(arr2);

  var arr3 = mapForEach(arr1, function(item) {
    return item > 2; // work to do on each item in array
  });
  console.log(arr3);
  
})();