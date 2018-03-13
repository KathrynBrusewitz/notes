/**
 * Section 4 Lecture 48 - Function Factories
 * 
 * Factory functions return or make another function.
 *
 * Variable lang is kept in memory in the outer context
 * after makeGreet("en") and makeGreet("es") are finished
 * executing and disappear from the stack.
 * So when englishGreet("Kathryn") runs, it will find lang
 * in the outer environment.
 */

(function () {

	function makeGreet(lang) {

		return function(name) {
			var greet = "";

			if (lang === "en") {
				greet += "Hello ";
			} 

			if (lang === "es") {
				greet += "Hola ";
			} 

			console.log(greet + name);
		}

	}

	var englishGreet = makeGreet("en");
	var spanishGreet = makeGreet("es");

	englishGreet("Kathryn");
	spanishGreet("Kathryn");

})();