package tnc16_coh5_d_r273.blind_blackjack;

/**
 *  An object of type Hand represents a hand of cards.  The maximum number of
 *  cards in the hand can be specified in the constructor, but by default
 *  is 5.  A utility function is provided for computing the value of the
 *  hand in the game of Blackjack.
 */

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;   // The cards in the hand.

    public Hand() {
        // Create a Hand object that is initially empty.
        hand = new ArrayList<>();
    }

    public void clear() {
        // Discard all the cards from the hand.
        hand.clear();
    }

    public void addCard(Card c) {
        // Add the card c to the hand.  c should be non-null.  (If c is
        // null, nothing is added to the hand.)
        if (c != null)
            hand.add(c);
    }

    public void removeCard(Card c) {
        // If the specified card is in the hand, it is removed.
        hand.remove(c);
    }

    public void removeCard(int position) {
        // If the specified position is a valid position in the hand,
        // then the card in that position is removed.
        if (position >= 0 && position < hand.size())
            hand.remove(position);
    }

    public int getCardCount() {
        // Return the number of cards in the hand.
        return hand.size();
    }

    public Card getCard(int position) {
        // Get the card from the hand in given position, where positions
        // are numbered starting from 0.  If the specified position is
        // not the position number of a card in the hand, then null
        // is returned.
        if (position >= 0 && position < hand.size())
            return hand.get(position);
        else
            return null;
    }

    public void sortBySuit() {
        // Sorts the cards in the hand so that cards of the same suit are
        // grouped together, and within a suit the cards are sorted by value.
        // Note that aces are considered to have the lowest value, 1.
        ArrayList<Card> newHand = new ArrayList<>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void sortByValue() {
        // Sorts the cards in the hand so that cards of the same value are
        // grouped together.  Cards with the same value are sorted by suit.
        // Note that aces are considered to have the lowest value, 1.
        ArrayList<Card> newHand = new ArrayList<>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if (c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
}