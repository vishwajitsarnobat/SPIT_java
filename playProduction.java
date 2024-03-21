class Production {
    private String title;
    private String director;
    private String writer;

    public Production(String title, String director, String writer) {
        this.title = title;
        this.director = director;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDirector: " + director + "\nWriter: " + writer;
    }
}

class Play extends Production {
    private int performances;

    public Play(String title, String director, String writer) {
        super(title, director, writer);
        performances = 0; // Initially no performances
    }

    public int getPerformances() {
        return performances;
    }

    public void setPerformances(int performances) {
        this.performances = performances;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPerformances: " + performances;
    }
}

class Musical extends Play {
    private String composer;
    private String lyricist;

    public Musical(String title, String director, String writer, String composer, String lyricist) {
        super(title, director, writer);
        this.composer = composer;
        this.lyricist = lyricist;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    @Override
    public String toString() {
        return super.toString() + "\nComposer: " + composer + "\nLyricist: " + lyricist;
    }
}

public class playProduction {
    public static void main(String[] args) {
        int costPerSeatPlay = 500;
        int costPerSeatMusical = 800;

        Play play1 = new Play("Hamlet", "Shakespeare", "Shakespeare");
        play1.setPerformances(play1.getPerformances() + 1);
        int seatsBookedPlay1 = 100;

        Play play2 = new Play("Romeo and Juliet", "Shakespeare", "Shakespeare");
        play2.setPerformances(play2.getPerformances() + 1);
        int seatsBookedPlay2 = 150;

        Play play3 = new Play("Macbeth", "Shakespeare", "Shakespeare");
        play3.setPerformances(play3.getPerformances() + 1);
        int seatsBookedPlay3 = 120;

        Musical musical1 = new Musical("The Phantom of the Opera", "Andrew Lloyd Webber", "Andrew Lloyd Webber", "Andrew Lloyd Webber", "Charles Hart");
        musical1.setPerformances(musical1.getPerformances() + 1);
        int seatsBookedMusical1 = 200;

        Musical musical2 = new Musical("Les Misérables", "Claude-Michel Schönberg", "Alain Boublil", "Claude-Michel Schönberg", "Herbert Kretzmer");
        musical2.setPerformances(musical2.getPerformances() + 1);
        int seatsBookedMusical2 = 180;

        int totalPerformances = play1.getPerformances() + play2.getPerformances() + play3.getPerformances() +
                                musical1.getPerformances() + musical2.getPerformances();

        int boxOfficePlay = costPerSeatPlay * (seatsBookedPlay1 + seatsBookedPlay2 + seatsBookedPlay3);
        int boxOfficeMusical = costPerSeatMusical * (seatsBookedMusical1 + seatsBookedMusical2);
        int totalBoxOffice = boxOfficePlay + boxOfficeMusical;

        System.out.println("Total No. of Performances: " + totalPerformances);
        System.out.println("Total Box Office Collection: Rs " + totalBoxOffice);
    }
}
