package Main.Java.goit.HomeWork;

import Main.Java.goit.HomeWork.UserActions.Comment;
import Main.Java.goit.HomeWork.UserActions.Task;
import Main.Java.goit.HomeWork.UserPack.MyUser;
import Main.Java.goit.HomeWork.UserPack.UserAdress;
import Main.Java.goit.HomeWork.UserPack.UserCompany;
import Main.Java.goit.HomeWork.UserPack.UserGeo;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static Main.Java.goit.HomeWork.MyHttpUtil.getUserById;

public class Main {

    private static final MyUser DEFAULT_USER = getUserById(3);
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        //Task1.1 POST/user
        MyUser myUser1 = createNewUser();
        final MyUser createdMyUser = MyHttpUtil.sendPost(URI.create(USER_URL), myUser1);
        System.out.println("Task 1.1 " + createdMyUser + "\n");

        //Task1.2 PUT/
        MyUser updatedUser = new MyUser();
        updatedUser.setName("Maria");
        updatedUser.setUsername("NewUserName");

        MyUser updated = MyHttpUtil.sendPut(3, updatedUser);
        System.out.println("Task 1.2 " + updated + "\n");

        //Task1.3 DELETE/ user
        int sendDelete = MyHttpUtil.sendDelete(3);
        System.out.println("Task 1.3 " + sendDelete + "\n");

        //Task1.4 GET/all users
        final List<MyUser> users = MyHttpUtil.sendGetWithListOfResults(URI.create(USER_URL));
        System.out.println("Task 1.4 " + users + "\n");

        //Task1.5 GET/user/{id}
        final MyUser userById = getUserById(DEFAULT_USER.getId());
        System.out.println("Task 1.5 " + userById + "\n");

        //Task1.6 GET/user/{username}
        final MyUser byName = MyHttpUtil.getUserByName(DEFAULT_USER.getUsername());
        System.out.println("Task 1.6 " + DEFAULT_USER.getUsername() + "\n" + byName + "\n");

        //Task 2 all comments to last post
        List<Comment> allCommentToLastPostOfUser = MyHttpUtil.getAllCommentsForLastPostOfUser(userById);
        System.out.println("Task 2. User's id=" + DEFAULT_USER.getId() + " last post's comments are");
        allCommentToLastPostOfUser.forEach(System.out::println);
        System.out.println("\n");

        // Task 3 get all uncompleted tasks
        List<Task> allUncompleted = MyHttpUtil.getAllUncompletedToDos(userById);
        System.out.println("Task 3\n " + DEFAULT_USER.getId());
        allUncompleted.forEach(System.out::println);
    }

    private static MyUser createNewUser() {
        MyUser myUser = new MyUser();
        myUser.setId(11);
        myUser.setName("Elina Svitolina");
        myUser.setUsername("Sweete");
        myUser.setEmail("svit@gmail.com");
        myUser.setAddress(createNewAddress());
        myUser.setPhone("23232-32323");
        myUser.setWebsite("svitol@gmail.com");
        myUser.setCompany(createNewCompany());
        return myUser;
    }

    private static UserCompany createNewCompany() {
        UserCompany company = new UserCompany();
        company.setName("WTA-tour");
        company.setCatchPhrase("Women Tennis Association");
        company.setBs("tennis e-markets");
        return company;
    }

    private static UserAdress createNewAddress() {
        UserAdress address = new UserAdress();
        address.setStreet("Rognidinskaya");
        address.setSuite("4a? of/ 10");
        address.setCity("Kiev");
        address.setZipcode("43194240");
        address.setGeo(createNewGeo());
        return address;
    }

    private static UserGeo createNewGeo() {
        UserGeo geo = new UserGeo();
        geo.setLat("-38.4962");
        geo.setLng("83.8888");
        return geo;
    }

}

