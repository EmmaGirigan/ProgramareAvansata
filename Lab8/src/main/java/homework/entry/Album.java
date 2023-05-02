package homework.entry;

public class Album extends Entry {

    private String name;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private Integer year;
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album(int id, Integer year, String name, Artist artist, Genre genre) {
        super(id, name);
        this.year = year;
        this.artist = artist;
        this.genre = genre;
    }

    public Album(Integer year, String name, Artist artist, Genre genre) {
        super(name);
        this.year = year;
        this.artist = artist;
        this.genre = genre;
    }
}
