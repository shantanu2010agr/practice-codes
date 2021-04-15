* What is React? Uses?
* About the Course
    * Have to work on Pre-Requisites
        * HTML/CSS
        * JavaScript
        * Es6 classes
* Creating basic React UI using create-react-app through npx/npm and thgeir differences
* Folder structure (describing various files, their uses order and the priority involved.)
* What is Component, why necessary, how they are implemented.
* Types of components:
    * Stateless Functional C
    * Stateful Class C
* An example of Stateless Functional Component added (normal/es6 form both) (Greet.js)
* default (not-named) and (named) exports, generally default one is being used.
* An example of Stateful Class Component (Welcome.js) and it's verification using two steps:
    * Should extend "Component"(exported externally here)
    * Should have render method (??) (Should return NULL or some HTML code)
* comparison between the above two types of Components.
* Now the difference of being stateful/stateless should be removed from the comparison (after the release of new updates) --> so now, two types of components are:
    * Functional Components
    * Class Components
* What is JSX (Java-Script XML)? It's uses? (Eg., of two codes to show how it simplifies the code.)
* class vs className (console error thing), and other JSX differences.
* Props (short form for properties) 
* Differnce betwwen dynamic and non-dynamic props, and how they are presented in both types of components.
* Props are immutable, they can't be changed.
* State (of Class Component, and state Hooks for Functional Component) solves the above problem as some of the values might change over the time.
* Implementation of state and changes in it. (??) (to understand more abt it)
* Do's and Dont's for setState and State methods mentioned in the imnplementation above.
* Summary for showing things to be cared about: (**Photo**)
* Destructuring the props and state
* Two ways of doing so:
    * by changing the parameter props with required attributes, and
    * by creating the constants of required properties
* Event handling: using function (not using parentheses), not function call in both functions and classes components (can be used in setState thing, to be cared abt)
* Binding Event