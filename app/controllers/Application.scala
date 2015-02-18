package controllers

import java.sql.ResultSet

import play.api.Play.current
import play.api.db.DB
import play.api.libs.json._
import play.api.mvc._

object Application extends Controller {
  def index(query: Option[String]) = Action {
    val conn = DB.getConnection()
    var allPokemon: JsArray = JsArray()
    try {
      val stmt = conn.createStatement
      val rs : ResultSet = stmt.executeQuery("SELECT * FROM pokemon")
      while (rs.next()) {
        allPokemon :+= getPokemonJson(rs)
      }
    } finally {
      conn.close()
    }
    Ok(Json.prettyPrint(allPokemon))
  }

  def getPokemonJson(rs: ResultSet): JsValue = {
    JsObject(Seq(
      "number" -> JsNumber(rs.getInt("number")),
      "name" -> JsString(rs.getString("name")), 
      "weight" -> JsNumber(rs.getDouble("weight"))
    ))
  }
}