package devarea.fr.discord.workers;

import devarea.fr.discord.entity.ActionEvent;
import devarea.fr.utils.Logger;

public class TestWorker implements Worker {
    @Override
    public void onStart() {
        Logger.logMessage("TestWorker Created !");
    }

    @Override
    public ActionEvent<?> setupEvent() {
        return null;
    }

    @Override
    public void onStop() {

    }
}
