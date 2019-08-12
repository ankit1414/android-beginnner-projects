package com.example.moviemania

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesList.text = primary_displayall()
        actionButton.setOnClickListener {
            val list = MarvelMovies.filter {
                it.genre.contains("action")
            }
            moviesList.text = getMovieString(list)
        }
        scifiButton.setOnClickListener {
            val list = MarvelMovies.filter {
                it.genre.contains("sci-fi")
            }
            moviesList.text = getMovieString(list)
        }
        aboveButton.setOnClickListener {
            val list= MarvelMovies.filter {
                it.rating >=4.7
            }
            moviesList.text = getMovieString(list)
        }
        yearButton.setOnClickListener {
            val list = MarvelMovies.filter {
                it.year == 2017
            }
            moviesList.text = getMovieString(list)
        }
        removeFilter_Button.setOnClickListener {
            moviesList.text = primary_displayall()
        }

    }
}
fun primary_displayall(): String{
    val sb =StringBuilder()
    for(movies in MarvelMovies){
        sb.append(movies.name + "____" + movies.rating + "____" + movies.year + "____" + movies.genre.get(0) + "/" + movies.genre.get(1) +"\n")
    }

    return sb.toString()
}
fun getMovieString(list: List<Movie>):String {

    val sb = StringBuilder()
    for(movie in list){
        sb.append(movie.name + "\n")
    }
    return sb.toString()
}
data class Movie(val name:String , val year: Int  , val rating: Double , val genre:List<String> , val author: String)
val MarvelMovies = listOf(Movie("civil war" , 2016 , 5.0 , listOf("thriller", "sci-fi") , "Russo"),
    Movie("Avengers-End game" , 2019 , 5.0 , listOf("action", "sci-fi") , "Russo"),
    Movie("venom" , 2018 , 4.0 , listOf("thriller", "sci-fi") , "Russo"),
    Movie("The Hobbit" , 2013 , 5.0 , listOf("drama", "horror") , "Russo"),
    Movie("iron man 3" , 2013 , 4.8 , listOf("action", "sci-fi") , "Russo"),
    Movie("The Ghazi Attack" , 2017 , 5.9 , listOf("drama", "romance") , "Russo"),
    Movie("Thor" , 2018 , 3.5 , listOf("romance", "action") , "Russo"),
    Movie("Newton" , 2017 , 2.5 , listOf("Drama", "Comedy") , "Russo")
)

