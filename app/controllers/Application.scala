package controllers

import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json._
import play.api.mvc._

object Application extends Controller {
  def index(query: Option[String]) = Action {
    Ok(views.html.main())
  }
  
  def getAllPokemon = Action {
    DB.withConnection { implicit c =>
      val result: Stream[Row] = SQL("select * from pokemon;").apply()
      Ok(Json.prettyPrint(getPokemonJson(result)))
    }
  }

  def getPokemonJson(result: Stream[Row]): JsValue = {
    JsArray(result.map(row => {
      JsObject(Seq(
        "number" -> JsNumber(row[Int]("number")),
        "name" -> JsString(row[String]("name")),
        "weight" -> JsNumber(row[Double]("weight"))
      ))
    }))
  }
}