/**
 * Section 4 Lecture 50 - call(), apply(), and bind()
 * 
 * 'this' points to the object that contains the function if
 * the function is a method attached to an object.
 *
 * We can control 'this' when the execution context is created.
 */

(function () {

  var person = {
    firstName: 'Kathryn',
    lastName: 'Brusewitz',
    getFullName: function() {
      var fullName = this.firstName + ' ' + this.lastName;
      return fullName;
    }
  };

  var logName = function(a, b) {
    console.log('Logged: ' + this.getFullName());
    console.log('Arguments: ' + a + ', ' + b);
  }.bind(person, 1, 2); // .bind() creates a copy of the function

  logName();

})();

(function () {

  var person = {
    firstName: 'Kathryn',
    lastName: 'Brusewitz',
    getFullName: function() {
      var fullName = this.firstName + ' ' + this.lastName;
      return fullName;
    }
  };

  var logName = function(a, b) {
    console.log('Logged: ' + this.getFullName());
    console.log('Arguments: ' + a + ', ' + b);
  };

  logName.call(person, 6, 9); // .call() executes on creation

})();

(function () {

  var person = {
    firstName: 'Kathryn',
    lastName: 'Brusewitz',
    getFullName: function() {
      var fullName = this.firstName + ' ' + this.lastName;
      return fullName;
    }
  };

  var logName = function(a, b) {
    console.log('Logged: ' + this.getFullName());
    console.log('Arguments: ' + a + ', ' + b);
  };

  logName.apply(person, [4, 2]); // same as .call() but with an array

})();

/**
 * Function Borrowing w/ .call() and .apply()
 */

(function () {

  var person = {
    firstName: 'Kathryn',
    lastName: 'Brusewitz',
    getFullName: function() {
      var fullName = this.firstName + ' ' + this.lastName;
      return fullName;
    }
  };

  var person2 = {
    firstName: 'Leo',
    lastName: 'Brusewitz'
  };

  console.log(person.getFullName.apply(person2)); // Leo Brusewitz

})();

/**
 * Function Currying with .bind()
 * Create a copy of the function and preset default parameters
 */

 (function () {

  function multiply(a, b) {
    return a * b;
  }

  var mutliplyBy2 = multiply.bind(this, 2); // .bind() creates a copy
  var mutliplyBy3 = multiply.bind(this, 3);
  var mutliplyBy4 = multiply.bind(this, 4);

  console.log(mutliplyBy2(3));
  console.log(mutliplyBy3(3));
  console.log(mutliplyBy4(3));

})();