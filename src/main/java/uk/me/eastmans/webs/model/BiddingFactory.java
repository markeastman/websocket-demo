package uk.me.eastmans.webs.model;

public class BiddingFactory {

    private static Bidding bidding;

    // obtain a singleton instance of the Bidding
    public static synchronized Bidding getBidding() {
        if (bidding == null) {
            resetBidding();
        }
        // expire the Bidding if there's no more seconds left for the due date
        if (bidding.getSecondsLeft() != null && bidding.getSecondsLeft() <= 0) {
            bidding.expire();
        }
        return bidding;
    }

    // creates a new bidding
    public static synchronized void resetBidding() {
        Item item = new Item("1 Red Fedora Hat", "A beautiful red fedora hat that makes you charming!", 1000, "/resources/gfx/redfedora1.jpg");
        bidding = new Bidding(item, 100);
    }
}
