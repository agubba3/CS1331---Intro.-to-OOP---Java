public class Card5 {
    private final String[] VALID_RANKS =
{"2", "3", "4", "5", "6", "7", "8", "9",
"10", "jack", "queen", "king", "ace"};
private String rank;
private String suit;

public void setRank(String rank) {
    if (!isValidRank(rank)) {
        System.out.println(rank + " is not a valid rank.");
        System.exit(0);

    }
            this.rank = rank;
}
public void setSuit(String suit) {
this.suit = suit;
}

public String toString() {
return rank + " of " + suit;
}

private boolean isValidRank(String someRank) {
return contains(VALID_RANKS, someRank);
}

private boolean contains(String[] array, String item) {
for (String element: array) {
if (element.equals(item)) {
return true;
}
}
return false;
}
}
