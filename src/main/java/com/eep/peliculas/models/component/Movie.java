package com.eep.peliculas.models.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Movie {

	private String Title, Director, Year, Runtime, imdbID, Poster, Genre, Writer, 
	Actors, Plot, Rating, DvdRelease, ProductionCompany,
    Country, Awards, TvRated, MovieType;
	private int Puntuacion;
	
	public Movie() {}

	public Movie(String title, String director, String year, String runtime, String imdbId, String poster, String genre,
			String writer, String actors, String plot, String rating, String dvdRelease, String productionCompany,
			String country, String awards, String tvRated, String movieType) {
		super();
		Title = title;
		Director = director;
		Year = year;
		Runtime = runtime;
		imdbID = imdbId;
		Poster = poster;
		Genre = genre;
		Writer = writer;
		Actors = actors;
		Plot = plot;
		Rating = rating;
		DvdRelease = dvdRelease;
		ProductionCompany = productionCompany;
		Country = country;
		Awards = awards;
		TvRated = tvRated;
		MovieType = movieType;
		Puntuacion=0;
	}

	@Override
	public String toString() {
		return "Movie [Title=" + Title + ", Director=" + Director + ", Year=" + Year + ", Runtime=" + Runtime + ", Puntuacion=" + Puntuacion
				+ ", ImdbId=" + imdbID + ", Poster=" + Poster + ", Genre=" + Genre + ", Writer=" + Writer + ", Actors="
				+ Actors + ", Plot=" + Plot + ", Rating=" + Rating + ", DvdRelease=" + DvdRelease
				+ ", ProductionCompany=" + ProductionCompany + ", Country=" + Country + ", Awards=" + Awards
				+ ", TvRated=" + TvRated + ", MovieType=" + MovieType + "]";
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getImdbId() {
		return imdbID;
	}

	public void setImdbId(String imdbId) {
		imdbID = imdbId;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		Actors = actors;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getDvdRelease() {
		return DvdRelease;
	}

	public void setDvdRelease(String dvdRelease) {
		DvdRelease = dvdRelease;
	}

	public String getProductionCompany() {
		return ProductionCompany;
	}

	public void setProductionCompany(String productionCompany) {
		ProductionCompany = productionCompany;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getTvRated() {
		return TvRated;
	}

	public void setTvRated(String tvRated) {
		TvRated = tvRated;
	}

	public String getMovieType() {
		return MovieType;
	}

	public void setMovieType(String movieType) {
		MovieType = movieType;
	}

	public int getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		Puntuacion = puntuacion;
	}

	
}