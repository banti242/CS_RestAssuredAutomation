package api.endpoints;

public class Routes {
	/*
	 * https://petstore.swagger.io/v2/user create User GET
	 * https://petstore.swagger.io/v2/user/{username} Update User PUT
	 * https://petstore.swagger.io/v2/user/{username} Delete User DELETE
	 * https://petstore.swagger.io/v2/user/{username} get user
	 * 
	 */

	public static String base_url = "https://petstore.swagger.io/v2";

	// user module url

	public static String post_url = base_url + "/user";

	public static String get_url = base_url + "/user/{username}";

	public static String update_url = base_url + "/user/{username}";

	public static String delete_url = base_url + "/user/{username}";

}
