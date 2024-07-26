
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ---------------------------------------------------------------------------------------------------- //

public class Player {

    // Global variables
    public static final String FILE_PATH = "/tmp/players.csv";
    // public static final String FILE_PATH = "players.csv";
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    // -------------------------- //

    // Attributes
    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int yearOfBirth;
    private String birthCity;
    private String birthState;

    // Empty constructor
    public Player() {

        this.id = 0;
        this.name = "";
        this.height = 0;
        this.weight = 0;
        this.college = "";
        this.yearOfBirth = 0;
        this.birthCity = "";
        this.birthState = "";
    }

    // Constructor
    public Player(int id, String name, int height, int weight, String college, int yearOfBirth, String birthCity,
                  String birthState) {

        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.yearOfBirth = yearOfBirth;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }

    // Gets
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getCollege() {
        return this.college;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public String getBirthCity() {
        return this.birthCity;
    }

    public String getBirthState() {
        return this.birthState;
    }

    // Sets
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    // Clone
    public Player clone() {
        return new Player(this.id, this.name, this.height, this.weight, this.college, this.yearOfBirth, this.birthCity,
                this.birthState);
    }

    // Print
    public void print() {

        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
                this.id, this.name, this.height, this.weight, this.yearOfBirth, this.college, this.birthCity,
                this.birthState);
    }

    // Read
    public void read(String line) {

        // Split line by ","
        String[] splitted = line.split(",", -1);

        // Fill empty attributes
        for (int i = 0; i < splitted.length; i++) {

            if (splitted[i].equals(""))
                splitted[i] = "nao informado";
        }

        // Set attributes
        this.id = Integer.parseInt(splitted[0]);
        this.name = splitted[1].replace("*", "");
        this.height = Integer.parseInt(splitted[2]);
        this.weight = Integer.parseInt(splitted[3]);
        this.college = splitted[4];
        this.yearOfBirth = Integer.parseInt(splitted[5]);
        this.birthCity = splitted[6];
        this.birthState = splitted[7];
    }

    // ----------------------------------------------------------------------------------------------------
    // //
    // No da arvore binaria de arvore binaria
    class Hash {
        private int hash, reserveHash, counter;
        private String[] playerNames;

        Hash() {
            hash = 21;
            reserveHash = 9;
            counter = hash;
            playerNames = new String[hash + reserveHash];
        }

        // Metodo para fazer o calculo do Hash
        private int hash(String name) {
            int sun = 0;

            for (int i = 0; i < name.length(); i++) {
                sun += name.charAt(i);
            }

            return sun % hash;
        }

        // Metodo de Inserir Elementos no Hash
        public void insert(String playerName) {
            int position = hash(playerName);

            if (playerNames[position] == null) {
                if (position < hash) {
                    playerNames[position] = playerName;
                } else {
                    // System.out.println("Insert Hash > 21");
                }

            } else {
                if (counter <= playerNames.length - 1) {
                    playerNames[counter++] = playerName;
                } else {
                    // System.out.println("Insert Hash Rehash > 9");
                }
            }
        }

        // Metodo de Remover Elementos no Hash
        public void remove(String name) {
            int position = hash(name);

            if (playerNames[position] != null && playerNames[position].equals(name)) {
                playerNames[position] = null;

                for (int i = playerNames.length - reserveHash; i <= counter; i++) {
                    if (hash(playerNames[i]) == position && i < playerNames.length) {
                        playerNames[position] = playerNames[i];
                        playerNames[i] = playerNames[counter];
                        playerNames[counter--] = null;
                        i = counter;
                    }
                }
            } else {
                for (int i = playerNames.length - reserveHash; i <= counter; i++) {
                    if (i < playerNames.length && name.equals(playerNames[i])) {
                        playerNames[i] = playerNames[counter];
                        playerNames[counter--] = null;
                        i = counter;
                    }
                }
            }

            if (counter < hash) {
                counter = hash;
            }
        }

        // Metodo de Pesquisar Elementos no Hash
        public boolean search(String name) {
            boolean resp = false;
            int position = hash(name);

            if (position >= 0 && position < playerNames.length && playerNames[position] != null && playerNames[position].equals(name)) {
                resp = true;
                //System.out.println("Posicao: " + position);
            } else {
                for (int i = 0; i < playerNames.length && i <= counter; i++) {
                    if (name.equals(playerNames[i])) {
                        //System.out.println("Posicao: " + i);
                        resp = true;
                        break; // Sair do loop se encontrar a correspondência
                    }
                }
            }

            return resp;
        }

        // Metodo de Mostrar Todos os Elementos do Hash
        public void show() {
            for (int i = 0; i < playerNames.length; i++) {
                if (playerNames[i] != null) {
                    System.out.println(playerNames[i]);
                }
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // //
    // Read all players function
    public static void startPlayers() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                // Initialize player
                Player player = new Player();

                // Read line
                player.read(line);

                // Add player to array
                allPlayers.add(player);
            }

            // Close CSV file
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // //

    // Search by id function
    public static Player searchById(int id, ArrayList<Player> players) {

        // Search for player
        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getId() == id)
                return players.get(i);
        }
        return null;
    }

    // Search by name function
    public static Player searchByName(String name, ArrayList<Player> players) {

        // Search for player
        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getName().equals(name))
                return players.get(i);
        }
        return null;
    }

    // ----------------------------------------------------------------------------------------------------
    // //

    public static void main(String[] args) throws Exception {

        // ----------------------------------------------------------------- //

        // #1 - Start - Read all players in CSV file
        startPlayers();

        // ----------------------------------------------------------------- //
        // #2 - Start - Start binary tree and player

        Player player = new Player();
        Hash tabeleNomes = player.new Hash();
        // ----------------------------------------------------------------- //

        // #3 - Read input and print players from pub.in id entries

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Read first line
        String line = inScanner.nextLine();

        // While line is not "FIM
        while (!line.equals("FIM")) {

            // Get id
            int id = Integer.parseInt(line);

            // Search for player
            player = searchById(id, allPlayers);
            // System.out.println(player.getName());

            // Insert player by id
            tabeleNomes.insert(player.name);
            // lista.mostrar();
            // Read line
            line = inScanner.nextLine();
        }

        // ----------------------------------------------------------------- //
        // #4 - Read input and execute commands

        String line2 = inScanner.nextLine();

        while (!line2.equals("FIM")) {

            Player playerTmp = new Player();
            playerTmp = searchByName(line2, allPlayers);

            System.out.print(line2);
            if (tabeleNomes.search(line2)) {
                System.out.print(" SIM\n");

            } else {
                System.out.print(" NAO\n");
            }

            line2 = inScanner.nextLine();
        }

        // ----------------------------------------------------------------- //

        // Close scanner
        inScanner.close();
    }

}
// ----------------------------------------------------------------------------------------------------
// //