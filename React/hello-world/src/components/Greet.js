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
// // generating a constant which is to be exported as it is..

// BASIC INITIAL CODE TAKEN
// export const Mine = (props) => {
//     console.log(props) 
//     //To show the properties being involving or object being taken to this function
//     return(
//         <div>
//             <h1>Hello Frand {props.name} of {props.heroName} from es6</h1> 
//             {props.children}
//             {/* // Using objects state using curly-bracket feature of JSX for react applications.  */}
//         </div>
//     )
// }

// DESTRUCTURING..... (Two ways of it)

// (FIRST Method) Same code after destructuring the props as parameter(s)
// export const Mine = ({name,heroName,children}) => {
//     //extracting the only required properties 
//     return(
//         <div>
//             <h1>Hello Frand {name} of {heroName} from es6</h1> 
//             {children}
//         </div>
//     )
// }

// (SECOND Method) Same code after destructuring the props inside the function body.
export const Mine = (props) => {
    const {name,heroName} = props
    // These constants can't be named with other names 
    // (should be similar to that of additional tags added with it)
    return(
        <div>
            <h1>Hello Frand {name} of {heroName} from es6</h1> 
            {props.children}
            {/* Variation in children and other properties were added to show the effect */}
        </div>
    )
}

// It is some JSX element and it can only have one single parent element.