package api.dorama.model;

import api.dorama.model.enuns.StatusProgress;

public class ProgressSerie extends ProgressDorama{

    private int watchedEpisodes;
    private int totalEpisodes;

    public ProgressSerie(Dorama dorama, int totalEpisodios, int episodios, StatusProgress status) {
        super(dorama, status);
        this.totalEpisodes = totalEpisodios;
        setEpisodesAssistidos(episodios);
    }

    public int getEpisodesAssistidos() {
        return watchedEpisodes;
    }

    public void setEpisodesAssistidos(int watchedEpisodes) {
        if (watchedEpisodes < 0) {
            this.watchedEpisodes = 0;
        } else if (watchedEpisodes > totalEpisodes) {
            this.watchedEpisodes = totalEpisodes;
        } else {
            this.watchedEpisodes = watchedEpisodes;
        }

        atualizarStatusAutomaticamente();
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
        atualizarStatusAutomaticamente();
    }

    public void marcarEpisodioAssistido() {
        if (watchedEpisodes < totalEpisodes) {
            watchedEpisodes++;
            atualizarStatusAutomaticamente();
        }
    }

    public double getProgresso() {
        if (totalEpisodes > 0) {
            return (watchedEpisodes * 100.0) / totalEpisodes;
        }
        return 0.0;
    }

    public void atualizarStatusAutomaticamente() {
        if (watchedEpisodes >= totalEpisodes && totalEpisodes > 0) {
            setStatus(StatusProgress.FINALIZADO);
        } else {
            setStatus(StatusProgress.ASSISTINDO);
        }
    }


    @Override
    public String toString() {
        return String.format(
                "%s (%d/%d episódios) - %.1f%% concluído - Status: %s",
                getDorama().getTitle(),
                watchedEpisodes,
                totalEpisodes,
                getProgresso(),
                getStatus()
        );
    }
}
