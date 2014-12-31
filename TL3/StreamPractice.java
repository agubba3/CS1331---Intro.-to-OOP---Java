import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {

    // public void sort(ArrayList b, Comparator c) {
    //     sortthis.stream().filter()
    // }
    static class Song {
        private String artist;
        private String album;
        private int track;

        public Song(String a, String a1, int t) {
            artist = a;
            album = a1;
            track = t;
        }

        public boolean equals(Object other) {
            if (null == other) return false;
            if (this == other) return true;
            if (!(other instanceof Song)) return false;
            Song that = (Song) other;
            return this.artist.equals(that.artist)
            && this.album.equals(that.album) && this.track == that.track;
        }
        public int hashCode() {
        int result = 17;
        result = 31 * result + artist.hashCode();
        result = 31 * result + album.hashCode();
        result = 31 * result + track;
        return result;
        }

        public String getName() {
            return artist;
        }
        public String getAlbum() {
            return album;
        }
        public int getTrack() {
            return track;
        }

        public String toString() {
            return "\n" + "Artist: " + artist + " Album: " + album + " track: " + track;
        }
    }
    public static void main(String[] args) {
        List<Trooper> sortthis = new ArrayList<>();
        sortthis.add(new Trooper("Ani", false));
        sortthis.add(new Trooper("Salt",true));
        sortthis.add(new Trooper("Rahul", false));
        sortthis.add(new Trooper("Typical Indian", true));

        // Collections.sort(sortthis, (Trooper a, Trooper b) -> {
        //     if(a.hasMustache() && !b.hasMustache()) {
        //         return -1;
        //     } else if(!a.hasMustache() && b.hasMustache()) {
        //         return 1;
        //     } else {
        //         return a.compareTo(b);
        //     }
        // });

        //sortthis.stream().filter(Trooper::hasMustache).forEach(a -> System.out.println(a.getName())); This prints only their names
        //sortthis.stream().filter(Trooper::hasMustache).forEach(System.out::println); This prints both of them

        //sortthis.stream().filter(Trooper::hasMustache).map(a -> a.getName() + "YES!").forEach(System.out::println); //replaces the element to be displayed with just the name plus yes
        //sortthis.stream().filter(Trooper::hasMustache).map(a -> a.getName() + "YES!").forEach(a -> System.out.println(a.getName())); Does not work because it is no longer a list of troopers

        //List<String> sortthisAfter = sortthis.stream().filter(Trooper::hasMustache).sorted((a,b) -> a.compareTo(b)).map(c -> c.getName() + " nigs!").collect(Collectors.toList());;
        List<String> sortthisAfter = sortthis.stream().filter(Trooper::hasMustache).sorted((a,b) -> a.compareTo(b)).map(c -> c.getName() + " " +c.hasMustache()).collect(Collectors.toList());
        System.out.println("sorted" + sortthisAfter);
        List<Integer> nigs = new ArrayList<>();
        nigs.add(1);
        nigs.add(4);
        nigs.add(67);
        nigs.add(2);
        List<Integer> newlist = nigs.stream().sorted((a,b) -> a.compareTo(b)).map(a -> a.intValue() + 1).collect(Collectors.toList());
        System.out.println(newlist);
        List<Song> play = new ArrayList<>();
        play.add(new Song("Weezy", "Aigas", 5));
        play.add(new Song("Andy Grammer", "Gurla", 5));
        play.add(new Song("Weezy", "Nigas", 5));
        play.add(new Song("Weezy", "Nigas", 7));
        play.add(new Song("Weezy", "Nigas", 9));
        play.add(new Song("Andy Grammer", "Gurla", 6));
        play.add(new Song("Andy Grammer", "Gurla", 7));
        play.add(new Song("Andy Grammer", "Boyds", 7));
        play.add(new Song("Andy Grammer", "Boyds", 4));
        play.add(new Song("Andy Grammer", "Boyds", 2));
        play.add(new Song("Andy Grammer", "Boyds", 9));
        play.add(new Song("Weezy", "Nigas", 5));
        play.add(new Song("Weezy", "Nigas", 5));
        play.add(new Song("Weezy", "zigas", 5));
//by artist, then album, then track number
        Set<Song> playlist = new HashSet<>(play);
        Comparator<Song> byMustacheThenName =
            Comparator.comparing(Song::getName)
            .thenComparing(Song::getAlbum).thenComparing((a,b) -> a.getTrack()-b.getTrack());

        int mystery = IntStream.range(1,5).reduce(0,(a,b) -> a * b);
        System.out.println(mystery);
        //System.out.println(playlist);
        //List<Song> playboi = playlist.stream().sorted((a,b) -> a.getName().compareTo(b.getName())).sorted((a,b) -> a.getAlbum().compareTo(b.getAlbum())).sorted((a,b) -> a.getTrack() - b.getTrack()).collect(Collectors.toList());
        //List<Song> playboi = playlist.stream().sorted((a,b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
        List<Song> playboii = playlist.stream().sorted(byMustacheThenName).collect(Collectors.toList());
        //List<Song> playboii1 = playboi.stream().sorted((a,b) -> a.getTrack()-b.getTrack()).collect(Collectors.toList());

        System.out.println(playboii);

    }

}