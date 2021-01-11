package task4;

import java.io.Serializable;

public class UserMessage extends User implements Serializable {
    // UserMessage类继承User类
    private String type;

    public UserMessage(){

    }

    public UserMessage(String name, String passWord, String type) {
        super(name, passWord);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
