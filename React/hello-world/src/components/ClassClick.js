import React, { Component } from 'react'

export class ClassClick extends Component {

    clickHandler(){
        console.log("Again, a button is pressed.")
    }

  render() {
    return (
      <div>
          <button onClick={this.clickHandler}>Hit Me..!!</button>
      </div>
    )
  }
}

export default ClassClick
