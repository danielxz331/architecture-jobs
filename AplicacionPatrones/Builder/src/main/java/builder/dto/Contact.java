package builder.dto;

public class Contact {
    private String name;
    private Phone phone;
    private Address address;

    public Contact() {}

    public Contact(String name, Phone phone,Address address) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    /** GET and SET */
}
