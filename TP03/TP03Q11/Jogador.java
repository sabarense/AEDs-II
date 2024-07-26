package TP03.TP03Q11;

class Jogador {
    private int playerId;
    private String playerName;
    private int playerHeight;
    private int playerWeight;
    private String playerUniversity;
    private int playerBirthYear;
    private String playerBirthCity;
    private String playerBirthState;

    public static void main(String[] args) {
        Jogador[] players = new Jogador[3923];
        Arq file = new Arq();
        String str;
        file.openRead("/tmp/players.csv");
        str = file.readLine();
        for (int i = 0; i < 3922; i++) {
            str = file.readLine();
            players[i] = new Jogador();
            players[i].read(str);
        }
        file.close();

        String input = MyIO.readLine();
        int id;
        FlexList playersClone = new FlexList();

        while (!(input.equals("FIM"))) {
            id = Integer.parseInt(input);
            playersClone.insert(players[id]);

            input = MyIO.readLine();
        }

        playersClone.quickSort();
        playersClone.show();
    }

    Jogador() {
        playerId = -1;
        playerName = "";
        playerHeight = -1;
        playerWeight = -1;
        playerUniversity = "";
        playerBirthYear = -1;
        playerBirthCity = "";
        playerBirthState = "";
    }

    Jogador(int id, String name, int height, int weight, String university, int birthYear, String birthCity, String birthState) {
        this.playerId = id;
        this.playerName = name;
        this.playerHeight = height;
        this.playerWeight = weight;
        this.playerUniversity = university;
        this.playerBirthYear = birthYear;
        this.playerBirthCity = birthCity;
        this.playerBirthState = birthState;
    }

    public void setPlayerId(int id) {
        this.playerId = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerHeight(int height) {
        this.playerHeight = height;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerWeight(int weight) {
        this.playerWeight = weight;
    }

    public int getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerUniversity(String university) {
        this.playerUniversity = university;
    }

    public String getPlayerUniversity() {
        return playerUniversity;
    }

    public void setPlayerBirthYear(int birthYear) {
        this.playerBirthYear = birthYear;
    }

    public int getPlayerBirthYear() {
        return playerBirthYear;
    }

    public void setPlayerBirthCity(String birthCity) {
        this.playerBirthCity = birthCity;
    }

    public String getPlayerBirthCity() {
        return playerBirthCity;
    }

    public void setPlayerBirthState(String birthState) {
        this.playerBirthState = birthState;
    }

    public String getPlayerBirthState() {
        return playerBirthState;
    }

    public void print() {
        MyIO.println("[" + playerId + " ## " + playerName + " ## " + playerHeight + " ## " + playerWeight + " ## " +
                playerBirthYear + " ## " + playerUniversity + " ## " + playerBirthCity + " ## " + playerBirthState + "]");
    }

    public void read(String s) {
        String[] array = s.split(",", 8);
        this.playerId = Integer.parseInt(array[0]);
        this.playerName = array[1].isEmpty() ? "nao informado" : array[1];
        this.playerHeight = Integer.parseInt(array[2]);
        this.playerWeight = Integer.parseInt(array[3]);
        this.playerUniversity = array[4].isEmpty() ? "nao informado" : array[4];
        this.playerBirthYear = Integer.parseInt(array[5]);
        this.playerBirthCity = array[6].isEmpty() ? "nao informado" : array[6];
        this.playerBirthState = array[7].isEmpty() ? "nao informado" : array[7];
    }

    public void clonePlayer(Jogador p) {
        this.playerId = p.playerId;
        this.playerName = p.playerName;
        this.playerHeight = p.playerHeight;
        this.playerWeight = p.playerWeight;
        this.playerUniversity = p.playerUniversity;
        this.playerBirthYear = p.playerBirthYear;
        this.playerBirthCity = p.playerBirthCity;
        this.playerBirthState = p.playerBirthState;
    }
}

class DoubleCell {
    public Jogador element;
    public DoubleCell next;
    public DoubleCell previous;

    DoubleCell() {
        this(new Jogador());
    }

    DoubleCell(Jogador element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }
}

class FlexList {
    public static DoubleCell first, last;

    FlexList() {
        first = new DoubleCell();
        last = first;
    }

    public void insert(Jogador player) {
        last.next = new DoubleCell(player);
        last = last.next;
    }

    public void show() {
        DoubleCell i;
        for (i = first.next; i != null; i = i.next) {
            i.element.print();
        }
    }

    public static void swapPlayers(Jogador p1, Jogador p2) {
        Jogador tmp = new Jogador();
        tmp.clonePlayer(p1);
        p1.clonePlayer(p2);
        p2.clonePlayer(tmp);
    }

    public void quickSort() {
        quickSort(first.next, null);
    }

    private void quickSort(DoubleCell left, DoubleCell right) {
        if (left != right) {
            DoubleCell pivot = partition(left, right);
            quickSort(left, pivot);
            quickSort(pivot.next, right);
        }
    }

    private DoubleCell partition(DoubleCell left, DoubleCell right) {
        DoubleCell i = left;
        DoubleCell j = left.next;
        Jogador pivot = left.element;

        while (j != right) {
            int stateComparison = compareStates(j.element.getPlayerBirthState(), pivot.getPlayerBirthState());

            if (stateComparison < 0 || (stateComparison == 0 && j.element.getPlayerName().compareTo(pivot.getPlayerName()) <= 0)) {
                i = i.next;
                swapPlayers(i.element, j.element);
            }
            j = j.next;
        }

        swapPlayers(i.element, left.element);
        return i;
    }

    private int compareStates(String state1, String state2) {
        return state1.compareTo(state2);
    }
}