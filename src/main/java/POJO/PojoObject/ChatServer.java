package POJO.PojoObject;

import POJO.ChatServerCreateUpdatePojo;

import java.util.ArrayList;

public class ChatServer {

    public static ChatServerCreateUpdatePojo getCreateChatUserObj()
    {
        ChatServerCreateUpdatePojo ob = new ChatServerCreateUpdatePojo();
        ob.setUsername("priyanka555");
        ob.setPassword("priyanka123");
        ob.setName("Priyanka");
        ob.setSurname("xyz");
        ob.setEmail("priyanka@gmail.com");
        ob.setChat_nickname("p1234");

        ArrayList<Integer> dept = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        ob.setDepartments(dept);

        ArrayList<Integer> dept_read = new ArrayList<Integer>() {{
            add(2);
        }};

        ob.setDepartments_read(dept_read);
        ArrayList<Integer> dept_groups = new ArrayList<Integer>() {{
            add(1);
        }};
        ob.setDepartment_groups(dept_groups);
        ArrayList<Integer> user_groups = new ArrayList<Integer>() {{
            add(1);
        }};

        ob.setUser_groups(user_groups);

        return ob;

    }

    public static  ChatServerCreateUpdatePojo getUpdateChatUserObj()
    {
        ChatServerCreateUpdatePojo ob = new ChatServerCreateUpdatePojo();
        ob.setUsername("priyanka111");
        ob.setPassword("priyanka111");
        ob.setName("Priyanka");
        ob.setSurname("xyz");
        ob.setEmail("priyanka@gmail.com");
        ob.setChat_nickname("p1234");

        ArrayList<Integer> dept = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        ob.setDepartments(dept);

        ArrayList<Integer> dept_read = new ArrayList<Integer>() {{
            add(2);
        }};

        ob.setDepartments_read(dept_read);
        ArrayList<Integer> dept_groups = new ArrayList<Integer>() {{
            add(1);
        }};
        ob.setDepartment_groups(dept_groups);
        ArrayList<Integer> user_groups = new ArrayList<Integer>() {{
            add(1);
        }};

        ob.setUser_groups(user_groups);

        return ob;

    }
}
