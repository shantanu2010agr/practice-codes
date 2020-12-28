// This doesn't contains JSX code.
import React from 'react'

const HellonJSX = () => {
    return React.createElement('div',
    // {id : 'Hello', class: 'dummyClass' }, //only 'class' will show console warning because,
                                             //it detect it similar to class components thing(??)
    {id : 'Hello', className: 'dummyClass' }, //attributes to be added.
    React.createElement('h1',null,'h1','Hello from HellonJSX component')
    )
}

export default HellonJSX