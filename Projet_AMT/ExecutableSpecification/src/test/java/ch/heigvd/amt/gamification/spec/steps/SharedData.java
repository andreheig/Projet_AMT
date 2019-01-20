package ch.heigvd.amt.gamification.spec.steps;

import com.github.javafaker.Faker;

public class SharedData {
    private int statusCode;
    private Faker faker = new Faker();
    private int counter = 1;
    private  String badgeName = faker.funnyName().name();
    private  String scaleName = faker.chuckNorris().fact();
    private String pointRuleEventType = faker.beer().name();

    private final String KEYUUID = "06068b82-d91a-8888-5b39-cd4adb07ae27";
    private final String SECRETUUID = "b7197d93-e3ab-f2ac-e4ac-6e3362289fdc";

    public Faker getFaker(){
        return faker;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public void setStatusCode(int code){
        this.statusCode = code;
    }

    public int getCounter(){
        return this.counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public String getKEYUUID() { return KEYUUID;    }

    public String getSECRETUUID() { return SECRETUUID;    }

    public  String getBadgeName() {  return badgeName;    }

    public void setBadgeName(String badgeName){ this.badgeName = badgeName; }

    public  String getScaleName() {  return scaleName;    }

    public void setScaleName(String scaleName){ this.scaleName = scaleName; }

    public  String getPointRuleEventType() {  return pointRuleEventType;    }

    public void setPointRuleEventType(String pointRuleEventType){ this.pointRuleEventType = pointRuleEventType; }
}
