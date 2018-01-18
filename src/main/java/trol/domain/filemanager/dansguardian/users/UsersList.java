package trol.domain.filemanager.dansguardian.users;

import trol.domain.filemanager.FilePaths;
import trol.domain.trol_api.model.User;
import trol.domain.util.FileHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UsersList {
    private Path path;
    private List<User> userList;

    public UsersList(List<User> userList) {
        this.userList = userList;
        path = Paths.get(FilePaths.DANSGUARDIAN_USER_PATH);
    }

    public void saveFile() throws IOException {
        FileHelper.saveStringListAsFile(path, generateFileListString());
    }

    private List<String> generateFileListString(){
        List<String> usersFile = new ArrayList<>();
        userList.forEach(e -> {
            if(canBeAdded(e))
                usersFile.add(e.getUserIp());
        });
        return usersFile;
    }

    private boolean canBeAdded(User u){
        boolean isActive = u.getIsActive();
        boolean hasDurationTimeUsed = !u.getHasDuration() || (u.getDurationInterval() <= u.getUsedTime());
        boolean isNotInAllowedHours = !u.getIsTimed() || LocalTime.now().isAfter(u.getTimeEnd()) || LocalTime.now().isBefore(u.getTimeBegin());
//        return u.getIsActive() &&
//                (!u.getIsTimed() ||
//                        (u.getIsTimed() &&
//                                LocalTime.now().isBefore(u.getTimeBegin()) &&
//                                LocalTime.now().isAfter(u.getTimeEnd())));
        return isActive && hasDurationTimeUsed && isNotInAllowedHours;
        //TODO zweryfikować before i after
        //TODO sprawdzać zużyty czsas
    }
}