package com.techmonad.rest

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.techmonad.json.JsonUtility

object RestService {

  import JsonUtility._

  def main(args: Array[String]): Unit = {

    /**
      * create ActorSystem & ActorMaterializer
      *
      */

    implicit val system: ActorSystem = ActorSystem("RestServiceApp")

    implicit val materializer: ActorMaterializer = ActorMaterializer()


    /**
      * Create routes
      */
    val route =
      path("person" / "getAll") {
        get {
          complete {
            val persons: List[Person] = FakePersonDB.getAll()
            write(persons) // person list convert json and return as response
          }
        }
      } ~
        path("person" / "getByName") {
          get {
            parameters('name.as[String]) { name => // URL parameter
              complete {
                val persons: List[Person] = FakePersonDB.getByName(name)
                write(persons) // person list convert json and return as response
              }
            }
          }
        } ~
        path("person" / "save") {
          post {
            entity(as[String]) { // post body parameter
              personJson =>
                complete {
                  val person = parse(personJson).extract[Person]
                  FakePersonDB.save(person)
                  "Person saved successfully"
                }
            }
          }
        }


    /**
      * Start Rest service on port 8000
      */
    val port = 8000
    Http().bindAndHandle(route, "localhost", port)

    println(s"Rest service is running on $port")

  }

}


object FakePersonDB {

  private var persons = List[Person](Person("Bob", "bob@gmail.com", 32))

  def getAll(): List[Person] = persons

  def getByName(name: String): List[Person] = persons.filter(_.name.toLowerCase == name)

  def save(person: Person): Unit = {
    persons = persons :+ person
  }

}


case class Person(name: String, email: String, age: Int)
