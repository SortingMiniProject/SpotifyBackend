package com.nighthawk.spring_portfolio;

public class Song {
    public class Song {
        private String title;
        private String artist;
        private int year;
    
        public Song(String title, String artist, int year) {
            this.title = title;
            this.artist = artist;
            this.year = year;
        }
    
        public String getTitle() {
            return title;
        }
    
        public String getArtist() {
            return artist;
        }
    
        public int getYear() {
            return year;
        }
    
        public void play() {
            System.out.println("Playing: " + title + " by " + artist);
        }
    
        public static void main(String[] args) {
            Song mySong = new Song("Shape of You", "Ed Sheeran", 2017);
    
            System.out.println("Song Title: " + mySong.getTitle());
            System.out.println("Artist: " + mySong.getArtist());
            System.out.println("Year: " + mySong.getYear());
    
            mySong.play();
        }
    }
    
}
