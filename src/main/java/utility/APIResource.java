package utility;

public enum APIResource {

    createUser("/api/users"),
    updateUser("/api/users/2"),
    deleteUser("/api/users/2"),
    getAllUsers("/api/users"),
    getSingleUser("/api/users/2");
    private String resource;

    APIResource(String resource) { // spelling mistake 'c' /'s'
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
