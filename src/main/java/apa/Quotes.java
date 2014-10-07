package apa;

/**
 * Success and failure quotes.
 */
public class Quotes {
    private final static String[] QUOTES_SUCCESS = {
            "For the Emperor!",
            "Space Marines, ATTACK!",
            "Cleanse, Purge, KILL!",
            "I will destroy their minds and burn their bodies",
            "An open mind is like a fortress with its gates unbarred and unguarded",
            "Walk softly, and carry a big gun",
            "What would you have me do?",
            "The Emperor guides my blade",
            "NONE CAN WITHSTAND OUR FAITH!",
            "He who stands with me shall be my brother."};

    private final static String[] QUOTES_FAILURE = {
            "Only in death does duty end.",
            "It is better to die for the Emperor than to live for yourself.",
            "Cowards die in shame.",
            "Life is the Emperor's currency, spend it well.",
            "Death by thy Compass.",
            "Victory needs no explanation, defeat allows none.",
            "Hatred is the emperor's greatest gift to humanity."
    };

    /** Returns a random quote string. */
    public static String getSuccessQuote() {
        return QUOTES_SUCCESS[Util.randInt(0, QUOTES_SUCCESS.length - 1)];
    }

    public static String getFailureQuote() {
        return QUOTES_FAILURE[Util.randInt(0, QUOTES_FAILURE.length - 1)];
    }
}
