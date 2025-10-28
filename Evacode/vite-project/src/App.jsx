
import './App.css'
import GreetingClass from './components/ClassBasedProps/GreetingClass'
import Geeting from './components/FuncGetting/Geeting'
import DataHolder from './components/ClassBasedProps/DataHolder'
import Stata from './Stata'
function App() {
 
  return (
    <>
    {DataHolder?.map((item,i) => { 
      const {name,role,age} = item
      return <GreetingClass key={i} name={name} rol={role} age={age}/>
    })}
    <Stata/>
    </>
  )
}

export default App
