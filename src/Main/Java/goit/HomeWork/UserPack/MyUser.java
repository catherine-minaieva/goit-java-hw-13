package Main.Java.goit.HomeWork.UserPack;
import java.util.Objects;

public class MyUser {
        private int id;
        private String name;
        private String username;
        private String email;
        private String phone;
        private String website;
        private UserAdress address;
        private UserCompany company;

        public MyUser() {
                this.id = id;
                this.name = name;
                this.username = username;
                this.email = email;
                this.phone = phone;
                this.website = website;
                this.address = address;
                this.company = company;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getWebsite() {
                return website;
        }

        public void setWebsite(String website) {
                this.website = website;
        }

        public UserAdress getAddress() {
                return address;
        }

        public void setAddress(UserAdress address) {
                this.address = address;
        }

        public UserCompany getCompany() {
                return company;
        }

        public void setCompany(UserCompany company) {
                this.company = company;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", phone='" + phone + '\'' +
                        ", website='" + website + '\'' +
                        ", address=" + address +
                        ", company=" + company +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                MyUser myUser = (MyUser) o;
                return id == myUser.id && Objects.equals(name, myUser.name) && Objects.equals(username, myUser.username) && Objects.equals(email, myUser.email) && Objects.equals(phone, myUser.phone) && Objects.equals(website, myUser.website) && Objects.equals(address, myUser.address) && Objects.equals(company, myUser.company);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, username, email, phone, website, address, company);
        }
}
