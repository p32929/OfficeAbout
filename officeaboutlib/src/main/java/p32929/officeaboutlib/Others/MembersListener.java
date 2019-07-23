package p32929.officeaboutlib.Others;

import p32929.officeaboutlib.Models.OfficeInfo;

public interface MembersListener {
    void onJsonDataReceived(OfficeInfo officeInfo);

    void onError(String error);
}
