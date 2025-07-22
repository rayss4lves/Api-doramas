package api.dorama.model;
//import api.dorama.model.Dorama;
import api.dorama.model.enuns.StatusProgress;

public class ProgressDorama {

    private Dorama dorama;
    private StatusProgress status;

    public ProgressDorama(Dorama dorama, StatusProgress status) {
        this.dorama = dorama;
        this.status = status;
    }

    public Dorama getDorama() {
        return dorama;
    }

    public StatusProgress getStatus() {
        return status;
    }

    public void setStatus(StatusProgress status) {
        this.status = status;
    }



}
