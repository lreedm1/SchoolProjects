//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    MusicPlayer300.java
// Course:   CS 300 Fall 2022
//
// Author:   Aarav Gupta
// Email:    agupta297@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Reed Lokken
// Partner Email: rlokken@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: Github Copilot 
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
* A linked-queue based music player which plays Actual Music Files based on
* keyboard input in an interactive console method.
*/
public class MusicPlayer300 {
	private String filterArtist; // The artist to play if filterPlay is true, null otherwise
	private boolean filterPlay; // Whether or not to filter by artist, false by default
	private Playlist playlist; // The current playlist of songs
	
	/*
	* Creates a new MusicPlayer300 object with an empty playlist
	*/
	public MusicPlayer300() {
		this.playlist = new Playlist();
	}
	
	/*
	* Stops the current song if it exists and clears the current playlist 
	*/
	public void clear() {
		// Stop the current song
		if (playlist.peek() != null) {
			playlist.peek().stop();
		}
		// Clear the current playlist
		while (!playlist.isEmpty()) {
			playlist.dequeue();
		}
	}
	
	/*
	 * loads the playlist of songs in the provided file, skipping any songs that do not load
	 * @throws FileNotFoundException if the file does not exist
	 */
	public void loadPlaylist(File file) throws FileNotFoundException {
		// load the contents of the file into a scanner which throws FileNotFoundException 
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			System.out.println(line);

			// split the line into the song title, artist, and filename
			String[] splitLine = line.split(",");
			String title = splitLine[0];
			String artist = splitLine[1];
			String filepath = "audio/" + splitLine[2]; 

			// declare the song title being loaded            
			System.out.println("Loading" + '"' + title + '"');
			
			// load the song to the playlist or print X if it fails to load
			try{
				loadOneSong(title,artist,filepath);
			} catch (IllegalArgumentException e) {
				System.out.println("X");
			}
		}
		fileScanner.close();
	}
	
	/*
	 * loads a single song to the end of the playlist
	 * @throws IllegalArgumentException if the filepath does not exist or does not begin with "audio/"
	 */
	public void loadOneSong(String title, String artist, String filepath) throws IllegalArgumentException {
		// verify that Filepath begins with "audio/"
		if (!filepath.startsWith("audio/")){
			throw new IllegalArgumentException("the provided filepath does not begin with 'audio/'");
		}

		// create a new song object & add it to the end of the playlist
		Song song = new Song(title, artist, filepath);
		playlist.enqueue(song);
	}

	/*
	 * prints the playlist line by line in the format |"title" (minutes:seconds) by artist|
	 */
	public void printPlaylist(){
		String playlistPrinted = playlist.toString();
		System.out.println(playlistPrinted);
	}

	/*
	 * creates a menu string describing the user-accessible features of MusicPlayer300 and 
	 * how to interact with the MusicPlayer300 user-accessible features
	 * 
	 * @return the menu string
	 */
	public String getMenu(){
		// create the menu string
		String menu = new String(
			"Enter one of the following options:\n" + 
			"[A <filename>] to enqueue a new song file to the end of this playlist\n" + 
			"[F <filename>] to load a new playlist from the given file\n" +
			"[L] to list all songs in the current playlist\n" + 
			"[P] to start playing ALL songs in the playlist from the beginning\n" + 
			"[P -t <Title>] to play all songs in the playlist starting from <Title>\n" + 
			"[P -a <Artist>] to start playing only the songs in the playlist by Artist\n" + 
			"[N] to play the next song\n" + 
			"[Q] to stop playing music and quit the program"
			);

		return menu;
		}

	/*
	 * if a song is playing, pauses the currently plaing song, then plays the next song in the playlist
	 * 
	 * @throws IllegalStateException if the playlist is null or empty or becomes empty during this method call
	 */
	public void playNextSong(){
		checkPlaylistState(); // throws IllegalStateException if the playlist is empty, null, or has a null current song

		// pauses the currently playing song if a song is currently playing
		Song currentSong = playlist.peek();
		if (currentSong.isPlaying()){
			currentSong.stop();
		}

		checkPlaylistState(); 

		// removes the current song and selects the next valid song to play
		// if filterPlay is true, the next valid song is the next song by filterArtist
		playlist.dequeue();
		while(!playlist.isEmpty() && filterPlay && !playlist.peek().getArtist().equals(filterArtist)){
			playlist.dequeue();
		}

		checkPlaylistState(); 

		// plays the next song in the playlist
		currentSong = playlist.peek();
		currentSong.play();

		checkPlaylistState(); 
	}

	/*
	 * checks if the playlist is currently empty, null, or the playlist at the front of playlist is null
	 * @return true if the playlist is in an invalid state
	 * @throws IllegalStateException if the playlist is in an invalid state
	 */
	private void checkPlaylistState() throws IllegalStateException{
		// throws IllegalStateException if the playlist is null or empty 
		if (playlist.isEmpty() || playlist.equals(null)){
			throw new IllegalStateException("the playlist is empty or null");
		}

		// throws IllegalStateException if the playlist is empty
		Song currentSong = playlist.peek();
		if (currentSong == null){
			throw new IllegalStateException("the playlist is empty");
		}
	}
	/*
	 * pulls the next user input line and returns the input as a list of strings split by whitespace
	 */
	private String[] getUserInput(Scanner in){
		// wait for user input
		String input = in.nextLine();
		// parse the user input
		String[] inputSplit = input.split(" ");
		return inputSplit;
	}

	/*
	 * processes the user input and calls the appropriate methods
	 * @throws IllegalArgumentException if the user input is invalid
	 * @return true if the user input is valid else false
	 */
	private Boolean playModified(String[] inputSplit){
		// verify that the user input is of the correct length
		if (inputSplit.length == 1){
		// play all the songs in the playlist
			 try{
					playNextSong();
				} catch (IllegalStateException e){
					System.out.println("No songs left :(");
				}
				return true;

		} else if (inputSplit.length == 3){

		// check if the user input is -t or -a
			if (inputSplit[1].equals("-t")){
				try{
					// dequeue songs until the song title matches the user input
					while(!playlist.peek().getTitle().equals(inputSplit[2])){
						playlist.dequeue();
					}
					playNextSong();
				} catch (IllegalStateException e){
					System.out.println("No songs left :(");
				}
		
			} else if (inputSplit[1].equals("-a")){
				// play the first song by the given artist
				try{
					filterPlay = true;
					filterArtist = inputSplit[2];
					playNextSong();
				} catch (IllegalStateException e){
					System.out.println("No songs left :(");
				}
			}
		}
		return false;
	}
	
	/*
	 * if filterPlay is true, deques songs until the song artist matches the filterArtist
	 * else plays the next song in the playlist
	 */

	
	/*
	 * displays the MusicPlayer300 menu, takes user input, verifies the user input, and executes the user input
	 */
	public void runMusicPlayer300(Scanner in){
		Boolean invalidInput;
		String artist;
		String title;
		String[] userInputs;
		File file;
		

		while(true){
			// prompt the user for input
			System.out.println("Enter one of the following options:");
			
			// display the menu
			String menu = getMenu();
			System.out.println(menu);

			// get the user input
			userInputs = getUserInput(in);
			
			invalidInput = false; // assume the user input is valid

			// evaluate the user input using a switch statement
			switch (userInputs[0]){
				
				case "A": // enqueue a new song file to the end of this playlist
					// verify that the user input is of the correct length
					if (userInputs.length != 2) {
						invalidInput = true;
						break;
					}
					// ask the user for a song title and verify that the user input is of the correct length
					System.out.println("Title:");
					title = in.nextLine();
					if (title.strip().equals("") || title == null || title.length() != 1){
						invalidInput = true;
						break;
					}

					// ask the user for a song artist and verify that the user input is of the correct length
					System.out.println("Artist:");
					artist = in.nextLine();
					if (artist.strip().equals("") || artist == null || artist.length() != 1){
						invalidInput = true;
						break;
					}
					// load the song
					try {
						loadOneSong(title, artist, userInputs[1]);
					} catch (IllegalArgumentException e){
						invalidInput = true;
						break;
					}
					break;
				case "F": // load a new playlist from the given file
					// verify that the user input is of the correct length
					if (userInputs.length != 2) {
						invalidInput = true;
						break;
					}
					// load the playlist
					try {
						System.out.println(userInputs[1]);
						file = new File(userInputs[1]);
						loadPlaylist(file);
					} catch (FileNotFoundException e){
						invalidInput = true;
						break;
					}
					break;
				case "L": // list all songs in the current playlist
					// verify that the user input is of the correct length
					if (userInputs.length != 1) {
						invalidInput = true;
						break;
					}
					// list the songs in the playlist
					printPlaylist();
					
				case "P": // start playing ALL songs in the playlist from the beginning
					invalidInput = playModified(userInputs);
					break;
				case "N": // play the next valid song in the playlist
					try{
						playNextSong();
					} catch (IllegalStateException e){
						System.out.println("No songs left :(");
					}
					break;
				case "Q": // stop playing music and quit the program
				  clear();
					System.out.println("Goodbye!");
					System.exit(0);
					break;

				default: // the user input is incorrect, ask the user to enter a valid input
					invalidInput = true;
					break;
				}
				
				if (invalidInput){
					System.out.println("Invalid input. Please enter a valid input.");
				}
		}
	}

	/*
	 * calls runMusicPlayer300
	 */
	public static void main(String[] args){
		// I understand that the writeup calls for a 1 line main method that calles runMusicPlayer300.
		// MusicPlayer300 is instantiable and must be instantiated before runMusicPlayer300 can be called
		// So, while my code can be written on one line like this:
		// new MusicPlayer300().runMusicPlayer300(new Scanner(System.in));
		// I have chosen to write it as follows because Hobbes has specifically asked us to avoid multiple actions in one line
		MusicPlayer300 musicPlayer300 = new MusicPlayer300();
		Scanner in = new Scanner(System.in);
		musicPlayer300.runMusicPlayer300(in);
		in.close();
	}
}
