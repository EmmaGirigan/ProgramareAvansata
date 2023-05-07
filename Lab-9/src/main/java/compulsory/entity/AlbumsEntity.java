package compulsory.entity;

import jakarta.persistence.*;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Albums.findById",
                        query = "select a from AlbumsEntity a where a.id=:id")
                ,
                @NamedQuery(name = "Albums.findByName",
                        query = "select a from AlbumsEntity a where a.name=:name")
        }
)
@Table(name = "albums", schema = "public", catalog = "postgres")
public class AlbumsEntity extends AbstractEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "release_year")
    private Integer releaseYear;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "artist")
    private String artist;
    @Basic
    @Column(name = "genre")
    private String genre;

    public AlbumsEntity() {
    }

    public AlbumsEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumsEntity that = (AlbumsEntity) o;

        if (id != that.id) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
