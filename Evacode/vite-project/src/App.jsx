
import './App.css'
import GreetingClass from './components/ClassBasedProps/GreetingClass'
import Geeting from './components/FuncGetting/Geeting'

function App() {
 
  return (
    <>
    <Geeting   />
    <GreetingClass name="kebede" age={30} />
    </>
  )
}

export default App
