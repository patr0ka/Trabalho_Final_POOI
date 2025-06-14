package playerQueues;
import fleet.ContraTorpedeiro;
import fleet.Navio;
import fleet.Patrulheiro;
import fleet.PortaAvioes;
import fleet.Submarino;
import java.util.LinkedList;
import java.util.Queue;

public class VesselQueue implements PlayersVesselQueue{
    private final Queue<Navio> vesselQueue = new LinkedList<>();
    private final Navio portaAvioes = new PortaAvioes();
    private final Navio contraTorpedeiro = new ContraTorpedeiro();
    private final Navio submarino1 = new Submarino();
    private final Navio submarino2 = new Submarino();
    private final Navio patrulheiro1 = new Patrulheiro();
    private final Navio patrulheiro2 = new Patrulheiro();
    private final Navio patrulheiro3 = new Patrulheiro();

    public VesselQueue() {
        vesselQueue.add(portaAvioes);
        vesselQueue.add(contraTorpedeiro);
        vesselQueue.add(submarino1);
        vesselQueue.add(submarino2);
        vesselQueue.add(patrulheiro1);
        vesselQueue.add(patrulheiro2);
        vesselQueue.add(patrulheiro3);
    }

    @Override
    public boolean  emptyQueue() {
        return vesselQueue.isEmpty();
    }

    @Override
    public Navio getElement() {
        return vesselQueue.peek();
    }

    @Override
    public void removeElement() {
        vesselQueue.poll();
    }
}
