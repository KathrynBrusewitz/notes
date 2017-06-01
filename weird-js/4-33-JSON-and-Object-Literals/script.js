/**
 * Section 4 Lecture 33 - JSON and Object Literals
 * 
 * Any JSON is valid object literal syntax but
 * JSON properties always have to be wrapped in quotes
 */

(function () {

  var objectLiteral = {
  	firstName: 'first',
  	lastName: 'last'
  };

  console.log(JSON.stringify(objectLiteral));
  // {"firstName":"first","lastName":"last"}

  var jsonString = '{ "firstName": "first", "lastName": "last" }';

  console.log(JSON.parse(jsonString));
  // Object {firstName: "first", lastName: "last"}

})();