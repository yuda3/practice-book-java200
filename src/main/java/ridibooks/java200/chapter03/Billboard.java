package ridibooks.java200.chapter03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Billboard implements Serializable {

    private int rank;
    private String song;
    private int lastWeek;
    private String imageSrc;
    private String artistSrc;
    private String artist;

    public Billboard(int rank, String song, int lastWeek, String imageSrc, String artistSrc, String artist) {
        this.rank = rank;
        this.song = song;
        this.lastWeek = lastWeek;
        this.imageSrc = imageSrc;
        this.artistSrc = artistSrc;
        this.artist = artist;
    }

    public Billboard(int rank, String song, int lastWeek, String imageSrc, String artist) {
        this.rank = rank;
        this.song = song;
        this.lastWeek = lastWeek;
        this.imageSrc = imageSrc;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Billboard{" +
                "rank=" + rank +
                ", song='" + song + '\'' +
                ", lastWeek=" + lastWeek +
                ", artistSrc='" + artistSrc + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
