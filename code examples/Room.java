public class Room
{
    int NumOfBeds;

    public Room(int numOfBeds)
    {
        NumOfBeds = numOfBeds;
    }

    public int getNumOfBeds()
    {
        return NumOfBeds;
    }

    public void setNumOfBeds(int numOfBeds)
    {
        NumOfBeds = numOfBeds;
    }

    @Override
    public String toString()
    {
        return "Room{" +
                "NumOfBeds=" + NumOfBeds +
                '}';
    }
}
