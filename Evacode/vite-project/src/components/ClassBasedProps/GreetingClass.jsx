import React, { Component } from 'react'

export default class GreetingClass extends Component {

  render() { 
    const { name,role,age} = this.props;
    return (
      <>
       <h1>hello  {name} and the age {age}  the jop is  {role}</h1> 
      </>
    )
  }
}

//  So… Why do we pass values to props in App.jsx?
// To make components reusable
// → One component, many uses.
// To keep data in one place (App.jsx or parent)
// → Easier to manage, update, or fetch from an API later.
// To avoid hard-coding values
// → Your component doesn’t “know” the name — it just displays whatever it’s given.
// To follow React’s data flow rule: “Parent → Child”
// → Props are how parents safely send data down to children.
// To prepare for real apps
// → In real projects, App.jsx (or a parent) might get data from a database, then pass it via props to display lists, user info, products, etc.