package playerQueues;
import fleet.Navio;

public interface PlayersVesselQueue {
    public boolean  emptyQueue();
    public Navio getElement(); 
    public void removeElement();   
}
