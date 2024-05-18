package api.endpoints;

/*Swagger URI --> https://petstore.swagger.io
 * create user(post): https://petstore.swagger.io/v2/user
 * get user: https://petstore.swagger.io/v2/user/{userName}
 * update user: https://petstore.swagger.io/v2/user/{userName}  
 * delete user: https://petstore.swagger.io/v2/user/{userName}  */


public class Routes {
    public static String base_url ="https://petstore.swagger.io/v2";
    
    //user module
    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String update_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";
    
    
    //reqres user module
    
}
