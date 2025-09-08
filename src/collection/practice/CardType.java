package collection.practice;


public enum CardType {
    SPADE("♠"),
    HEART("♥"),
    DIAMOND("♦"),
    CLOVER("♣");

    private String icon;

    CardType(String icon) {
        this.icon = icon;
    }

    String getIcon() {
        return icon;
    }
}
