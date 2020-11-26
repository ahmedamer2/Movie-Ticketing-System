public class AuthenticationSystem {
    public RegisteredUser verifyCredentials(String email, String pass) {
        DBManager db = DBManager.getInstance();
        RegisteredUser user = db.getUser(email);
        if (user == null || !user.getPassword().equals(pass))
            return user;
        return null;
    }

    public boolean registerNewUser(RegisteredUser user) {
        DBManager db = DBManager.getInstance();
        return db.addUser(user);
    }
}
