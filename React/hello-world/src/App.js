// import logo from './logo.svg';
// Not using hence marked as comment

import './App.css';

// "Mine" is the constant (HTML) as exported from Greet.js file.
import {Mine} from './components/Greet'
//  Otherwise "{Mine}" can be replaced with anything or any of the name (default case). like below:
import Welcomet from './components/Welcome'
import Message from './components/Message'
import Hello from './components/Hello'
import HellonJSX from './components/HellonJSX'
import Counter from './components/Counter';

function App() {
  return (
    <div className="App">
      {/* Initial template
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
           **To see the change** 
          Hello Frands.. This is Hello World!
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      
      {/* Importing newly created component */}
      <Mine name="" heroName=""/>
      {/* Here, properties are surely known in the form of format or type, hence can be passed as attributes */}
      <Mine name="JaiDeep"/>
      <Mine heroName="Shiv Shambu"> 
      {/* But here, the property was dynamic or not-known about, 
      hence was added as HTML code in between the component's opening and closing tags. */}
      {/* Adding a children prop is as followed: */}
        <p>This is for children props.</p>
      </Mine>
      
      {/* or can be shown as <Greet></Greet> like below*/}
      <Welcomet name="Bruce" heroName="Batman">
        <button>Gotham Calling..</button>
      </Welcomet>
      <Welcomet name="Clark" heroName="Superman" />

      {/* Using states of the classes: */}
      <Message />
      {/* defining setState and state methods in detatil */}
      <Counter />

      <Hello />
      <HellonJSX />
     </div>
  );
}

export default App;
