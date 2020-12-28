// Class Component
import React, {Component} from 'react'

class Welcome extends Component{
    render(){
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