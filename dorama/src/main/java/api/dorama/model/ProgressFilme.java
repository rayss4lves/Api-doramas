package api.dorama.model;

import api.dorama.model.enuns.StatusProgress;

public class ProgressFilme extends ProgressDorama{

    private int durationMinutes; // duração total do filme
    private int minutosAssistidos;

    public ProgressFilme(Dorama dorama, int durationMinutes, int minutosAssistidos, StatusProgress status) {
        super(dorama, status);
        this.durationMinutes = durationMinutes;
        setMinutesAssistidos(minutosAssistidos);
    }


    public int getDuracaoMinutes() {
        return durationMinutes;
    }

    public int getMinutesAssistidos() {
        return minutosAssistidos;
    }

    public void setMinutesAssistidos(int minutos) {
        if (minutos < 0) {
            this.minutosAssistidos = 0;
        } else if (minutos > durationMinutes) {
            this.minutosAssistidos = durationMinutes;
        } else {
            this.minutosAssistidos += minutos;
        }
        atualizarStatusAutomaticamente();
    }

    public void adicionarMinutesAssistidos(int minutos) {
        setMinutesAssistidos(this.minutosAssistidos + minutos);
    }

    public void setDuracaoMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public double getProgresso() {
        if (durationMinutes > 0) {
            return (minutosAssistidos * 100.0) / durationMinutes;
        }
        return 0.0;
    }

    protected void atualizarStatusAutomaticamente() {
        if (minutosAssistidos >= durationMinutes && durationMinutes > 0) {
            setStatus(StatusProgress.FINALIZADO);
        } else if (minutosAssistidos > 0) {
            setStatus(StatusProgress.ASSISTINDO);
        } else {
            setStatus(StatusProgress.PAUSADO);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "🎬 %s (%d/%d minutos) - %.1f%% concluído - Status: %s",
                getDorama().getTitle(),
                minutosAssistidos,
                durationMinutes,
                getProgresso(),
                getStatus()
        );
    }
}