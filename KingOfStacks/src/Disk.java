/**
 * Represents a disk in the "King of Stacks" game.
 */
public class Disk {

    // Player marker associated with the disk
    private int playerMarker;

    /**
     * Constructs a disk with the specified player marker.
     *
     * @param playerMarker The player marker associated with the disk.
     */
    public Disk(int playerMarker) {

        this.playerMarker = playerMarker;
    }

    /**
     * Gets the player marker associated with the disk.
     *
     * @return The player marker.
     */
    public int getPlayerMarker() {

        return playerMarker;
    }

}
