package compulsory.entity;


public class Album {

  private long id;
  private long releaseYear;
  private String name;
  private String artist;
  private String genre;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(long releaseYear) {
    this.releaseYear = releaseYear;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }


  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}
