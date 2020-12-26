// import logo from './logo.svg';
// Not using hence marked as comment
import './App.css';
import Greet from './components/Greet';

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
      <Greet />
      {/* or can be shown as <Greet></Greet> */}
    </div>
  );
}

export default App;
