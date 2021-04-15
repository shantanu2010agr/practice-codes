// Understanding state, it's uses and it's modification in React 
import React, {Component} from 'react'

class Counter extends Component{
    constructor(props){
        super(props)
        this.state={
            count: 0
            // message: "Hello frand including State of Component"
        }
    }

    Increment(){
        // this.state.count = this.state.count +1
        // console.log(this.state.count)
        // (Problem) This doesn't let to refresh the rendering or change the value to be shown in UI
        // Hence, we have to use this.setState() method to get the required change. 

        // this.setState(
        //     {
        //         count: this.state.count+1 
        //     },
        //     () => {
        //         console.log("Callback value",this.state.count)
        //     }
        //     // This callback thing "()" solves the below mentioned problem.
        //     // As this will be occuring synchronously..
        // )
        // console.log(this.state.count)
        // (Problem) But still console outputs shows that console function being happened before setState() thing.
    
        this.setState((prevState, props)=>(
            {
                // if (props,_addValue==NaN) {
                        count: prevState.count+ 1                 
                // } else{
                    // count: prevState.count+ parseInt(this.props.addValue)
                // }
                // This if/else thing can be looked for....(??)
            }
        ))
        // We should prevState to get the change on the previous states.
    }

    IncrementFive(){
        this.Increment()
        this.Increment()
        this.Increment()
        this.Increment()
        this.Increment()
        // (Problem)React groups multiple calls into single calls and 
        // hence every time we will be having 0 as value (initially) and hence can't be increased by 5
        // Thus, we need to use prevState thing to solve this problem. 
    }

    render(){
         return(
             <div>
                 <p>Count={this.state.count}</p>
                 <button onClick={() => this.Increment()}>Increment</button>
                 <button onClick={() => this.IncrementFive()}>IncrementFive</button>
             </div>
         ) 
    }
}

export default Counter