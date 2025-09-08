package collection.practice;

public class Card implements Comparable<Card> {

    private final CardType cardType;
    private final int number;

    public Card(CardType cardType, int number) {
        this.cardType = cardType;
        this.number = number;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Card anotherCard) {
        // 숫자 먼저 비교 후, 숫자가 같으면 마크 비교
        if (this.number != anotherCard.number) {
            return Integer.compare(this.number, anotherCard.number);
        } else {
            return this.cardType.compareTo(anotherCard.cardType);
        }
    }

    @Override
    public String toString() {
        return number + " ( " + cardType.getIcon() + " ) ";
    }
}
