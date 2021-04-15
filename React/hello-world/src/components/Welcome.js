// Class Component
import React, {Component} from 'react'

class Welcome extends Component{
    render(){
    // Destructuring in the class component can be done as follows:
    // (Similar to functional component):
    // const {name, heroName} = this.props
    // This takes out the required props from the props object
    // And, thus we can remove the "this.props" keyword from the above-mentioned props
    // Similarly, it goes same for destructuring of states:
    // const {state1, state2} = this.state

         return (
            <div>
                <h1>Class Component for {this.props.name} aka {this.props.heroName}
                </h1>
                {this.props.children}
            </div>
         )
    // "Return with brackets" are being used because of HTML code are of more than one tags.
    // The method of using props is being used using "this" keyword. 
    }
}

export default Welcome