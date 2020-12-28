// Functional Component
import React from 'react'

// function Greet(){
//     return <h1>Helllo from Shantanu!!</h1>
// }

// Now, implementing the same as above using es6 classes.
// const Greet = () => <h1>Hello Frands from es6</h1>

// "export default" represents any export from here will be the Greet one and thus can be named any thing
// export default Greet

// Then the below shows the export has to be with this name only.. 
// generating a constant which is to be exported as it is..
export const Mine = (props) => {
    console.log(props) 
    //Creating/Initializing(??) an object
    return(
        <div>
            <h1>Hello Frand {props.name} of {props.heroName} from es6</h1> 
            {props.children}
            {/* // Using objects state using curly-bracket feature of JSX for react applications.  */}
        </div>
    )
}
// It is some JSX element and it can only have one single parent element.