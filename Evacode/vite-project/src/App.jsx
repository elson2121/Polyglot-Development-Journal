
import './App.css'
import GreetingClass from './components/ClassBasedProps/GreetingClass'
import Geeting from './components/FuncGetting/Geeting'

function App() {
 
  return (
    <>
    {userData?.map((item,i) => { 
      const {name,rol} = item
      return <GreetingClass key={i} name={name} rol={rol} />
    })}
    <Geeting   />
    <GreetingClass name="kebede" age={30} />
    </>
  )
}

export default App
