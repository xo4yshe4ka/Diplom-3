package client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCredentials {
    private String email;
    private String password;

    public static UserCredentials from (User user) {
        return new UserCredentials(user.getEmail(), user.getPassword());
    }
}
