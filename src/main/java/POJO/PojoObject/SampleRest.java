package POJO.PojoObject;

import POJO.SampleUserCreateUpdatePojo;

public class SampleRest {

    public static SampleUserCreateUpdatePojo getCreateUserObj()
    {
        SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName("morpheus3");
        ob.setJob("HR3");

        return ob;
    }

    public static SampleUserCreateUpdatePojo getUpdateUserObj()
    {
        SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName("morpheus4");
        ob.setJob("HR4");

        return ob;
    }


    public static SampleUserCreateUpdatePojo getCreateUserObj(String name,String job)
    {
        SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName(name);
        ob.setJob(job);

        return ob;
    }

    public static SampleUserCreateUpdatePojo getUpdateUserObj(String name,String job)
    {
        SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName(name);
        ob.setJob(job);

        return ob;
    }
}
