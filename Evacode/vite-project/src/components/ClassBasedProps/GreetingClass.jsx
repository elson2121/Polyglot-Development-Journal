import React, { Component } from 'react'

export default class GreetingClass extends Component {

  render() { 
    const { name,age } = this.props;
    return (
      <>
       <h1>hello  {name} and the age is {age}</h1> 
      </>
    )
  }
}
