package devarea.fr.web.backend.rest;

import devarea.fr.db.DBManager;
import devarea.fr.discord.entities.Mem;
import devarea.fr.discord.workers.self.AuthWorker;
import devarea.fr.utils.Logger;
import devarea.fr.web.backend.entities.userInfos.WebPrivateUserInfos;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class ControllerAuth {

    @GetMapping("/auth/get")
    public static WebPrivateUserInfos getUserInfo(@RequestParam(value = "code") final String code) {
        Mem mem = AuthWorker.getMemberOfCode(code);
        Logger.logMessage(mem.entity.getTag() + " retrieved his datas. (Site input)");
        return new WebPrivateUserInfos(mem);
    }

    @GetMapping("/auth/delete-account")
    public static boolean removeBinding(@RequestParam(value = "code") final String code) {
        DBManager.deleteAuthCodeOf(DBManager.getMemberOfCode(code));
        return true;
    }
}
