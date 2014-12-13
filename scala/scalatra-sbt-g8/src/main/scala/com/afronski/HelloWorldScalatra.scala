package com.afronski

import org.scalatra._
import scalate.ScalateSupport

class HelloWorldScalatra extends Scalatrasbtg8Stack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
}
