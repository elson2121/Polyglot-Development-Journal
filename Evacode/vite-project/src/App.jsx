
import './App.css'
import GreetingClass from './components/ClassBasedProps/GreetingClass'
import Geeting from './components/FuncGetting/Geeting'
import DataHolder from './data/DataHolder'
function App() {
 
  return (
    <>
    {DataHolder?.map((item,i) => { 
      const {name,rol} = item
      return <GreetingClass key={i} name={name} rol={rol} />
    })}
    </>
  )
}

export default App
