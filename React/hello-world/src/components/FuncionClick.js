// Event handling in case of functional components..
import React from 'react'

function FuncionClick() {

    function  clickHandler(){
        console.log("Button being clicked")
    }

  return (
    <div>
      <button onClick={clickHandler} >Click</button>
      {/* Parentheses is not to be added.. as of reason mentioned below.. */}
      {/* Event handler is function (which will be called upon the happening of the event, 
        rather than a function call which will keep on happening, worst in the case of setState() thing) */}
    </div>
  )
//  Here clickHandler or onClick has to be camel-cased for React 
//  instead of lowercase in HTML/ or other place.
}

export default FuncionClick
