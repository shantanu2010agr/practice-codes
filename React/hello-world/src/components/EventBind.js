// Understanding Event Binding
import React, { Component } from 'react'

export class EventBind extends Component {

    constructor(props){
        super(props)

        this.state={
            message:"Hello"
        }
    }

    clickHandler(){
         this.setState({
             message: 'Good bye from event binding:'
         })
        //  "this" keyword is undefined inside the JavaScript.
        // Thus this keyword will not work for any eventHandler.. hence, eventBinding is required.
    }

  render() {
    return (
      <div>
          <div>{this.state.message}</div>
        <button onClick={clickHandler}>Click(Binding)</button>
      </div>
    )
  }
}

export default EventBind
