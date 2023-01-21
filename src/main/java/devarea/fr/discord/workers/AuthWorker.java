package devarea.fr.discord.workers;

import devarea.fr.db.DBManager;
import devarea.fr.discord.entity.ActionEvent;
import devarea.fr.discord.entity.events_filler.MemberLeaveEventFiller;
import devarea.fr.utils.Logger;

import static devarea.fr.utils.PasswordGenerator.passwordGenerator;

public class AuthWorker implements Worker {

    public static String getCodeForMember(String id) {
        String code = DBManager.getAuthCodeOf(id);
        if (code != null)
            return code;
        return addNewAuthForUser(id);
    }

    private static String addNewAuthForUser(final String memberID) {
        final String code = passwordGenerator.generate(30);
        DBManager.setAuthCodeOf(memberID, code);
        return code;
    }

    @Override
    public void onStart() {
        Logger.logMessage("AuthWorker Created !");
    }

    @Override
    public ActionEvent<?> setupEvent() {
        return (ActionEvent<MemberLeaveEventFiller>) event -> {
            DBManager.deleteAuthCodeOf(event.memberId.asString());
        };
    }

    @Override
    public void onStop() {

    }
}
