package GOOGLE;

public class GoogleMember {

    //필드
    private String gId;
    private String gPw;
    private String gName;
    private String gBirth;
    private String gGender;
    private String gPhone;
    //생성자

    public GoogleMember() {
    }

    public GoogleMember(String gId, String gPw,String gName, String gBirth, String gGender,  String gPhone) {
        this.gId = gId;
        this.gPw = gPw;
        this.gName = gName;
        this.gBirth = gBirth;
        this.gGender = gGender;
        this.gPhone = gPhone;
    }
    //메소드

    public String getgName() {
        return gName;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgPw() {
        return gPw;
    }

    public void setgPw(String gPw) {
        this.gPw = gPw;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgBirth() {
        return gBirth;
    }

    public void setgBirth(String gBirth) {
        this.gBirth = gBirth;
    }

    public String getgGender() {
        return gGender;
    }

    public void setgGender(String gGender) {
        this.gGender = gGender;
    }

    public String getgPhone() {
        return gPhone;
    }

    public void setgPhone(String gPhone) {
        this.gPhone = gPhone;
    }

    @Override
    public String toString() {
        return "GoogleMember{" +
                ", gId='" + gId + '\'' +
                ", gPw='" + gPw + '\'' +
                "gName='" + gName + '\'' +
                ", gBirth='" + gBirth + '\'' +
                ", gGender='" + gGender + '\'' +
                ", gPhone='" + gPhone + '\'' +
                '}';
    }
}
