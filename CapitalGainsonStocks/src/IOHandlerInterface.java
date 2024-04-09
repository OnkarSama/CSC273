/**
 * IOHandlerInterface: specifies an ADT for handling of input, e.g.
 * I/O can be based on standard input and output, or dialog boxes
 * as implemented in concrete classes IOHandlerStandard and IOHandlerDialog
 * respectively, which implement this interface.
 */

public interface IOHandlerInterface
{
    /**
     * get:
     * @param prompt prompt.
     * @return String from input source.
     */
    public String get(String prompt);

    /**
     * put:
     * @param output to write to the selected destination.
     */
    public void put(String output);

    /**
     * getFromList:
     * @param listTitle of type String
     * @param prompt of type String
     * @param choices of type String
     * @return String that was input by the user.
     */
    public String getFromList(String listTitle, String prompt, String[] choices);
} // end IOHandler