package co.com.choucair.services.restapi.model.builder;

import co.com.choucair.services.restapi.util.Builder;
import co.com.choucair.services.restapi.model.User;

public class UserBuilder implements Builder<User> {

    private String name;
    private String job;

    private UserBuilder(String name) {
        this.name = name;
    }

    public static UserBuilder withName(String name){
        return new UserBuilder(name);
    }

    public User andJob(String job) {
        this.job = job;
        return build();
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public User build() {
        return new User(this);
    }
}
