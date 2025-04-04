import { useState } from 'react'
import './App.css'
import ListTodoComponent from './components/ListTodoComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <ListTodoComponent/>
    </>
  )
}

export default App
