/**
 * Section 4 Lecture 37 - Objects, Functions, and 'this'
 *
 * It's the global object when just invoking a function.
 * When the function is a method of an object, it is the object.
 * Internal functions have a problem (see below) e.g. throwing
 * things onto the global object unintentionally.
 */

/**
 * 'this' referring to the global object
 * and 'this' method inside the global object
 */

console.log(this); // Window Object

(function () {

  console.log(this); // Window Object

})();

/**
 * 'this' method inside an object
 */

(function () {

  var person = {
    name: 'Kathryn',
    log: function () {
      console.log(this);
    }
  };

  person.log(); // person Object

})();

/**
 * 'this' method inside an object inside an object
 */

(function () {

  var person = {
    name: 'Kathryn',
    address: {
      city: 'Redmond',
      log: function () {
        console.log(this);
      }
    }
  };

  person.address.log(); // address Object

})();

/**
 * Some weird JavaScript quirk...
 * 'this' method inside an object inside an object
 */

(function () {

  var person = {
    name: 'Kathryn',
    log: function() {
      console.log(this.name); // Kathryn

      this.name = 'Kath';
      console.log(this.name); // Kath

      var update = function() {
        this.name = 'K';
      };

      // doesn't update person object, but rather global object
      // because when its execution context was created, the 'this'
      // keyword points to the global object
      update();
      console.log(this.name); // still Kath
    }
  };

  person.log();

})();

/**
 * Very common orkaround for above quirk...
 * Save the person object into variable 'self' [by reference]
 *
 * The 'let' keyword also solves this problem.
 */

(function () {

  var person = {
    name: 'Kathryn',
    log: function() {
      var self = this;

      console.log(self.name); // Kathryn

      self.name = 'Kath';
      console.log(self.name); // Kath

      var update = function() {
        self.name = 'K';
      };

      update();
      console.log(self.name); // K
    }
  };

  person.log();

})();
