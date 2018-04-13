package krishnas.csvapp;

/**
 * Created by Personal on 13-04-2018.
 */

public class data {
    public String id;
    public String name;
    public String college;
    public long contact_no;
    public String address;
    public String selected;


    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }



    public String getCollege() {

        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }

    public long getContact_no() {

        return contact_no;
    }
    public void setContact_no(long contact_no) {

        this.contact_no = contact_no;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }



    public String getSelected() {

        return selected;
    }
    public void setSelected(String selected)
    {
        this.selected = selected;
    }



    @Override
    public String toString() {
        return "data{" +
                "id='" + id + '\'' + ", name='" + name + '\'' + ", college='" + college + '\'' + ", contact_no='" + contact_no + '\'' + ", address='" + address + '\'' + ", selected=" + selected + '}';
    }
}

